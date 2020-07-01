public class BinaryG<E extends Comparable<E>> {

    public static void main(String[] args) {
        Integer array[] = { 1, 4, 6, 8, 9, 12, 25, 33, 69 }; // Size of 9
        BinaryG obj = new BinaryG();
        obj.binarySearch(array, 6);

        Double decimals[] = { 1.1, 4.4, 6.6, 8.8, 9.9, 12.12, 25.25, 33.33, 69.69 }; // Size of 9
        obj.binarySearch(decimals, 69.69);

        String strings[] = { "Argentina", "Mexico", "Namibia", "Oman", "Yemen" }; // Size of 9
        obj.binarySearch(strings, "Oman");
    }

    // Later make it to accept all Number class type
    public int binarySearch(E[] arr, E key) { // El metodo acepta cualquier tipo de dato comparable

        int hi = arr.length - 1; // Ultimo indice del arreglo
        int lo = 0; // Primer indice del arreglo
        int mid;
        while (lo <= hi) { // Cuando lo sea mayor que high sabemos que ya eliminamos todos los valores
                           // posibles
            mid = lo + (hi - lo) / 2; // Vamos a la mitad del arreglo para comparar el valor en el indice del medio
                                      // con la llave
            if (key.compareTo(arr[mid]) > 0) {
                lo = mid + 1; // ignoramos el medio y todo lo menor, sabemos que la llave es mayor que esos
                              // valores
            } else if (key.compareTo(arr[mid]) < 0) {
                hi = mid - 1; // ignoramos el medio y los valores a su derecha
            } else { // Si el valor es igual llegamos a esta condicion
                System.out.println("Element " + key + " was found at " + mid); // indicamos en que indice esta el valor
                return mid; // regresamos el indice
            }
        }
        System.out.println("Element " + key + " was not found in the array");
        return -1; // Regresamos menos -1 para indicar que no esta el elemento buscado en ningún
                   // indice
    }

}