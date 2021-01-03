package entities.football;

import javax.persistence.Entity;

@Entity(name = "player_statistics")
public class PlayerStatistic extends BaseEntityId {
// – Game, Player, Scored Goals, Player Assists, Played Minutes During Game, (PK = Game + Player)

    private String game;
}
