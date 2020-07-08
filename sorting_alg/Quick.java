//Quick sort is an unstable algorithm
//it performs O(nlogn), in the worst scenario is O(n^2)

public class Quick {

    public static void quickSort(int[] input, int start, int end) {
        if (end - start <= 1) // if there is only one element theres no need to sort
            return;

        int pivotIndex = partition(input, start, end); // will return the correct index position of the index
        // dividing the array into to parts
        // smaller as the pivotIndex
        // bigger than the pivot index
        quickSort(input, start, pivotIndex); // we pass the ordered pivot since the partion will decrement its position
                                             // and look the element to its left
        quickSort(input, pivotIndex + 1, end);
    }

    public static int partition(int[] input, int start, int end) {
        // this is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;
        while (i < j) {

            // Empty loop body
            // Checks if the value at j is bigger than the pivot.
            // If it is the loop will be broken
            while (i < j && input[--j] >= pivot) // we decrement and then check j's position
                ;
            if (i < j) {
                input[i] = input[j]; // the value will be put somewhere to the left of the pivot
            }

            // Empty loop body
            // Check if i's position is bigger than the pivot
            while (i < j && input[++i] <= pivot)
                ;
            if (i < j) {
                input[j] = input[i]; // the value will be put somewhere to the rigth of the pivot
            }
        }

        // when i and j are in the same position the pivot's position has ben found
        input[j] = pivot;
        return j;
    }

    public static void main(String[] args) {
        int[] array = {5,7,77,3,2,71,4,14,1,11};

        quickSort(array, 0, array.length);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}