package entities.sales;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "store_locations")
public class StoreLocation extends BaseEntitySales {

    private String location;
    private Set<Sale> seles;

    public StoreLocation() {
    }

    @Column(name = "location_name")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @OneToMany(mappedBy = "storeLocation", targetEntity = Sale.class)
   public Set<Sale> getSeles() {
       return seles;
   }

   public void setSeles(Set<Sale> seles) {
       this.seles = seles;
   }
}
