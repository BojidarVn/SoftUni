package entities.football;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.awt.*;
import java.math.BigDecimal;

@Entity
@Table(name = "teams")
public class Team extends BaseEntityNameAndId {

    private Image logo;
    private String initials;
    private String primaryKitColor;
    private String secondKitColor;
    private String town;
    private BigDecimal budget;

    public Team() {
    }

    @Column(name = "logo")
    public Image getLogo() {
        return logo;
    }

    public void setLogo(Image logo) {
        this.logo = logo;
    }

    @Column(name = "initials", length = 3)
    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    @Column(name = "primary_kit_color", nullable = false)
    public String getPrimaryKitColor() {
        return primaryKitColor;
    }

    public void setPrimaryKitColor(String primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

    @Column(name = "second_kit_color")
    public String getSecondKitColor() {
        return secondKitColor;
    }

    public void setSecondKitColor(String secondKitColor) {
        this.secondKitColor = secondKitColor;
    }

    @Column(name = "town", length = 30, nullable = false)
    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Column(name = "budget")
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
