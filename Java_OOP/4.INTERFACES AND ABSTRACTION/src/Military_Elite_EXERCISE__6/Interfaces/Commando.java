package Military_Elite_EXERCISE__6.Interfaces;

import java.util.Collection;

public interface Commando extends Private {
     void addMission(Mission mission);
     Collection<Mission> getMissions();

}
