import java.util.*;

public class Cola<Item> {
    private Nodo cabeza; // link to least recently added node
    private Nodo ultimo; // link to most recently added node
    private int longitud;
    // number of items on the queue
    private class Nodo
    { // nested class to define nodes
    Item item;
    Nodo sig;
    }
    public boolean esVacio() {return cabeza == null;}
    public int tamano()
    {
    return longitud; 
    }
    // Or: N == 0.
    public void encolar(Item item)
    { // Add item to the end of the list.
        Nodo oldlast = ultimo;
        ultimo = new Nodo();
        ultimo.item = item;
        ultimo.sig = null;
        if (esVacio()) cabeza = ultimo;
        else
        oldlast.sig = ultimo;
        longitud++;
    }
    public Item desencolar()
    { // Remove item from the beginning of the list.
        Item item = cabeza.item;
        cabeza = cabeza.sig;
        if (esVacio()) ultimo = null;
        longitud--;
        return item;
    }
    public Iterator<Item> iterator(){ return new ListIterator(); }
    private class ListIterator implements Iterator<Item>
    {
        private Nodo actual = cabeza;
        public boolean hasNext(){ return actual != null;}
        public void remove() { }
        public Item next()
        {
        Item item = actual.item;
        actual = actual.sig;
        return item;
        }
    }
    
}
