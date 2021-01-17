package Collection_Hierarchy_EXERCISE__7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String[] strings=Scanner.nextLine().split("\\s+");

        int toRemove=Integer.parseInt(Scanner.nextLine());


        List<Addable> addableList=new ArrayList<>();

        Addable addable=new AddCollection();
        AddRemovable addRemovable=new AddRemoveCollection();
        MyList myList=new MyListImpl();


        addableList.add(addable);
        addableList.add(addRemovable);
        addableList.add(myList);

        List<AddRemovable> addRemovables=new ArrayList<>();
        addRemovables.add(addRemovable);
        addRemovables.add(myList);

        for (Addable collections : addableList) {
            for (String string : strings) {
                System.out.print(collections.add(string) + " ");
            }
            System.out.println();

        }

        for (AddRemovable removable : addRemovables) {
            for (int i = 0; i < toRemove; i++) {
                System.out.print(removable.remove() + " ");
            }
            System.out.println();
        }


    }
}
