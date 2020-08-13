//Andrés Díaz de León
//A01620020

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.*;
import javax.swing.*;

public class Huffman {

    private Nodo root;
    private HashMap<Character, Integer> map = new HashMap<>();
    private PriorityQueue<Nodo> min = new PriorityQueue<Nodo>(new Comparador());

    /**
     * Con fileChooser se elije el achieve El metodo lee caracter por caracter y los
     * va agregando a un hashmap con valor de 1 si es que no estaban antes, si ya
     * estaban se actualiza el valor incrementandole 1
     */
    public void leerArchivo() {
        try {
            JFileChooser fc = new JFileChooser();
            int res = fc.showOpenDialog(new JPanel());
            if (res == JFileChooser.APPROVE_OPTION) {
                BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile()));
                // BufferedReader br = new BufferedReader(new FileReader("prueba.txt"));
                String linea = null;
                while ((linea = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(linea);
                    while (st.hasMoreTokens()) {
                        String word = st.nextToken();
                        for (int i = 0; i < word.length(); i++) {
                            if (!this.map.containsKey(word.charAt(i)))
                                this.map.put(word.charAt(i), 1);
                            else
                                this.map.replace(word.charAt(i), this.map.get(word.charAt(i)) + 1);
                        }
                    }
                }
                br.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No se encontro el archivo");
        } catch (IOException ex) {
            System.out.println("No se puede cerrar el archivo");
        }
        // System.out.println("\n" + this.map.toString());
    }

    /**
     * Itera por el hashmap y agrega los valores a un PriorityQueue que va en orden
     * ascendente
     */
    public void crearPQ() {
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            min.add(new Nodo(e.getKey(), e.getValue()));
        }
        // while (!min.isEmpty()) {
        // System.out.println(min.poll().dato);
        // }
    }

    /**
     * Con ayuda del priorityQueue toma los primeros valores lo cual son el mas
     * chico disponible Une los nodos con uno nuevo que lleva la suma de las
     * frecuencias y lo agrega en el PQ Cuando queda vacio el nodo raiz es igual al
     * ultimo nodo agregado
     */
    public void crearArbol() {
        while (this.min.size() > 1) {
            Nodo tmp = new Nodo(' ', 0);
            tmp.izq = min.poll();
            tmp.der = min.poll();
            tmp.dato = tmp.izq.dato + tmp.der.dato;

            if (this.min.isEmpty()) {
                this.root = tmp;
                this.min.add(tmp);
                // System.out.println(tmp.dato);
                break;
            }
            // System.out.println(tmp.dato);
            this.min.add(tmp);
        }
    }

    /**
     * Imprime el arbol por niveles, iniciando en el mas alto y descendiendo
     */
    public void nivel() {
        System.out.println(this.root.dato);
        nivel(this.root);
        System.out.println();
    }

    private void nivel(Nodo actual) {
        Queue<Nodo> cola = new LinkedList<Nodo>();
        cola.add(actual);
        while (cola.size() > 0) {
            if (cola.peek().izq != null)
                cola.add(cola.peek().izq);
            if (cola.peek().der != null)
                cola.add(cola.peek().der);

            if (!cola.isEmpty()) {
                System.out.print(cola.peek().caracter + ": " + cola.poll().dato + ", ");
            }
        }
    }

    /**
     * Se usa el preorden para trasversas recursivamente el arbol y econtrar sus
     * valores Con un string si va a la izquierda se le agrega un 0 y a la derecha
     * un 1 Los nodos hojas serán siempre los caracteres al encontrarlos se imprimen
     * con su codigo
     */
    public void preorden() {
        preorden(this.root, "");
    }

    private void preorden(Nodo actual, String encript) {
        if (actual.izq == null && actual.der == null) {
            System.out.println(actual.caracter + ": " + encript);
            return;
        }

        preorden(actual.izq, encript + 0);
        preorden(actual.der, encript + 1);
    }

    public static void main(String[] args) {
        Huffman hn = new Huffman();
        hn.leerArchivo();
        hn.crearPQ();
        hn.crearArbol();
        // System.out.println("-------------------------------");
        // hn.nivel();
        System.out.println("-------------------------------");
        hn.preorden();
    }

}

class Nodo {
    int dato;
    char caracter;
    Nodo izq;
    Nodo der;

    /**
     * 
     * @param caracter el caracter unico para hacer el arbol
     * @param dato     el numero de veces que se presenta el caracter en el archivo
     */
    public Nodo(char caracter, int dato) { // constructor of the class
        this.dato = dato;
        this.caracter = caracter;
        this.izq = null;
        this.der = null;
    }
}

/**
 * A vece del comparador se organizará el PriorityQueue
 */
class Comparador implements Comparator<Nodo> {

    /**
     * @param x dato del primer nodo
     * @param y dato del segundo nodo
     */
    public int compare(Nodo x, Nodo y) {
        return x.dato - y.dato;
    }
}
