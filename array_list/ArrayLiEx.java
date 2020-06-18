import java.util.ArrayList;

public class ArrayLiEx {

    public static void main(String[] args) {
        int n = 10;

        ArrayList<Integer> arrayli = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            arrayli.add(i);
        }

        System.out.println(arrayli); // prints the whole arraylist
        // using a for each method to iterate
        arrayli.forEach((num) -> num *= 3); // the lambda expresion can do whatever is ordered. The elements are passed
                                            // by value
        arrayli.forEach((num) -> System.out.print(num + ","));
        // Most common method used with arraylist
        arrayli.remove(3); // removes at index 3. Can also be given an element and removes the first found.
                           // or can be given a range with removeRange(int start, int end);
        arrayli.contains(4); // checks if the element is in the arraylist
        arrayli.get(3); // returns the index of the element
        arrayli.size();
        arrayli.isEmpty(); // returns a bool to tell if it is in fact empty
        System.out.println("\n" + arrayli.subList(2, 5)); // prints a sublist from index a to index b
        arrayli.removeIf(num -> (num % 2 == 0)); // removes elements that satisfy the condition
        System.out.println(arrayli);

        ArrayList<Integer> arrayli2 = new ArrayList<Integer>(5);
        for (int i = 0; i < 5; i++) {
            arrayli.add(i * 10);
        }
        arrayli.addAll(arrayli2); // adding al elements of arrayli2.

        arrayli.clear(); // removes all elements
    }
}