import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Queue;

//Andrés Díaz de León
//A01620020

public class MyBST<E extends Comparable<E>> {
    private MyNodoBST<E> root;
    private int size; // #Total de nodos

    public MyBST() {
        this.root = null;
        this.size = 0;
    }

    public static void main(String[] args) {
        MyBST<Integer> bst = new MyBST<Integer>();
        bst.insert(21);
        bst.insert(13);
        bst.insert(33);
        bst.insert(10);
        bst.insert(18);
        bst.insert(33);
        bst.insert(25);
        bst.insert(40);
        bst.insert(29);
        bst.insert(27);
        bst.insert(30);
        bst.nivel();
    }

    /**
     * Metodo que trabaja con el arbol binario, toma el raiz nodo y llama a una
     * funcion sobrecargada que imprimiar el arbol de arriba hacia abajo
     */
    public void nivel() {
        nivel(this.root);
        System.out.println();
    }

    private void nivel(MyNodoBST<E> current) {
        Queue<MyNodoBST<E>> cola = new LinkedList<MyNodoBST<E>>();
        cola.add(current); // agrega el nodo raiz
        while (cola.size() > 0) {
            if (cola.peek().left != null) // checa si hay un elemento izquierdo primer objeto de la pila
                cola.add(cola.peek().left); // agrega el valor del hijo izquierdo
            if (cola.peek().right != null) // ve si hay un elemento a su derecha
                cola.add(cola.peek().right); // Agrega el valor del hijo de la derecha
            System.out.print(cola.poll().val + ",");
        }
    }

    /**
     * @param value val que se busca insertar.
     * @return Compara los vales del arbol binario desde la raíz se mueve a la
     *         izquierda si es menor y derechar si es mayor. Al econtrar un val null
     *         es el lugar donde se insertará el elemento
     */
    public void insert(E value) {
        MyNodoBST<E> nvo = new MyNodoBST<>(value);
        MyNodoBST<E> prev = null;

        if (this.root == null) {
            this.root = nvo;
        } else {
            MyNodoBST<E> current = this.root;

            while (current != null) {
                prev = current;
                if (value.equals(current.val)) {
                    return; // Si el val se repite
                } else if (value.compareTo(current.val) < 0) { // Izq
                    current = current.left;
                } else { // Der
                    current = current.right;
                }
            }
            // Prev apunta a quien será el padre de nvo
            // Prev va a siguendo a current
            if (value.compareTo(prev.val) < 0) {
                prev.left = nvo;
            } else {
                prev.right = nvo;
            }
        }
        this.size++;
    }

    /**
     * 
     * @param value val a encontrar dentro del arbol
     * @return regresa el val dado si es que esta disponible en arból
     */
    public E search(E value) {
        MyNodoBST<E> current = this.root;
        if (this.root == null) {
            throw new NoSuchElementException();
        }
        while (current != null) {
            if (value.compareTo(current.val) < 0) {
                current = current.left;
            } else if (value.compareTo(current.val) > 0) {
                current = current.right;
            } else {
                MyNodoBST<E> nodeSearched = current;
                return nodeSearched.val;
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * 
     * @param value valor que se busca eliminar. Este metodo maneja 3 casos para
     *              eliminar el valor
     * @return el valor eliminado
     */
    public E remove(E value) {
        try {
            if (this.root == null) {
                throw new NoSuchElementException("No se puede borrar de un árbol vacío");
            } else if (this.root.val.equals(value)) {
                if (this.root.left == null && this.root.right == null)
                    this.root.val = null;
                else if (this.root.left == null) {
                    this.root.val = this.root.right.val;
                    this.root.right = null;
                } else {
                    this.root.val = this.root.left.val;
                    this.root.right = null;
                }
            }

            MyNodoBST<E> parent = null;
            MyNodoBST<E> current = this.root;

            while (!current.val.equals(value)) {
                parent = current;
                if (value.compareTo(current.val) < 0) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            E res = current.val;
            if (current.left == null && current.right == null) {
                if (parent.left == current) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            } else if (current.left == null) {
                if (parent.left == current) {
                    parent.left = current.right;
                } else {
                    parent.right = current.right;
                }
            } else if (current.right == null) {
                if (parent.right == current) {
                    parent.left = current.left;
                } else {
                    parent.right = current.left;
                }
            } else {
                E tmpPredecesor = predecesor(current).val;
                current.val = remove(tmpPredecesor);
                this.size++;
            }
            this.size--;
            return res;
        } catch (NullPointerException ex) {
            throw new NoSuchElementException("No se puede borar un elemento que no está en el árbol");
        }
    }

    private MyNodoBST<E> predecesor(MyNodoBST<E> current) {
        MyNodoBST<E> predecesor = current.left;
        while (predecesor.right != null) {
            predecesor = predecesor.right;
        }
        return predecesor;
    }

    /**
     * 
     * @return el elemento mas grande al solo recorrer el extremo derecho hasta
     *         llegar a un nodo hoja
     */
    public E findMax() {
        if (this.root == null) {
            throw new NoSuchElementException();
        }
        MyNodoBST<E> current = this.root;
        while (current.right != null)
            current = current.right;
        return current.val;
    }

    /**
     * 
     * @return el elemento mas grande al solo recorrer el extremo izquierdo hasta
     *         llegar a un nodo hoja
     */
    public E findMin() {
        if (this.root == null) {
            throw new NoSuchElementException();
        }
        MyNodoBST<E> current = this.root;
        while (current.left != null)
            current = current.left;
        return current.val;
    }

    private void preorden(MyNodoBST<E> current) {
        if (current != null) {
            System.out.print(current.val + ",");
            preorden(current.left);
            preorden(current.right);
        }
    }

    public void preorden() {
        preorden(this.root);
        System.out.println();
    }

    private void inorden(MyNodoBST<E> current) {
        if (current != null) {
            inorden(current.left);
            System.out.print(current.val + ", ");
            inorden(current.right);
        }
    }

    public void inorden() {
        inorden(this.root);
        System.out.println();
    }

    private void posorden(MyNodoBST<E> current) {
        if (current != null) {
            posorden(current.left);
            posorden(current.right);
            System.out.print(current.val + ", ");
        }
    }

    public void posorden() {
        posorden(this.root);
        System.out.println();
    }

}

class MyNodoBST<E> {
    // Attributes
    MyNodoBST<E> left;
    MyNodoBST<E> right;
    E val;

    // Methods
    public MyNodoBST(E val) {
        this(val, null, null);
    }

    public MyNodoBST(E val, MyNodoBST<E> left, MyNodoBST<E> right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public MyNodoBST<E> getLeft() {
        return left;
    }

    public void setLeft(MyNodoBST<E> left) {
        this.left = left;
    }

    public MyNodoBST<E> getRight() {
        return right;
    }

    public void setRight(MyNodoBST<E> right) {
        this.right = right;
    }

    public E getval() {
        return val;
    }

    public void setval(E val) {
        this.val = val;
    }

    // @Override
    // public String toString() {
    // return "MyNodoBST [left=" + left + ", right=" + right + ", val=" + val + "]";
    // }
}