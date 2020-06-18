import java.util.Vector;
import java.util.List;
//Vector work the same as ArrayList, the difference is that vector are synchronized 
//vectors are better suited to work with multiple threads that read and write

/**
 * Main
 */
public class Vec {

    public static void main(final String[] args) {

        // Using List we can easily change to another type of data value
        List<Employee> employeeList = new Vector<>();
        employeeList.add(new Employee("Jane", "Smith", 123));
        employeeList.add(new Employee("John", "Jonas", 456));
        employeeList.add(new Employee("Juan", "Carlos", 789));
        employeeList.add(new Employee("Jose", "Jose", 321));

        // The forEach is using a lambda expression
        employeeList.forEach(employee -> System.out.println(employee)); // Method already built in the interface
        System.out.println();

        // some methods
        System.out.println(employeeList.get(1));
        System.out.println(employeeList.isEmpty());
        employeeList.set(1, new Employee("Pedro", "Solis", 666));
        System.out.println(employeeList.get(1));

        System.out.println(employeeList.size());

        employeeList.add(3, new Employee("Doe", "Papajohns", 000)); // will add it at pos 3 and the values equal or
                                                                    // above three will bi shifted up by one
        employeeList.forEach(employee -> System.out.println(employee)); // Method already built in the interface
        System.out.println();

        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]); // getting the backing array
        for (Employee employee : employeeArray) {
            System.out.println(employee);
        }
        System.out.println();

        System.out.println(employeeList.contains(new Employee("Jose", "Jose", 321))); // uses the equals method
        System.out.println(employeeList.indexOf(new Employee("Jose", "Jose", 321))); // uses the equals method

        employeeList.remove(3);
        employeeList.forEach(employee -> System.out.println(employee)); // Method already built in the interface
        System.out.println();

    }
}