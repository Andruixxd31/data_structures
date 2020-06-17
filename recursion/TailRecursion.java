public class TailRecursion {

    public static void main(String[] args) {
        int x = 5;
        int y = 2;
        System.out.println(fun1(x, y));
        System.out.println(factorial(5));
        System.out.println(fact(5));
    }

    // This a tail recursive function the last thing being called its the function
    // itself, the functions that were called on the stack are ingored
    // We use a second parameter to acumulate the value of the past functions
    public static int fun1(int x, int y) {
        if (x == 0)
            return y;
        else
            return fun1(x - 1, x + y);
    }

    // *A Factorial non-tail function
    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    // *A Factorial tail function
    // From geeksforgeeks
    static int factTR(int n, int a) {
        if (n == 0)
            return a;
        return factTR(n - 1, n * a);
    }

    // A wrapper over factTR
    static int fact(int n) {
        return factTR(n, 1); // The one will be multiplied by the n- values and will result into the
                             // factorial
    }
}