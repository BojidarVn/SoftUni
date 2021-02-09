package Company_Roster__EXERCISE__2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = bf.readLine().split("\\s+");

            String name = input[0];
            double salary = Double.parseDouble(input[1]);
            String position = input[2];
            String departmentName = input[3];

            Department department = null;

            boolean isFound = false;

            if (departments.size() == 0) {
                department = new Department(departmentName);
                departments.add(department);

            } else {
                for (Department currentDepartment : departments) {

                    if (currentDepartment.getName().equals(departmentName)) {
                        isFound = true;
                        break;
                    }
                }
                if (isFound) {
                    for (Department currentDepartment : departments) {
                        if (currentDepartment.getName().equals(departmentName)) {

                            break;
                        }
                    }
                } else {
                    department = new Department(departmentName);
                    departments.add(department);
                }

            }

            departments.add(department);


            Employee employee = null;
            switch (input.length) {
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    try {
                        int age = Integer.parseInt(input[4]);
                        employee = new Employee(name, salary, position, department, age);


                    } catch (NumberFormatException e) {
                        employee = new Employee(name, salary, position, department, input[4]);

                    }
                    break;
                default:
                    employee = new Employee(name, salary, position, department, input[4], Integer.parseInt(input[5]));
                    break;
            }


            for (int j = 0; j < departments.size(); j++) {
                if (employee.getDepartment().getName().equals(departments.get(j).getName())) {
                    List<Employee> employees = departments.get(j).getEmployees();
                    employees.add(employee);
                    departments.get(j).setEmployees(employees);
                    break;
                }
            }
        }
        System.out.println();
        double highestAvgSalary = 0;
        Department highestPaid = null;
        for (Department department : departments) {
            double avgSalary = department.getEmployees().stream()
                    .mapToDouble(Employee::getSalary)
                    .average().orElse(0);

            if (avgSalary > highestAvgSalary) {
                highestAvgSalary = avgSalary;
                highestPaid = department;
            }
        }
        System.out.printf("Highest Average Salary: %s", highestPaid.getName());
        for (Employee employee : highestPaid.getEmployees()) {
            System.out.printf("%s %.2f %s %d%n", employee.getName(), employee.getSalary(), employee.getEmail(), employee.getAge());

        }
    }
}
