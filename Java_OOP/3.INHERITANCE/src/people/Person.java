package people;

import java.util.concurrent.ThreadLocalRandom;

public class Person {
    private String name;
    private String address;

    public Person(String name,String address) {
       this.name=name;
       this.address=address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public void sleep() {
        System.out.println("Person is sleeping!" + getRandSheep());
    }

    private int getRandSheep() {
        return ThreadLocalRandom.current().nextInt(100);
    }
}
