package Military_Elite_EXERCISE__6.entities;

import Military_Elite_EXERCISE__6.Interfaces.Repair;

public class RepairImpl implements Repair {
    private String partName;
    private int hoursWorked;

    public RepairImpl (String partName,int hoursWorked){
        this.partName=partName;
        this.hoursWorked=hoursWorked;
    }

}
