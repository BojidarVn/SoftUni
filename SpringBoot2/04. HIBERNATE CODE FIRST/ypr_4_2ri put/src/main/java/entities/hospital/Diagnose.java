package entities.hospital;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "diagnoses")
public class Diagnose extends BaseEntityHospital {

    private String name;
    private String comments;
    private Set<Patient> patientsSet;

    public Diagnose() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToMany(mappedBy = "diagnoses", targetEntity = Patient.class)
    public Set<Patient> getPatientsSet() {
        return patientsSet;
    }

    public void setPatientsSet(Set<Patient> patientsSet) {
        this.patientsSet = patientsSet;
    }
}
