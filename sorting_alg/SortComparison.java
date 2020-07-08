
public class SortComparison {

	private static void swap(int arr[], int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	private void insercion(int arr[]) {
		int temp;
		for (int i = 1; i < arr.length; i++) {
			temp = arr[i];
			int j = i;
			while (j > 0 && arr[j - 1] > temp) {
				arr[j] = arr[j - 1];
				j--;
			}
			arr[j] = temp;
		}
	}

	private void bubble(int arr[]) {
		for (int j = arr.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}

	private void mergeSort(int[] input, int start, int end) {

		if (end - start <= 1) {
			return;
		}

		int mid = (start + end) / 2;
		mergeSort(input, start, mid);
		mergeSort(input, mid, end);
		merge(input, start, mid, end);
	}

	// { 20, 35, -15, 7, 55, 1, -22 }
	private void merge(int[] input, int start, int mid, int end) {

		if (input[mid - 1] <= input[mid]) {
			return;
		}

		int i = start;
		int j = mid;
		int tempIndex = 0;

		int[] temp = new int[end - start];
		while (i < mid && j < end) {
			temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
		}

		System.arraycopy(input, i, input, start + tempIndex, mid - i);
		System.arraycopy(temp, 0, input, start, tempIndex);
	}

	private void imprime(int a[]) {
		for (int i = 0; i < a.length; i++) {
			if (i % 10 == 0) {
				System.out.println();
			}
			System.out.printf("%8d ", a[i]);

		}
	}

	private int[] generaAleatorio(int n) {
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = (int) (Math.random() * (n * 4) + 1);

		}
		return arr;
	}

	private void quickSort(int x[]) {
		quickRec(x, 0, x.length - 1);
	}

	private void quickRec(int x[], int ini, int fin) {
		if (ini < fin) {
			int piv = pivote(x, ini, fin);
			quickRec(x, ini, piv - 1);
			quickRec(x, piv + 1, fin);
		}
	}

	private void seleccion(int arr[]) {
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

	private static int pivote(int x[], int ini, int fin) {
		int ipiv = (ini + fin) / 2;
		swap(x, ini, ipiv);
		int div = ini;
		for (int i = ini + 1; i <= fin; i++) {
			if (x[i] < x[ini]) {
				div++;
				swap(x, div, i);
			}
		}
		swap(x, ini, div);
		return div;
	}

	public static void main(String[] args) {
		SortComparison ord = new SortComparison();
		int[] arr = ord.generaAleatorio(750000);
		long inicio = System.currentTimeMillis();
		ord.mergeSort(arr, 0, 750000);
		// ord.imprime(arr);
		long fin = System.currentTimeMillis();
		System.out.println("\n mili: " + (fin - inicio));
	}
}
