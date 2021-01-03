package entities.bills;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "credit_cards")
public class CreditCard extends BaseEntityBills {

   // private String cardType;
    private LocalDate expirationMonth;
    private LocalDate expirationYear;

    private User user;

    public CreditCard() {
    }

//    @Column(name = "card_type", length = 20, nullable = false)
//    public String getCardType() {
//        return cardType;
//    }

//    public void setCardType(String cardType) {
//        this.cardType = cardType;
//    }

    @Column(name = "expiration_month", nullable = false)
    public LocalDate getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(LocalDate expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    @Column(name = "expiration_year", nullable = false)
    public LocalDate getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(LocalDate expirationYear) {
        this.expirationYear = expirationYear;
    }

    @ManyToOne
    @JoinColumn(name ="user_id",referencedColumnName = "id")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
