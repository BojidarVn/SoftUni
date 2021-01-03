package entities.football;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntityId {

    private long id;

    public BaseEntityId() {
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
