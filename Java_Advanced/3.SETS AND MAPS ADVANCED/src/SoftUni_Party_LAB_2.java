import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUni_Party_LAB_2 {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String guest = "";

        Set<String> regular = new TreeSet<>();
        Set<String> vip = new TreeSet<>();

        while (!(guest = Scanner.nextLine()).equals("PARTY")) {


            char firstChar = guest.charAt(0);

            if (Character.isDigit(firstChar)) {
                vip.add(guest);

            } else {
                regular.add(guest);
            }
        }

        Set<String> arrivedGuests = new LinkedHashSet<>();

        System.out.println();
        while (!(guest = Scanner.nextLine()).equals("END")) {
            arrivedGuests.add(guest);
            vip.remove(guest);
            regular .remove(guest);
        }


        System.out.println(vip.size() + regular.size());

        for (String n: vip ) {
            System.out.println(n);
        }

        for (String n: regular ) {
            System.out.println(n);
        }

     //   System.out.print(String.join("\n",vip));
     //   System.out.println(String.join("\n",regular));

    }
}
