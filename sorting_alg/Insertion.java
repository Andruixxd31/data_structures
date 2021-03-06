public class Insertion {

    public static void main(String[] args) {
        int array[] = { 4, 2, 6, 3, 7, 9, 1, 0, 5, 8 };
        // It starts with a small treshold, which is the first two elements
        // It compares the elements to have them in order
        // After the element of the right gets added and it is compared to the elements
        // to its left
        // And the process repeats
        // Its similar to having cards and adding them one at the time to the line
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            // NewElement is a variable kept so when a element shifts to its position its
            // value its stored
            // and later moved to its right position
            int newElement = array[firstUnsortedIndex];
            int i;

            // i will be a value greater each time this loop is run.
            // Will start with index one and in the las loop will have 9 as a value
            // If the new Element is smaller than the element to its left the value will be
            // shifted.
            for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
                array[i] = array[i - 1]; // shifting the value compared to newElement to make space for it
            }

            array[i] = newElement; // newElement will be put in its place
        }
        printAll(array);
    }

    public static void printAll(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }
}