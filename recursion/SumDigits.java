public class SumDigits {

    public static void main(String[] args) {
        int num = 27;
        System.out.println(sum(num));
    }

    public static int sum(int num) {
        if (num < 10)
            return num;
        return sum(num / 10) + num % 10;
    }
}