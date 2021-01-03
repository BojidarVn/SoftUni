package entities.football;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "players")
public class Player extends BaseEntityNameAndId {

    private int squadNumber;
    private String team;
    private String position;
    private Boolean isCurrentlyInjured;

    public Player() {
    }

    @Column(name = "squad_number")
    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }

    @Column(name = "team")
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "is_currently_injured")
    public Boolean getCurrentlyInjured() {
        return isCurrentlyInjured;
    }

    public void setCurrentlyInjured(Boolean currentlyInjured) {
        isCurrentlyInjured = currentlyInjured;
    }
}
