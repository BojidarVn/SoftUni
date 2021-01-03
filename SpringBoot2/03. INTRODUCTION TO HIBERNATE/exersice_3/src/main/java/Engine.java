import model.Address;
import model.Employee;
import model.Project;
import model.Town;

import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {

    private final EntityManager entityManager;
    private final BufferedReader br;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Chose an exercise:");
        String exer=scanner.nextLine();

        while (!exer.equals("end")) {
            switch (exer){

                case "2":

                    ChangeCasingEx2();

                    break;
                case "3":

                    try {
                        ContainsEmployeeEx3();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case "4":

                    Exercise4SecondWay();

                    break;
                case "5":

                    EmpAndDepartEx5();

                    break;
                case "6":

                    try {
                        AddingNewAddressAndUpdatingEmployeeEx6();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case "7":

                    AddressesWithEmployeeCountEx7();

                    break;
                case "8":

                    try {
                        GetEmployeeWithProjectEx8();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case "9":

                    FindLatest10ProjectsEx9();

                    break;
                case "10":

                    IncreaseSalariesEx10();

                    break;
                case "11":

                    try {
                        FindEmployeesByFirstNameEx11();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
                case "12":

                    EmployeesMaximumSalariesEx12();

                    break;
                case "13":

                    try {
                        RemoveTownsEx13();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    break;
            }
            System.out.println("Chose number of exercise or end command!");
            exer=scanner.nextLine();

        }

    }

    private void RemoveTownsEx13() throws IOException {
        System.out.println("Enter valid town:");
        String townForDel = br.readLine();

        Town town = entityManager.createQuery("SELECT t FROM Town t WHERE t.name= :name", Town.class)
                .setParameter("name", townForDel)
                .getSingleResult();

        List<Address> addresses = entityManager.createQuery("SELECT a FROM Address a " +
                "WHERE a.town.name = :name", Address.class)
                .setParameter("name", townForDel)
                .getResultList();

        String output = String.format("%d addresses in %s deleted%n"
                , addresses.size(), (addresses.size() != 1) ? "" : "No addres", town.getName());

        entityManager.getTransaction().begin();

        addresses.forEach(address -> {
            for (Employee employee : address.getEmployees()) {
                employee.setAddress(null);
            }
            address.setTown(null);
            entityManager.remove(address);
        });
        entityManager.remove(town);
        entityManager.getTransaction().commit();
        System.out.println(output);

        System.out.println();

    }

    private void EmployeesMaximumSalariesEx12() {
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e " +
                "  GROUP by e.department HAVING MAX(e.salary) NOT BETWEEN (30000) AND  (70000)", Employee.class)
                .getResultList();

        employees

                .forEach(employee -> {
                    System.out.printf("%s %.2f%n", employee.getDepartment().getName(), employee.getSalary());
                });


    }

    private void FindEmployeesByFirstNameEx11() throws IOException {
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee AS e " +
                "WHERE e.firstName LIKE 'Sa' ", Employee.class)
                //.setParameter(name,"%name%")
                .getResultList();

    }


    private void ChangeCasingEx2() {
        List<Town> towns = entityManager.createQuery("SELECT t FROM Town t " +
                "WHERE length(t.name) <=5 ", Town.class)
                .getResultList();

        entityManager.getTransaction().begin();
        towns.forEach(entityManager::detach);

        for (Town town : towns) {
            town.setName(town.getName().toLowerCase());
        }

        towns.forEach(entityManager::merge);
        entityManager.flush();
        entityManager.getTransaction().commit();

    }

    private void ContainsEmployeeEx3() throws IOException {
        System.out.println("Enter employee full name:");
        String fullName = br.readLine();

        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee e " +
                        "WHERE concat(e.firstName,  ' ',e.lastName) = :name", Employee.class)
                .setParameter("name", fullName)
                .getResultList();
        System.out.println(employees.size() == 0 ? "NO" : "YES");
    }

    private void EmployeesWithSalaryOver50000Ex4() {
        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.salary > 50000", Employee.class)
                .getResultList();
        System.out.println();
    }

    private void Exercise4SecondWay() {
        entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.salary > 50000", Employee.class)
                .getResultStream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }

    private void EmployeesFromDepartmentEasyWayEx5() {
        List<Employee> employees = entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.department.name= 'Research and Development' " +
                        "ORDER BY e.salary,e.id ", Employee.class)
                .getResultList();

    }

    private void EmpAndDepartEx5() {
        entityManager
                .createQuery("SELECT e FROM Employee AS e " +
                        "WHERE e.department.name= 'Research and Development' " +
                        "ORDER BY e.salary,e.id ", Employee.class)
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s from Research and Development - $%.2f%n"
                            , employee.getFirstName(), employee.getLastName(), employee.getSalary());
                });
    }

    private void AddingNewAddressAndUpdatingEmployeeEx6() throws IOException {
        Address address = createAddressMethodEx6("Vitoshka 15");

        System.out.println("Enter employee last name: ");
        String lastName = br.readLine();

        //zad 9 da proverq

        //Employee employee=entityManager.createQuery("SELECT e FROM Employee AS e " +
        //        "WHERE e.lastName= :last_name",Employee.class)
        //        .setParameter("last_name",lastName)
        //        .getSingleResult();


        //vtori na4in po id
        Employee employee = entityManager
                .find(Employee.class, 291);

        entityManager.getTransaction().begin();
        employee.setAddress(address);
        entityManager.getTransaction().commit();

    }

    private Address createAddressMethodEx6(String addressText) {
        Address address = new Address();
        address.setText(addressText);

        entityManager.getTransaction().begin();
        entityManager.persist(address);
        entityManager.getTransaction().commit();
        return address;
    }

    private void AddressesWithEmployeeCountEx7() {
        List<Address> addresses = entityManager
                .createQuery("SELECT a FROM Address AS a " +
                        "ORDER BY a.employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        addresses.forEach(address -> {
            System.out.printf("%s %s - %d %n", address.getText(), address.getTown().getName()
                    , address.getEmployees().size());
        });
    }


    private void GetEmployeeWithProjectEx8() throws IOException {
        System.out.println("Enter valid employee id: ");
        int id = Integer.parseInt(br.readLine());

        Employee employee = entityManager
                .find(Employee.class, id);
        System.out.printf("%s %s - %s%n", employee.getFirstName(), employee.getLastName(),
                employee.getJobTitle());

        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> {
                    System.out.printf("\t%s%n", project.getName());
                });
    }


    private void FindLatest10ProjectsEx9() {
        List<Project> projectsName = entityManager.createQuery("SELECT p FROM Project AS p " +
                "ORDER BY p.startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();


        projectsName
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(project -> {
                    System.out.printf("Project name: %s%n\tProject Description: %s%n\tProject Start Date: %s%n\tProject End Date: %s%n"
                            , project.getName(), project.getDescription(), project.getStartDate(), project.getEndDate());
                });

    }

    private void IncreaseSalariesEx10() {
        // Engineering 1, Tool Design 2, Marketing 4 or Information Services 11

        entityManager.getTransaction().begin();

        int affectedRows = entityManager.createQuery("UPDATE Employee AS e " +
                "SET e.salary = e.salary*1.12 " +
                "WHERE e.department.id IN (1,2,4,11)")
                .executeUpdate();

        entityManager.getTransaction().commit();

        System.out.println("Affected rows " + affectedRows);

        entityManager.createQuery("SELECT e FROM Employee e " +
                "WHERE e.department.id IN (1,2,4,11)", Employee.class)
                .getResultStream()
                .forEach(employee -> {
                    System.out.printf("%s %s ($%.2f)%n", employee.getFirstName(),
                            employee.getLastName(), employee.getSalary());
                });

    }


}
