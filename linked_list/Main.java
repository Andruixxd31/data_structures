
public class Main {

    public static void main(final String[] args){
        
        //Using List we can easily change to another type of data value
        Employee janeSmith = new Employee("Jane", "Smith", 123); 
        Employee johnJonas = new Employee("John", "Jonas", 456);
        Employee juanCarlos = new Employee("Juan", "Carlos", 789);
        Employee joseJose = new Employee("Jose", "Jose", 321);

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.isEmpty());

        list.addToFront(janeSmith);
        list.addToFront(johnJonas);
        list.addToFront(juanCarlos);
        list.addToFront(joseJose); //Since it was the last added this will become the head

        list.printList();
        System.out.println(list.isEmpty());
        System.out.println(list.getSize());

        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());

    }
}