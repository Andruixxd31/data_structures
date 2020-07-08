public class Pascal {

    /**
     * 
     * @param num
     * @return
     */
    public static int factorial(int num) {
        if (num == 0)
            return 1;
        return num * factorial(num - 1);
    }

    public static int coeficiente(int n, int x) {
        return factorial(n) / (factorial(n - x) * factorial(x));
    }

    public static void main(String args[]) {
        int filas = 3;

        for (int i = 0; i <= filas; i++) {
            for (int j = 0; j <= filas - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(" " + coeficiente(i, j));
            }
            System.out.println();
        }
    }
}