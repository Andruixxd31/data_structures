public class SelectionSort {

    private static void seleccion(int arr[]) {
        for (int j = arr.length - 1; j > 0; j--) {

            int largest = 0;

            for (int i = 1; i <= j; i++) {
                if (arr[i] > arr[largest]) {
                    largest = i;
                }
            }
            swap(arr, largest, j);
        }
    }

    private static void swap(int arr[], int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = { 9, 1, 8, 2, 7, 3, 6, 4, 5, 0 };
        seleccion(numbers);
    }
}
