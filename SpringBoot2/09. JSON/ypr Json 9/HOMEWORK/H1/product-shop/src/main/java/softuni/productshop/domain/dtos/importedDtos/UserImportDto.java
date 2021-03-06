package softuni.productshop.domain.dtos.importedDtos;

import com.google.gson.annotations.Expose;

public class UserImportDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;

    public UserImportDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
