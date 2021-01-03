package softuni.productshop.domain.dtos.importedDtos;

import com.google.gson.annotations.Expose;
import softuni.productshop.domain.entities.Category;
import softuni.productshop.domain.entities.User;

import java.math.BigDecimal;
import java.util.Set;

public class ProductImportDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private User buyer;
    @Expose
    private User seller;
    @Expose
    private Set<Category> category;

    public ProductImportDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }
}
