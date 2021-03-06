package softuni.cardelar.domain.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    private String make;
    private String model;
    private long travelledDistance;
    private Set<Part> parts;
    private Sale sele;

    public Car() {
    }

    @Column
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "travelled_distance")
    public long getTravelledDistance() {
        return travelledDistance;
    }

    public void setTravelledDistance(long travelledDistance) {
        this.travelledDistance = travelledDistance;
    }

    @OneToOne(mappedBy = "car", targetEntity = Sale.class)
    public Sale getSele() {
        return sele;
    }

    public void setSele(Sale sele) {
        this.sele = sele;
    }

//    @ManyToMany(mappedBy = "cars", targetEntity = Part.class, cascade = CascadeType.ALL)

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name= "cars_parts",
            joinColumns = @JoinColumn(name = "car_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"))
    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }




}
