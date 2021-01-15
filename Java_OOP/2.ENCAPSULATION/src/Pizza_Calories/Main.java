package Pizza_Calories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        String[] pizzaInput = Scanner.nextLine().split("\\s+");
        Pizza pizza=new Pizza(pizzaInput[1],Integer.parseInt(pizzaInput[2]));

        String[] doughInput= Scanner.nextLine().split("\\s+");
        Dough dough=new Dough(doughInput[1],doughInput[2],Double.parseDouble(doughInput[3]));

        pizza.setDough(dough);

        String line;

        while (!(line=Scanner.nextLine()).equals("END")) {

            String[] tokens=line.split("\\s+");

            Topping topping=new Topping(tokens[1],Double.parseDouble(tokens[2]));
            pizza.addTopping(topping);
        }

        System.out.printf("%s - %.2f",pizza.getName(),pizza.getOverallCalories());
    }
}
