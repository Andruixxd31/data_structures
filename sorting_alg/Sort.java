//Unstable sorting algorithm
public class Sort {
    
    public static void main(String[] args) {
        int array[] = {4,2,6,3,7,9,1,0,5,8};
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0; 
            for (int i = 1; i <= lastUnsortedIndex; i++){ //comparing to all the indexes in the array
                if (array[i] > array[largest]){
                    largest = i;
                }
            }
            swap(array,largest, lastUnsortedIndex);
        }
        printAll(array);
    }

    public static void swap(int[] array, int i, int j){ //
        if (i == j) return; //?
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }

    public static void printAll(int[] array){ 
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ","); //If the comma is in single quotes the numbers are not shown correctly
        }
        System.out.println();
    }
}
