
public class QuickUnionWeighted {
    private int[] id;
    private int[] sz;

    //Constructor creates and array of N elements from 0 to N
    public QuickUnionWeighted(int N){
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
        } 
    }


    private int root(int i){
        //looks for the root of the element
        //if the value of the element is not the same as the value of the index 
        //It will change the value of element to the value of the index in its position
        //It repeats itself until they are the same. meaning the root was found
        while (i != id[i]) i = id[i]; 
        return i; // returns the root
    }

    //See if both values share the same root
    public boolean connected(int p, int q){
        return root(p) == root(q);
    }

    public void union(int p, int q){
        int i = root(p);
        int j = root(q);
        if(i == j) return;
        if(sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    //Prints the index and the tree.
    //It is used to see how the elements are connected
    public void show(){
        for (int i = 0; i < id.length; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println(" <-- Tree");
        for(int i = 0; i < id.length; i++){
            System.out.print(i + " ");
        }
        System.out.println(" <-- Array");
        System.out.println("-------------------------------");
    }
    
    public static void main(String[] args) {
        QuickUnionWeighted qud = new QuickUnionWeighted(10);
        qud.show();
        qud.union(4,3);
        qud.union(3,8);
        qud.show();
        qud.union(6,5);
        qud.union(9,4);
        qud.union(2,1);
        qud.union(5,0);
        qud.union(7,2);
        qud.union(6,1);
        qud.union(7,3);
        qud.show();
    }
}