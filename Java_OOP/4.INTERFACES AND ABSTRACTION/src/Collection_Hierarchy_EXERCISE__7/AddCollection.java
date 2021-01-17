package Collection_Hierarchy_EXERCISE__7;

public class AddCollection extends Collection implements Addable {
    @Override
    public int add(String str) {

        return this.add(str,true);
    }
}
