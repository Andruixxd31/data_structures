public class NumDigits {

    public static void main(String[] args) {
        int num = 123456789;
        System.out.println(countDigits(num));
    }

    public static int countDigits(int num) {
        if (num < 10)
            return 1;
        return 1 + countDigits(num / 10);
    }
}