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
    public int binarySearch(E[] arr, E key) {

        int hi = arr.length - 1;
        int lo = 0; // first index
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key.compareTo(arr[mid]) > 0) {
                lo = mid + 1;
            } else if (key.compareTo(arr[mid]) < 0) {
                hi = mid - 1;
            } else {
                System.out.println("Element " + key + " was found at " + mid);
                return mid;
            }
        }
        System.out.println("Element " + key + " was not found in the array");
        return -1;
    }

}