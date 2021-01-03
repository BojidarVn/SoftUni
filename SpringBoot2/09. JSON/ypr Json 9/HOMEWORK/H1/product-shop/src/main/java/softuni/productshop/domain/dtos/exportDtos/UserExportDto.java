package softuni.productshop.domain.dtos.exportDtos;

import com.google.gson.annotations.Expose;
import softuni.productshop.domain.entities.Product;

import java.util.Set;

public class UserExportDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;
    @Expose
    private Set<ProductExportDtoEx4> soldProducts;

    public UserExportDto() {
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

    public Set<ProductExportDtoEx4> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductExportDtoEx4> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
