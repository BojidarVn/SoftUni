package Collection_Hierarchy_EXERCISE__7;

public class AddRemoveCollection extends Collection implements AddRemovable {
    @Override
    public String remove() {
        return super.remove(true);
    }

    @Override
    public int add(String str) {
        return this.add(str,false);
    }
}
