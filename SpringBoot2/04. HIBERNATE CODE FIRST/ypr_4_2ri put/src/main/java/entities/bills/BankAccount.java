package entities.bills;

import javax.persistence.*;

@Entity
@Table(name ="bank_account")
public class BankAccount extends BillingDetail {

    private String bankName;
    private String SWIFTCode;

   private User user;

    public BankAccount() {
    }
@Column(name = "bank_name", length = 50,nullable = false)
    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Column(name = "SWIFT_code", length = 50 , nullable = false)
    public String getSWIFTCode() {
        return SWIFTCode;
    }

    public void setSWIFTCode(String SWIFTCode) {
        this.SWIFTCode = SWIFTCode;
    }

@ManyToOne
@JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
