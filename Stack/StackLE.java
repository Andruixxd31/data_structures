
/**
 * StackLE
 */
public class StackLE<E> {

    private SLinkedList<E> lista;

    public StackLE() {
        this.lista = new SLinkedList<>();
    }

    public void push(E dato) {
        this.lista.addFirst(dato);
    }

    public E pop() {
        return this.lista.removeFirst();
    }

    public E top() {
        return this.lista.first();
    }

    public int size() {
        return this.lista.size;
    }

    public boolean isEmpty() {
        return this.lista.isEmpty();
    }

    public void flush() {
        this.lista = new SLinkedList<>();
        System.gc();
    }

    public static void main(String[] args) {
        StackLE<String> pila = new StackLE<String>();
        pila.push("Hola");
        pila.push("que");
        pila.push("tal");
        pila.push("Como estas?");
        pila.push("Bye");

        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }
}