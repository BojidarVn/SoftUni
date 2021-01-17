package Military_Elite_EXERCISE__6.entities;

import Military_Elite_EXERCISE__6.Interfaces.SpecialisedSoldier;
import Military_Elite_EXERCISE__6.eum.Corps;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps=corps;
    }
}
