package Collection_Hierarchy_EXERCISE__7;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private int maxSize;
    private List<String> items;


    protected Collection () {
        this.maxSize=100;
        this.items=new ArrayList<>();
    }

    protected int add(String str, boolean addAtTheEnd) {
        int index=0;
        if (addAtTheEnd) {
            this.items.add(str);
            index = this.items.size() - 1;
        } else {
            this.items.add(0,str);
        }
        return index;
    }

    protected String remove( boolean addAtTheEnd) {
        int index= addAtTheEnd ? this.items.size()-1 : 0;
        return this.items.remove(index);

    }

    protected int size() {
      return this.items.size();
    }

}
