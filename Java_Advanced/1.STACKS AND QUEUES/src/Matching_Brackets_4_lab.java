import java.util.ArrayDeque;
import java.util.Scanner;

public class Matching_Brackets_4_lab {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

//        ArrayDeque<Integer> openingSymbols = new ArrayDeque<>();
//
//        // trqbva da se doreshi a prednata da se sloji 0
//
//        String expressionSymbols = Scanner.nextLine();
//
//        for (int i = 0; i < expressionSymbols.length(); i++) {
//            char current = expressionSymbols.charAt(i);
//
//            if (current == '(') {
//                openingSymbols.push(i);
//            } else {
//                int beginIndex = openingSymbols.pop();
//                String subExpression = expressionSymbols.substring(beginIndex, i +1);
//            }
//        }

        ArrayDeque<Integer> bracketIndexes = new ArrayDeque<>();
        String expression = Scanner.nextLine();

        for (int i = 0; i < expression.length(); i++) {

            if (expression.charAt(i) == '(') {
                bracketIndexes.push(i);
            } else if (expression.charAt(i) == ')') {

                int opening=bracketIndexes.pop();
                String current=expression.substring(opening,i+1);

                System.out.println(current);
            }

        }


    }
}
