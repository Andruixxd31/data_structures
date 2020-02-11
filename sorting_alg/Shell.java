/*
A shell sorting algorithm is a modified insertion sort algorithm.
If the elements are better sorted in the array the insertion sort doesn't need to make a los of shifts, 
when that happens the insertion sort is closer to a linear complexity. 
Shell sort starts with a gap to swaps elements on different parts of the array, the gap is lowered 
until it has a value of 1, by beig 1 we do a insertion algorithm.

There are many methods to base a gap, each one has an effect on the complexity.
*/

//it is an unstable sorting algorithm
public class Shell {

    public static void main(String[] args) {
        int array[] = {4,2,6,3,7,9,1,0,5,8};
        for (int gap = array.length/2; gap > 0; gap /= 2){ //reducing the gap each iterarion
            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];
                int j = i;

                while (j >= gap && array[j - gap] > newElement) { //shifts the values that are separated by the gap
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }
        printAll(array);
    }

    public static void printAll(int[] array){ 
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ","); //If the comma is in single quotes the numbers are not shown correctly
        }
        System.out.println();
    }
}



