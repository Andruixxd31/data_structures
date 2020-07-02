public class BinarySearchRecursive {

    private static int binarySearch(int a[], int key, int lo, int hi, int mid) {
        if (lo > hi)
            return -1;
        if (key == a[mid])
            return mid;
        else if (key < a[mid]) {
            hi = mid - 1;
            return binarySearch(a, key, lo, hi, lo + (hi - lo) / 2);
        } else if (key > a[mid]) {
            lo = mid + 1;
            return binarySearch(a, key, lo, hi, lo + (hi - lo) / 2);
        } else
            return -1;
    }

    public static void main(String[] args) {
        int arr[] = { -22, -15, 1, 7, 20, 35, 55, 100 };
        int key = 1;
        int result = binarySearch(arr, key, 0, arr.length - 1, (arr.length - 1) / 2);
        System.out.println("Postion of the key: " + result);
    }
}