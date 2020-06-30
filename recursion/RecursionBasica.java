//Andres Diaz de Leon - A01620020

/**
 * RecursionBasica
 */
public class RecursionBasica {

    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(sumaN(4, 0));
        System.out.println(multiplicacion(4, 3));
        System.out.println(potencia(9, 4));
        System.out.println(cuentaCuantas("papalote", 'p'));
    }

    // * Metodo Factorial
    public static int factorial(int num) {
        if (num == 0)
            return 1;
        return num * factorial(num - 1); // Regresa el retorno por el numero anterioir
    }

    // * Función recursiva de cola
    public static int sumaN(int x, int y) {
        if (x == 0)
            return y; // En la ultima llamada se regresa y se limpia la stack
        return sumaN(x - 1, x + y); // Va sumando cada x en y que acumala la suma de los número naturales
    }

    public static int multiplicacion(int x, int y) {
        if (x == 0)
            return x;
        return y + multiplicacion(x - 1, y);
    }

    public static int potencia(int x, int y) {
        if (y == 1)
            return x;
        return x * potencia(x, y - 1);
    }

    public static int cuantosDigitos(int num) {
        if (num < 10)
            return 1;
        return 1 + cuantosDigitos(num / 10);
    }

    public static int cuentaCuantas(String palabra, char letra) {
        return cuentaCuantas(palabra, letra, palabra.length(), 0);
    }

    public static int cuentaCuantas(String palabra, char letra, int len, int cuenta) {
        if (len - 1 >= 0) {
            if (palabra.charAt(len - 1) == letra) {
                return cuentaCuantas(palabra, letra, --len, ++cuenta);
            } else {
                return cuentaCuantas(palabra, letra, --len, cuenta);
            }
        }
        return cuenta;
    }

}
