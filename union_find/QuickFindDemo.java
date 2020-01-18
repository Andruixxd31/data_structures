
public class QuickFindDemo {
    private int[] id;

    //Constructor creates and array of N elements from 0 to N
    public QuickFindDemo(int N) { 
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    
    //Compares the value of the indexes to see if they are the same.
    //If the values are the same the elements are connected. 
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    //connects the elements
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i++) {
            if(id[i] == pid) { 
                //compares the value of the index to the value of the element. 
                //if the value is the same as p it will be changed to the value of q, thus connecting them
                id[i] = qid;
            }
            
        }
    }

    //Prints the indexes above and the value of the elements below
    //It makes it easy to see what is connected to what
    public void show(){
        for(int i = 0; i < id.length; i++){
            System.out.print(i + " ");
        } 
        System.out.println();
        for(int i = 0; i < id.length; i++){
            System.out.print(id[i] + ",");
        } 
        System.out.println();
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) {
        QuickFindDemo qfd = new QuickFindDemo(10);
        qfd.union(1, 2);
        qfd.show();
        System.out.println(qfd.connected(1,2));
        qfd.union(8, 7);
        qfd.show();
        qfd.union(7, 3);
        qfd.show();
        qfd.union(3,0);
        qfd.show();
    }
    
}