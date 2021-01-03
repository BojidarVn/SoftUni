package softuni.productshop.domain.dtos.exportDtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SellerAndBuyerExportDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private List<ProductExportDtoEx2> soldProducts;

    public SellerAndBuyerExportDto() {
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

    public List<ProductExportDtoEx2> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<ProductExportDtoEx2> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
