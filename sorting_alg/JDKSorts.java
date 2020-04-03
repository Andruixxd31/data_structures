
import java.util.Arrays;

public class JDKSorts {

    public static void main(String[] args) {
        int array[] = {20, 35, -15, 7, 55, 1, -22};

        Arrays.sort(array);  //uses dual pivot quicksort
        Arrays.parallelSort(array);

        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }

    }
}