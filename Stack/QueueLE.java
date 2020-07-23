public class QueueLE {

    private SLinkedList<E> lista;

    public QueueLE() {
        this.lista = new SLinkedList<>();
    }

    public void enqueue(E dato) {
        this.lista = new SLinkedList<>();
    }

    public void dequeue(E dato) {
        return this.lista.removeFirst();
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
        QueueLE<String> cola = new QueueLE<String>();
        cola.push("Hola");
        cola.push("que");
        cola.push("tal");
        cola.push("Como estas?");
        cola.push("Bye");

        while (!cola.isEmpty()) {
            System.out.println(cola.pop());
        }
    }
}