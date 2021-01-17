package Military_Elite_EXERCISE__6.entities;

import Military_Elite_EXERCISE__6.Interfaces.Private;

public class PrivateImpl extends SoldierImpl implements Private {
    private double salary;

    public PrivateImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName);
        this.salary=salary;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }
}
