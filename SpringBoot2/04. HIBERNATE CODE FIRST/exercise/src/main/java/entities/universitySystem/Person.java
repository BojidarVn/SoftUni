package entities.universitySystem;




import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

// kogato tyka smenqme strategy-to se smenqn i tablicite na bazata

@MappedSuperclass
public abstract class Person extends BaseEntityUniversity {
    private String name;
    private String firstName;
    private String lastName;
    private int phoneNumber;

    public Person() {
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    @Column(name = "first_name", length = 30, nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", length = 30)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phoneNumber", columnDefinition = "INT UNSIGNED")
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
