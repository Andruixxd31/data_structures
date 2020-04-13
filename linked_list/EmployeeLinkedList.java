
public class EmployeeLinkedList {

    private EmployeeNode head; //The start of the linked list. Is the last introduced element
    private int size;

    public int getSize() {
        return this.size; //instead of iterating we get this variable to know the size
    }

    public boolean isEmpty() {
        return this.head == null; //If there are no elements the head is null, it is started like that by default
    }

    public void addToFront(Employee employee){
        EmployeeNode node = new EmployeeNode(employee); //creates the node of the employee added
        node.setNext(head); //points to the node infront of it. the head is the element that came before this one
        head = node; //the head is updated to this current employee, if anothe element is added this head will be used to point into this employee
        size++; //each time an element is added this will be increased
    }

    public EmployeeNode removeFromFront() {
        if(isEmpty()){  //wont do anything if there are no employees
            return null;
        }
        EmployeeNode removedNode = head; //will be used to set this node to null
        head = head.getNext(); //head is now the element infront of it, sinces this one will be deleted
        size--; //decreasing size to keep count of node
        removedNode.setNext(null); //making null
        return removedNode;
    }

    public void printList() {
        EmployeeNode current = head; //used to traverse the linked list
        System.out.println("HEAD ->");
        while(current != null){
            System.out.print(current);
            System.out.println(" ->");
            current = current.getNext(); 
        }
        System.out.println("null");
    }
}