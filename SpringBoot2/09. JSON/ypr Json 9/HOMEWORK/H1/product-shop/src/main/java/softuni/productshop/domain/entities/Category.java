package softuni.productshop.domain.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")

public class Category extends BaseEntity{

    private String name;
    private List<Product> products;

    public Category() {
    }

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Column
    @Length(min = 3, max = 15)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
