//Unstable sorting algorithm
public class Bubble {
    public static void main(String[] args) {
        int array[] = {4,2,2,6,3,7,9,1,0,5,8};
        //This loops will later ignore the already correctly sorted numbers
        //The highest numbers will be sorted to the right in eac iteration, so its not necessary compare them to the others.
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) { 
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
        printAll(array);
    } 

    public static void swap(int[] array, int i, int j){ //
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
