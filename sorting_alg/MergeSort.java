import java.util.Arrays;

public class MergeSort {
    private static int[] numbers = { 9, 1, 8, 2, 7, 3, 6, 4, 5, 0 };
    private static int[] helper = new int[numbers.length];

    public static void main(String[] args) {
        System.out.println(Arrays.toString(numbers));
        mergesort(0, numbers.length - 1);
        System.out.println(Arrays.toString(numbers));
    }

    private static void mergesort(int low, int high) {

        if (low < high) {
            int middle = low + (high - low) / 2;
            mergesort(low, middle);
            mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private static void merge(int low, int middle, int high) {

        for (int i = low; i <= high; i++) { // helper array copies the part of the aray being used
            helper[i] = numbers[i]; // copies the elements
        }

        int i = low;
        int j = middle + 1;
        int k = low; // will be used to traverse the subarray from start to end. This will help us
                     // put the right value to its respective postion.

        // Copy the smallest values and put them in their respective postion.
        // i will be at the smallest value available of the left subarray
        // j will be the smallest value available at the right subarray
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++; // the smallest value was relocated so i moves to the next one avalaible in the
                     // subarray
            } else {
                numbers[k] = helper[j];
                j++; // the smallest value was relocated so j moves to the next one avalaible in the
                     // subarray
            }
            k++; // moves to the next slot of the subarray being ordered
        }

        // finishes the left side of the array if j was beyond the array being
        // inspected
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
    }
}