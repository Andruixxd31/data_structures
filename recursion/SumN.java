public class SumN {

    public static void main(String[] args) {
        int x = 8;
        int res = sum(x, 0); // This will be the sum of x and all the natural positive numbers below it
        System.out.println(res);
    }

    // * tail rescursive function
    public static int sum(int x, int y) {
        if (x == 0) {
            return y;
        }
        return sum(x - 1, x + y);
    }
}