// Andrés Díaz de León - A01620020
// 01/07/20

public class RecursionSesion3 {

    public static void main(String[] args) {
        // enAscendente(5);
        // enDescendente(5);
        // System.out.println(division(30, 3));
        // System.out.println(sumaDigitos(3782));
        // System.out.println(sumaArmonica(4));
        // medioDiamente(5, '+');
        int arr[] = { 1, 2, 3, 4, 5 };
        // System.out.println(elMayorR(arr));
        // invierteArregloR(arr);
        System.out.println(sumaArreglo(arr));
    }

    private static void enDescendente(int n) {
        if (n >= 0) {
            System.out.println(n);
            enDescendente(n - 2);
        }
    }

    private static void enAscendente(int n) {
        if (n > 0)
            enAscendente(n - 1);
        System.out.println(n + "");

    }

    private static int division(int x, int y) {
        if (x > y)
            return 0;
        if (y == 1)
            return x;
        return 1 + division(x - y, y);
    }

    private static int sumaDigitos(int num) {
        if (num < 10)
            return num;
        return sumaDigitos(num / 10) + num % 10;
        // 3782 -> 378 | 2
        // 378 -> 37 | 8
        // 37 -> 3 | 7
    }

    private static int mcd(int a, int b) {
        if (a >= b && a % b == 0)
            return b; // if the statment is true, the common denominator was found
        else if (a < b)
            return mcd(b, a); // if a is smaller the number are switched to check if the common denominator
                              // was a instead of b
        else
            return mcd(b, a % b); // returns a and r(a%b) to check if r is the common denominator
    }

    private static double sumaArmonica(double n) {
        if (n == 1)
            return n;
        return 1 / n + sumaArmonica(n - 1);
    }

    private static int elMayorR(int a[]) {
        if (a.length > 0)
            return elMayorR(a, 1, a.length - 1, a[0]);
        return a[0];
    }

    private static int elMayorR(int a[], int i, int f, int may) {
        if (i > f)
            return may;
        if (a[i] > may)
            may = a[i];
        return elMayorR(a, ++i, f, may);
    }

    private static void imprime(int num, char c) {
        if (num > 0) {
            System.out.print(c);
            imprime(--num, c);
        }
    }

    private static void medioDiamente(int num, char c) {
        if (num > 0) {
            imprime(num, c);
            System.out.println();
            medioDiamente(--num, c);
            imprime(num, c);
            System.out.println();
        }
    }

    private static void invierteArregloR(int arr[]) {
        invierteArregloR(arr, arr.length - 1);
    }

    private static void invierteArregloR(int arr[], int i) {
        if (i >= 0) {
            System.out.print(arr[i] + ",");
            invierteArregloR(arr, --i);
        }
    }

    private static int sumaArreglo(int arr[]) {
        return sumaArreglo(arr, arr.length - 1);
    }

    private static int sumaArreglo(int arr[], int i) {
        if (i == 0)
            return arr[i];
        return arr[i] + sumaArreglo(arr, i - 1);
    }
}