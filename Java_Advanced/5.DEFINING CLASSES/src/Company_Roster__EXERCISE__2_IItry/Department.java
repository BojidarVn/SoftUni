package Company_Roster__EXERCISE__2_IItry;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name){
        this.name=name;
        this.employees=new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public List<Employee> getEmployees() {
        return this.employees;
    }

    public double getAverageSalary() {
        return this.employees
                .stream()             //.mapToDouble(e -> e.getSalary()) predi da go promeni "IJ"-to
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        //tezi sa ednakvi gornoto i dolnoto

      //  double sumAvg=0;
      //  for (Employee employee : employees) {
      //      sumAvg+=employee.getSalary();
      //  }
      //  return sumAvg/this.getEmployees().size();
    }
}
