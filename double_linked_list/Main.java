
public class Main {

    public static void main(final String[] args){
        
        //Using List we can easily change to another type of data value
        Employee janeSmith = new Employee("Jane", "Smith", 123); 
        Employee johnJonas = new Employee("John", "Jonas", 456);
        Employee juanCarlos = new Employee("Juan", "Carlos", 789);
        Employee joseJose = new Employee("Jose", "Jose", 321);

        EmployeeDoubleLinkedList list = new EmployeeDoubleLinkedList();

        list.addToFront(janeSmith);
        list.addToFront(johnJonas);
        list.addToFront(juanCarlos);
        list.addToFront(joseJose);

        Employee joeMama = new Employee("Joe", "Mama", 58);
        list.addToEnd(joeMama);

        list.removeFromFront();
        list.removeFromEnd();
        list.printList();
        System.out.println(list.getSize());
    }
}