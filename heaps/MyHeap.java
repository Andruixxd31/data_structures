import java.util.*;

public class MyHeap<E extends Comparable<E>> {

    private int size;
    private E[] heap;

    public MyHeap(int lenght) {
        this.heap = (E[]) new Comparable[lenght];
        this.size = 0;
    }

    public MyHeap() {
        this(15);
    }

    public MyHeap(E[] valores) {
        this.heap = valores;
        this.size = valores.length;
        this.heapify();

    }

    private void swap(int a, int b) {
        E tmp = this.heap[a];
        this.heap[a] = this.heap[b];
        this.heap[b] = tmp;
    }

    // Todo si el arreglo esta lleno al tratar de inserta expandir por un nivel
    public void insert(E value) {
        this.heap[this.size++] = value;
        int current = this.size - 1;
        while (current > 0) {
            if (value.compareTo(this.heap[(current - 1) / 2]) > 0) {
                swap(current, (current - 1) / 2);
                current = (current - 1) / 2;
            } else {
                break;
            }
        }
    }

    // TODO
    // arrojar NoSuchElementException
    public E remove(E valor) {
        if (this.size == 0) {
            throw new NoSuchElementException("El heap esta vacio");
        }
        this.heap[0] = this.heap[this.size];
        this.heap[this.size - 1] = null;
        this.size--;
        heapify();
        return valor;
    }

    public void heapify() {
        heapify(this.heap, this.size / 2 - 1);
    }

    private void heapify(E[] valores, int i) {

        if (i < 0)
            return;
        int max = i;

        if (2 * i + 1 < this.size)
            if (this.heap[max].compareTo(this.heap[2 * i + 1]) < 0)
                max = 2 * i + 1;
        if (2 * i + 2 < this.size)
            if (this.heap[max].compareTo(this.heap[2 * i + 2]) < 0)
                max = 2 * i + 2;
        if (max != i) {
            swap(i, max);
            heapify(valores, 2 * i + 2);
        }
        heapify(valores, i - 1);
    }

    public static void main(String[] args) {
        Integer[] valores = { 3, 5, 2, 7, 0, 9, 8, 4 };
        MyHeap mh = new MyHeap(valores);
        for (int i = 0; i < valores.length; i++) {
            System.out.println(valores[i]);
        }
    }
}