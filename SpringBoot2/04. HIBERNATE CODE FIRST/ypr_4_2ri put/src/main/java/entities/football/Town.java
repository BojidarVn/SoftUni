package entities.football;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "towns")
public class Town extends BaseEntityNameAndId {

    private String country;

    public Town() {
    }

    @Column(name = "country", length = 50)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
