
public class EmployeeDoubleLinkedList {

    private EmployeeNode head; //The start of the linked list. Is the last introduced element
    private EmployeeNode tail; //Starts as null, no constructor needed for tail and head
    private int size;

    public int getSize() {
        return this.size; //instead of iterating we get this variable to know the size
    }

    public boolean isEmpty() {
        return this.head == null; //If there are no elements the head is null, it is started like that by default
    }

    public void addToFront(Employee employee){
        EmployeeNode node = new EmployeeNode(employee); //creates the node of the employee added

        if (head == null){ //if we are adding a node to an empty list
            tail = node;  //tail will be asigned the current node. the first node has a head and tail
        } else {
            head.setPrevious(node); //after the first node this will be runned and head will be the newest node
            node.setNext(head);
        }

        head = node; 
        size++; //each time an element is added this will be increased
    }

    public void addToEnd(Employee employee){
        EmployeeNode node = new EmployeeNode(employee); 

        if (tail == null){ //if we are adding a node to an empty list
            head = node;  
        } else {
            tail.setNext(node); //Tail is the node added
            node.setPrevious(tail); //the new node is added to what used to be the tailed
        }

        tail = node;  
        size++; 
    }

    public EmployeeNode removeFromFront() {
        if(isEmpty()){  //wont do anything if there are no employees
            return null;
        }

        EmployeeNode removedNode = head; //will be used to set this node to null

        if (head.getNext() == null) { //If there is only one node 
            tail = null;
        } else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext(); //head is now the element infront of it, sinces this one will be deleted
        size--; //decreasing size to keep count of node
        removedNode.setNext(null); //making null
        return removedNode;
    }

    public EmployeeNode removeFromEnd() {
        if(isEmpty()){  //wont do anything if there are no employees
            return null;
        }

        EmployeeNode removedNode = tail; //will be used to set this node to null

        if (tail.getPrevious() == null) { //If there is only one node 
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }

        tail = tail.getPrevious(); //head is now the element infront of it, sinces this one will be deleted
        size--; //decreasing size to keep count of node
        removedNode.setPrevious(null); //making null
        return removedNode;
    }

    public void printList() {
        EmployeeNode current = head; //used to traverse the linked list
        System.out.println("HEAD ->");
        while(current != null){
            System.out.print(current);
            System.out.println(" <==>");
            current = current.getNext(); 
        }
        System.out.println("null");
    }
}