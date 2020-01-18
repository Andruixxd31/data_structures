//for binary search to work the elements must be in order
//Binary search uses at most 1 + lgN
public class BinarySearch {

    public static int binarySearch(int[] a, int key){
        int lo = 0, hi = a.length-1; //Lo and hi cover the first and last element
        while (lo < hi){
            int mid = lo + (hi - lo) / 2; //gets to the middle of the portion of the list that has to be evaluated
            if (key  < a[mid]) { 
                //if the key is smaller than the element in the middle of the portion
                //The hi value will be changed so that everything bigger or equal to mid is ignored
                //In other words everything from mid to the right will be ignored
                hi = mid - 1;
                System.out.println("hi: " + hi);
            }
            else if (key > a[mid]){
                //In here everything equal or smaller than mid is ignored
                lo = mid + 1;
                System.out.println("lo: " + lo);
            } 
            else return mid; //returns the index of the key
        }
        //In case the number is not in the array
        //In this case lo and hi are in the same index or they switched sides to one another
        //It is sure to say that the value is not in the array.
        return -1; 
    }
    public static void main(String[] args) {
        int arr[] = {10,20,30,40,50,60,70,80,90};
        int key = 30; 
        int result = binarySearch(arr,key);
        System.out.println("Postion of the key: " + result);
        System.out.println(1 / 2);
    }
}