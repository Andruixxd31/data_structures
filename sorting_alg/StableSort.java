
public class StableSort {

    public static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }

    }

    public static void radixSingleSort(int[] input, int position, int radix){

        int numItems = input.length;
        int[] countArray = new int[radix];
        for (int value: input) {
            countArray[getDigit(position, value, radix)]++;
        }
        
        //Adjusts the countArray
        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j -1];
        }

        int[] temp = new int[numItems];
        for (int tempoIndex = numItems - 1; tempoIndex >= 0; tempoIndex--){
            temp[--countArray[getDigit(position, input[tempoIndex], radix)]] = input[tempoIndex];
        }

        for(int tempoIndex = 0; tempoIndex < numItems; tempoIndex++){
            input[tempoIndex] = temp[tempoIndex];
        }
    }

    public static int getDigit(int position, int value, int radix){
        return value / (int) Math.pow(radix, position) % radix;
    }
    public static void main(String[] args) {
        
        int[] array = {4725, 4586, 1330, 8792, 1594, 5729};

        radixSort(array, 10, 4);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}