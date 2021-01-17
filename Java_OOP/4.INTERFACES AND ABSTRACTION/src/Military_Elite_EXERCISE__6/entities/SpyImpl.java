package Military_Elite_EXERCISE__6.entities;

import Military_Elite_EXERCISE__6.Interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber=codeNumber;
    }
}
