package softuni.cardelar.domain.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    private String name;
    private LocalDateTime birthDate;
    private boolean isYoungDriver;
    private Set<Sale> seles;

    public Customer() {
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "birth_day")
    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    @Column(name = "is_young_driver")
    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }


    @OneToMany(mappedBy = "customer", targetEntity = Sale.class,
    fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Sale> getSeles() {
        return seles;
    }

    public void setSeles(Set<Sale> seles) {
        this.seles = seles;
    }


    //    @OneToMany
//    public Set<Car> getCars() {
//        return cars;
//    }
//
//    public void setCars(Set<Car> cars) {
//        this.cars = cars;
//    }
}
