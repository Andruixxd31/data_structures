public class Natural {

    public static void main(String[] args) {
        nat(50);
    }

    // A non-tail recursive function
    public static int nat(int x) {
        if (x == 0) {
            return 0;
        }
        int num = 1 + nat(x - 1);
        System.out.print(num + ",");
        if (num % 10 == 0)
            System.out.println("");
        return num;
    }
}
