package Military_Elite_EXERCISE__6.entities;

import Military_Elite_EXERCISE__6.Interfaces.Engineer;
import Military_Elite_EXERCISE__6.Interfaces.Repair;
import Military_Elite_EXERCISE__6.eum.Corps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs=new ArrayList<>();
    }


    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepair() {
        return Collections.unmodifiableCollection(this.repairs);
    }
}
