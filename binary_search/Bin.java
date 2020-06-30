public class Bin {

    public static void main(String[] args) {
        int array[] = { 1, 4, 6, 8, 9, 12, 25, 33, 69 }; // Size of 9
        binarySearch(array, 69);
    }

    // Later make it to accept all Number class type
    public static int binarySearch(int arr[], int key) {

        int hi = arr.length - 1;
        int lo = 0; // first index
        int mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key > arr[mid]) {
                lo = mid + 1;
            } else if (key < arr[mid]) {
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