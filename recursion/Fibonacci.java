/**
 * Fibonacci
 */
public class Fibonacci {

    public static void main(String[] args) {
        int numbers = 6;
        for (int i = 0; i < numbers; i++) {
            System.out.print(FibonacciR(i) + ", ");
        }

    }

    public static int FibonacciR(int num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return FibonacciR(num - 1) + FibonacciR(num - 2);
    }

}