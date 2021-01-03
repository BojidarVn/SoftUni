package softuni.productshop.domain.dtos.exportDtos;

import softuni.productshop.domain.entities.Product;

import java.util.Set;

public class ProductExportDtoEx4 {

    private int count;
    private Set<Product> products;

    public ProductExportDtoEx4() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
