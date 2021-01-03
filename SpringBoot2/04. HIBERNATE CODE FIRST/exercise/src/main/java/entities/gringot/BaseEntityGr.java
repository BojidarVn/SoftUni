package entities.gringot;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntityGr {
    private long id;

    public BaseEntityGr() {
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
