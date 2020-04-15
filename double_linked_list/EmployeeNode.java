
public class EmployeeNode {

    private Employee employee;
    private EmployeeNode next; //Node that will be used to point to node infront of it
    private EmployeeNode previous; //Points the previous node

    public EmployeeNode(Employee employee){
        this.employee = employee;
    }

    public Employee getEmployee(){
        return this.employee;
    }

    public void setEmployee(Employee employee){
        this.employee = employee;
    }

    public EmployeeNode getNext(){
        return this.next; 
    }

    public void setNext(EmployeeNode next){
        this.next = next; //wiil be used to point to the next node
    }

    public EmployeeNode getPrevious(){
        return this.previous; 
    }

    public void setPrevious(EmployeeNode previous){
        this.previous = previous; //wiil be used to point to the next node
    }

    public String toString(){
        return employee.toString();
    }

}
