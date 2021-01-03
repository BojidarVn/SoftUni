package entities.bills;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntityBills {

    private long id;

    public BaseEntityBills() {
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
