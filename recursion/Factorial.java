public class Factorial {

    public static void main(String[] args) {
        int n = 4;
        int res = factorial(n);
        System.out.println(res);
    }

    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}