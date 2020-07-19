public class NodeG<E> {

	private E dato;
	private NodeG<E> next;

	public NodeG(E dato) {
		this.dato = dato;
		this.next = null;
	}

	public NodeG(E data, NodeG<E> next) {
		this.dato = data;
		this.next = next;
	}

	public void setData(E data) {
		this.dato = data;
	}

	public void setNext(NodeG<E> next) {
		this.next = next;
	}

	public E getDato() {
		return this.dato;
	}

	public NodeG<E> getNext() {
		return this.next;
	}

	public String toString() {
		return "" + this.dato;
	}
}
