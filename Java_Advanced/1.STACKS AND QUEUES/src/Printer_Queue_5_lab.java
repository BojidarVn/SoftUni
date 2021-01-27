import java.util.ArrayDeque;
import java.util.Scanner;

public class Printer_Queue_5_lab {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

       String file = Scanner.nextLine();

       while (!file.equals("print")) {

           if (file.equals("cancel")) {
               if(!queue.isEmpty()) {
                   System.out.println("Canceled " + queue.pop());
               } else {
                   System.out.println("Printer is on standby");
               }

           } else {
               queue.offer(file);
           }
           file=Scanner.nextLine();
       }
       while (!queue.isEmpty()) {
           System.out.println(queue.poll());
       }



//       moq na4in koito e ne proveren v judge

//        Scanner Scanner = new Scanner(System.in);
//
//        String input=Scanner.nextLine();
//        Deque<String> forPrinting = new ArrayDeque<>();
//
//        while (!input.equals("print")) {
//
//            if (input.equals("cancel")) {
//                if (forPrinting.isEmpty()) {
//                    System.out.println("Printer is on standby");
//                } else {
//                    String fileForRemove= forPrinting.poll();
//                    System.out.println("Canceled " +fileForRemove);
//                }
//
//            } else {
//                forPrinting.offer(input);
//            }
//
//            input=Scanner.nextLine();
//        }
//        while (!forPrinting.isEmpty()){
//            System.out.println(forPrinting.poll());
//        }





    }
}
