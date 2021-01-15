package Shopping_Spree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public double getMoney() {
        return this.money;
    }

    public void buyProduct(Product product) {
        if (this.getMoney() >= product.getCost()) {
            this.setMoney(this.getMoney() - product.getCost());
            this.getProducts().add(product);

            System.out.printf("%s bought %s%n", this.getName(), product.getName());
        } else {
            System.out.printf("%s can't afford %s%n", this.getName(), product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - ", this.getName()));

        if (this.getProducts().size() == 0) {
            sb.append("Nothing bought");
        } else {
            sb.append(this.getProducts()
                    .stream()
                    .map(Product::getName)
                    .collect(Collectors.joining(", ")));
        }
        return sb.toString();
    }
}
