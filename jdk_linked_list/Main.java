import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(final String[] args){
        
        //Using List we can easily change to another type of data value
        Employee janeSmith = new Employee("Jane", "Smith", 123); 
        Employee johnJonas = new Employee("John", "Jonas", 456);
        Employee juanCarlos = new Employee("Juan", "Carlos", 789);
        Employee joseJose = new Employee("Jose", "Jose", 321);

        LinkedList<Employee> list = new LinkedList<>(); //The implementation uses a duble linked list

        list.addFirst(janeSmith);
        list.addFirst(johnJonas);
        list.addFirst(juanCarlos);
        list.addFirst(joseJose);


        Employee joeMama = new Employee("Joe", "Mama", 58);
        list.add(joeMama); //adds it at the end of the list. Can also use addLast
    
        Iterator iter = list.iterator();
        System.out.println("HEAD ->");
        while(iter.hasNext()){
            System.out.println(iter.next());
            System.out.print("<==>");
        }
        System.out.println("null");
        System.out.println(list.size()); 

        list.removeFirst();
        list.removeLast();
        System.out.println(list.size()); 
        System.out.println(list.getFirst()); 
        
    }
}