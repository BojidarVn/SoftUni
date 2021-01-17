package Military_Elite_EXERCISE__6.Interfaces;

import java.util.Collection;

public interface Engineer extends Private {
    void addRepair (Repair repair);
    Collection<Repair> getRepair();
}
