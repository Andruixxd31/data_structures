//Quick sort is an unstable algorithm
//it performs O(nlogn), in the worst scenario is O(n^2)

/**
 * Quick
 */
public class Quick {

    public static void quickSort(int[] input, int start, int end){
        if (end - start < 2) return;

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    public static int partition(int[] input, int start, int end){
        //this is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end; 
        while ( i < j){
            //Empty loop body
            while(i < j && input[--j] >= pivot);
            if (i < j){
                input[i] = input[j];
            }

            //Empty loop body
            while ( i < j && input[++i] <= pivot);
            if (i < j) {
                input[j] = input[i];
            }
        }

        input[j] = pivot;
        return j;
    }
    public static void main(String[] args) {
        int[] array = {20,37,-15,7,55,1,-22};

        quickSort(array, 0, array.length);

        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}