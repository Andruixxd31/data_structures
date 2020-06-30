public class Sequential<T> {

    public static void main(String[] args) {
        Sequential se = new Sequential();
        Integer[] array = { 1, 4, 6, 8, 9, 12, 25, 33, 69 };
        System.out.println(se.busquedaSecuencial(array, 6));

        Double[] decimales = { 10.0, 20.0, 30.0, 40.0, 50.0 };
        System.out.println(se.busquedaSecuencial(decimales, 50.0));

        String[] palabras = { "hola", "que tal", "como estas", "bye" };
        System.out.println(se.busquedaSecuencial(palabras, "como estas"));
    }

    public int busquedaSecuencial(T[] arr, T llave) {
        for (int i = 0; i < arr.length; i++)
            if (llave.equals(arr[i]))
                return i;
        return -1;
    }
}