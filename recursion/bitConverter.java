public class bitConverter {

    public static void main(String[] args) {
        int num = 100;
        final int bit = 1;
        converter(num, bit);
    }

    public static void converter(int num, int bit) {
        if (num - bit > bit)
            converter(num, bit * 2);
        else {
            if (num < bit) {
                System.out.print(0);
                converter(num, bit / 2);
            } else if (num > 0) {
                System.out.print(1);
                converter(num - bit, bit / 2);
            }
        }
    }

}