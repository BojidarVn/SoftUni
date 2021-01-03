package entities.bills;




import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BillingDetail extends BaseEntityBills {

    private String numberOfOwner;
    private String owner;


    public BillingDetail() {
    }


    @Column(name = "number_of_owner", length = 50, nullable = false)
    public String getNumberOfOwner() {
        return numberOfOwner;
    }

    public void setNumberOfOwner(String numberOfOwner) {
        this.numberOfOwner = numberOfOwner;
    }

    @Column(name = "owner", length = 50, nullable = false)
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
