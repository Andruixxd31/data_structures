import java.util.NoSuchElementException;

public class SLinkedList<E extends Comparable<E>> {

	private NodeG<E> first;
	private NodeG<E> last;
	private int size;

	public SLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}

	public SLinkedList(E[] a) {
		if (a.length > 0) {
			for (int i = 0; i < a.length; i++) {
				insertAt(i, a[i]);
			}
		} else {
			throw new NoSuchElementException("No hay elementos en el arreglo");
		}

	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public E first() {
		try {
			return this.first.getDato();
		} catch (NullPointerException ex) {
			throw new NoSuchElementException("No hay elementos");
		}
	}

	public E last() {
		try {
			return this.last.getDato();
		} catch (NullPointerException ex) {
			throw new NoSuchElementException("No hay elementos");
		}
	}

	public void addFirst(E dato) {
		this.first = new NodeG<E>(dato, this.first);
		if (isEmpty())
			this.last = this.first;
		this.size++;
	}

	public void addLast(E dato) {
		if (!isEmpty()) {
			this.last.setNext(new NodeG<E>(dato));
			this.last = this.last.getNext();
			size++;
		} else
			this.addFirst(dato);
	}

	public boolean contains(E data) {
		NodeG<E> tmp = this.first;

		while (tmp != null) {
			if (tmp.getDato().compareTo(data) == 0)
				return true;
			tmp = tmp.getNext();
		}
		return false;
	}

	public E removeFirst() {

		if (isEmpty())
			throw new NoSuchElementException();
		NodeG<E> tmp = this.first;
		first = first.getNext();
		size--;
		if (this.first == null) {
			this.last = null;
		}
		tmp.setNext(null);
		return tmp.getDato();
	}

	public E removeLast() {
		if (this.size > 1) {
			E valor = this.last();
			NodeG<E> tmp = this.first;
			for (int i = 0; i < size - 2; i++) {
				tmp = tmp.getNext();
			}
			tmp.setNext(null);
			this.last = tmp;
			this.size--;
			return valor;
		} else {
			return this.removeFirst();
		}
	}

	public E getAt(int pos) {
		System.out.println(this.size);
		if (pos < 0 || pos >= this.size) {
			throw new NoSuchElementException("No se puede obtener un elemento en esta posicion");
		} else if (pos == size - 1) {
			return last();
		} else {
			NodeG<E> tmp = this.first;
			for (int i = 0; i < pos; i++) {
				tmp = tmp.getNext();
			}
			return tmp.getDato();
		}
	}

	public void setAt(int pos, E valor) {
		if (pos < 0 || pos >= this.size) {
			throw new NoSuchElementException("No se puede obtener un elemento en esta posicion");
		} else if (pos == size - 1) {
			this.last.setData(valor);
		} else {
			NodeG<E> tmp = this.first;
			for (int i = 0; i < pos - 1; i++) {
				tmp = tmp.getNext();
			}
			tmp.setData(valor);
		}
	}

	public void insertAt(int pos, E valor) {
		if (pos < 0 || pos > this.size)
			throw new IndexOutOfBoundsException("No se puede insertar en esa pos");
		else if (pos == this.size - 1)
			addLast(valor);
		else {
			NodeG<E> tmp = this.first;
			for (int i = 0; i < pos - 1; i++)
				tmp = tmp.getNext();
			NodeG<E> nuevo = new NodeG<E>(valor);
			nuevo.setNext(tmp.getNext());
			tmp.setNext(nuevo);
			this.size++;
		}
	}

	public E removeAt(int pos) {
		if (pos < 0 || pos >= this.size)
			throw new IndexOutOfBoundsException("No se puede acceder al elemento en la posicon dada");
		else if (pos == this.size - 1)
			return removeLast();
		else {
			NodeG<E> tmp = this.first;
			for (int i = 0; i < pos; i++)
				tmp = tmp.getNext();
			tmp.setNext(tmp.getNext().getNext());
			this.size--;
			return tmp.getDato();
		}
	}

	public String toString() {
		String str = "";
		NodeG<E> tmp = this.first;

		for (int i = 0; i < size; i++) {
			str += tmp.getDato() + " -> ";
			tmp = tmp.getNext();
		}
		return str;
	}

	public static void main(String[] args) {
		SLinkedList<Integer> link = new SLinkedList<Integer>();
		link.addFirst(0);
		link.addFirst(2);
		link.addFirst(4);
		link.addFirst(6);
		link.addFirst(8);
		link.addFirst(10);
		link.insertAt(3, 200);
		System.out.println();
		System.out.println(link.toString());
	}

}
