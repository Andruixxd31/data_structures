import java.util.*;

public class MyHashTable<K, V> {

    private int size;

    private LinkedList<NodoHT<K, V>>[] tabla;

    public MyHashTable(int length) {
        this.size = 0;
        this.tabla = (LinkedList<NodoHT<K, V>>[]) new LinkedList[length];
        for (int i = 0; i < this.tabla.length; i++) {
            this.tabla[i] = new LinkedList<NodoHT<K, V>>();
        }
    }

    public void put(K key, V value) {
        int pos = Math.abs(key.hashCode()) % this.tabla.length;
        this.tabla[pos].addFirst(new NodoHT<K, V>(key, value));
        this.size++;
    }

    public V get(K key) {
        int pos = Math.abs(key.hashCode()) % this.tabla.length;
        LinkedList<NodoHT<K, V>> lista = this.tabla[pos];
        for (NodoHT<K, V> nodo : lista) {
            if (key.equals(nodo.key)) {
                return nodo.getValue();
            }
        }
        throw new NoSuchElementException("No esta la " + key + " en la tabla");
    }

    public V remove(K key) {
        int pos = Math.abs(key.hashCode()) % this.tabla.length;
        LinkedList<NodoHT<K, V>> lista = this.tabla[pos];
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getKey().equals(key)) {
                return lista.remove(i).getValue();
            }
        }
        throw new NoSuchElementException("No esta la llave " + key + " en la tabla");
    }

    public boolean containsKey(K key) {
        int pos = Math.abs(key.hashCode()) % this.tabla.length;
        LinkedList<NodoHT<K, V>> lista = this.tabla[pos];
        for (int i = 0; i < lista.size(); i++)
            if (lista.get(i).getKey().equals(key))
                return true;
        return false;
    }

    public boolean containsValue(V value) {
        for (int i = 0; i < tabla.length; i++) {
            LinkedList<NodoHT<K, V>> lista = this.tabla[i];
            for (int j = 0; j < lista.size(); j++)
                if (lista.get(j).getValue().equals(value))
                    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashTable<String, String> tabla = new MyHashTable<>(15);
        tabla.put("Angela", "Tennis");
        tabla.put("Andres", "Nadar");

        // System.out.println(tabla.get("Angela"));
        // System.out.println(tabla.get("Andres"));
        // System.out.println(tabla.containsKey("Andre"));
        System.out.println(tabla.containsValue("Comer"));
        // System.out.println(tabla.get("Vanya"));
        // System.out.println(tabla.get("Marijose"));
        // tabla.remove("Angela");
        // System.out.println(tabla.get("Andres"));
        // System.out.println(tabla.get("Angela"));
    }
}

class NodoHT<K, V> {
    K key;
    V value;

    public NodoHT(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }
}