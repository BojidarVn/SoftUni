package entities.hospital;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntityHospital {

    private long id;

    public BaseEntityHospital() {
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
