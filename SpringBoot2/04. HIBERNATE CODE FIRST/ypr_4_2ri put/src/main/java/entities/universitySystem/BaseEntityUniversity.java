package entities.universitySystem;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntityUniversity {
    private long id;

    public BaseEntityUniversity() {
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
