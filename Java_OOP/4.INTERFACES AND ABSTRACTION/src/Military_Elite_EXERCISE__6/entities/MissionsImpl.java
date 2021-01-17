package Military_Elite_EXERCISE__6.entities;

import Military_Elite_EXERCISE__6.Interfaces.Mission;

public class MissionsImpl implements Mission {

    public enum Status {
        IN_PROGRESS,
        FINISHED;
    }

    private String codeName;
    private Status status;

    public MissionsImpl(String codeName, Status status) {
        this.codeName = codeName;
        this.status = status;
    }

    @Override
    public void completeMission() {
        this.status = Status.FINISHED;
    }

}
