//counting sort makes asumptions about data
//counting sort works with non negative discretes values 
//Doesn't use comparisons 
//the values must be within a specified range
//counting sort has a linear time due to its asumptions


public class Counting {

    public static void countingSort(int[] input, int min, int max){
        int[] countArray = new int[max-min+1]; //calculating the number of values

        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++; //translating the value we want to count into its index
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            //checks if there is a count in each element of the countArray
            //If there is 
            while (countArray[i - min] > 0){ 
                input[j++] = i; //add one of the values to the input array
                countArray[i - min]--; //decrement the count of elements in the index of countArray
            }
        }
    }
    public static void main(String[] args) {
        //when using a count array we want the number of values to be similar to the length of the array
        //we have 10 values in an array of lenght 10
        int[] array = {2,5,9,8,2,8,7,10,4,3};

        countingSort(array, 1, 10);

        for (int i = 0; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}
