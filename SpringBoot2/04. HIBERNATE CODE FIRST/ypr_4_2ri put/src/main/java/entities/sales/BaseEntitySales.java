package entities.sales;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntitySales {
    private long id;

    public BaseEntitySales() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
