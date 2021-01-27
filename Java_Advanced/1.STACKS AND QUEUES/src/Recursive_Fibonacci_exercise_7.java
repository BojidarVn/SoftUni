import java.util.Scanner;

public class Recursive_Fibonacci_exercise_7 {
    private static long[] memorization;

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        int n = Integer.parseInt(Scanner.nextLine());

        memorization = new long[n +1];

        System.out.println(fib(n));


    }

    private static long fib(int n) {

        if (n <= 2) {
            return n;
        }

        if (memorization[n] !=0) {return memorization[n];}

        return memorization[n]= fib(n-1)+fib(n-2);
    }
}
