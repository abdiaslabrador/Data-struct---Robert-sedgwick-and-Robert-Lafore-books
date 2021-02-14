import java.util.*;

public class Bag<Item> implements Iterable<Item>
{
private Node cabeza; // first node in list
private short longitud;
        Bag()
        {   
            cabeza=null;
        }
        private class Node
        {
            Item valor;
            Node sig;
        }
        public void add(Item item)// anade en la cabeza
        { // same as push() in Stack
            Node oldfirst = cabeza;
            cabeza = new Node();
            cabeza.valor = item;
            cabeza.sig = oldfirst;
            longitud ++;
        }
        public short tamano()
        {
            return longitud;
        }
    public Iterator<Item> iterator()
    { 
    return new ListIterator(); 
    }
    private class ListIterator implements Iterator<Item>
    {
        private Node actual = cabeza;
    
            public boolean hasNext()
            { 
            return actual != null;
            }

            public void remove(){ //elimina la cabeza que esta como una pila

                if(cabeza != null)
                {
                    cabeza=cabeza.sig;

                }
                else
                {
                    System.out.println("Ya esta vacia\n");
                }
            }
            public void remove_n(int n)
            {
                if(hasNext())
                {
                        if(n ==0){
                                cabeza=null;

                        }
                        else if(n < longitud)
                        {
                                Node current=cabeza;
                                int contador=0;

                                while(contador < (n-1))
                                {
                                        current=current.sig;
                                        longitud++;
                                }
                                Node delete=current.sig;
                                current.sig=delete.sig;
                                delete.sig=null;
                        }
                                longitud--;
                }
                else
                {
                        System.out.println("La lista está vacia");
                }
            }

            public Item next()
            {
                Item valor = actual.valor;
                actual = actual.sig;
                return valor;
            }
    }
}
