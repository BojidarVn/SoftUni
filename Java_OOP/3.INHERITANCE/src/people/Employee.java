package people;

public class Employee extends Person {
    private String company;

public Employee(String name, String address, String company){
    super(name,address);
    this.company=company;
}

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    @Override
    public void sleep() {

        System.out.println("Employee sleeps at work");
    }
}


