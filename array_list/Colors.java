
import java.util.ArrayList;
import java.util.Arrays;

public class Colors {

    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<>(3);
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.forEach(color -> System.out.print(color + ", "));
        System.out.println();

        colors.add(0, "Yellow");
        colors.forEach(color -> System.out.print(color + ", "));
        System.out.println("\nThe fourth element is " + colors.get(3));
        colors.set(3, "Purple");
        System.out.println("The fourth element is now " + colors.get(3));
    }
}