import java.util.Iterator;

public class LinkedList<Item extends Comparable<Item>> implements Iterable<Item>{
    Nodo cabeza;
    Nodo ultimo;
    int N;

    private class Nodo implements Comparable<Item>
    {
    	private Item valor;
        public Nodo sig;
        
        Nodo(Item valor)
        {
            sig=null;
            this.valor=valor;
        }
        
        public Item getvalor()
        {
            return valor;
        }
        @Override      
        public int compareTo(Item that) {
        	
        	return this.getvalor().compareTo(that);
        }
        
    }
    
    
    
   public void inserOrden(Item n)
    {
        Nodo nuevo= new Nodo(n);

        if(cabeza==null)
        {
            cabeza=nuevo;
            ultimo=nuevo;
        }
        else if(n.compareTo(cabeza.getvalor()) <=0)
        {	
        	System.out.println(n.compareTo(cabeza.getvalor()) );
            nuevo.sig=cabeza;
            cabeza=nuevo;
        }
        else
        {  
            Nodo ante=cabeza;
            Nodo p=cabeza;
            while(p.sig!=null && (n.compareTo(p.getvalor()) == 1))
            {
                ante=p;
                p=p.sig;
            }
            if((n.compareTo(p.getvalor()) == 1)){
                ante=p;
            }
            nuevo.sig=ante.sig;
            ante.sig=nuevo; //esto es lo mismo que nuevo.anterior=ante;
        }
        N++;
    }

    public void insertar(Item n)
    {
        Nodo nuevo= new Nodo(n);
        if(cabeza==null)
        {
            cabeza=nuevo;
            ultimo=nuevo;
        }
        else
        {
            ultimo.sig=nuevo;
            ultimo=nuevo;
        }
        N++;
    }

    public void mostrar()
    {
        Nodo aux=cabeza;
        while(aux!=null)
        {
            System.out.println("El numero es: "+ aux.getvalor());
            aux=aux.sig;
        }
    }

    public Item remove(){ //elimina la cabeza que esta como una pila
        if(cabeza != null)
        {   
            Item valor= cabeza.valor;
            cabeza=cabeza.sig;
            N--;
            return valor;
            
        }
        return null;
    }

    public Item removeN(int n)
    {
        if(cabeza==null)
        {
            return null;
        }
        else if(n == 0)
        {	
        	Item item =cabeza.valor;
            cabeza = cabeza.sig;
            N--;
            return item;
            
        }
        else if(n < N)
        {
                Nodo current=cabeza;
                int contador=0;

                while(contador < (n-1))
                {
                        current=current.sig;
                        contador++;
                }
                Nodo delete=current.sig;
                current.sig=delete.sig;
                delete.sig=null;
                N--;
                return delete.valor;

        }
        return null;
    }

    public Iterator<Item> iterator() 
    {   return new ListIterator();   }

    private class ListIterator implements Iterator<Item>
    {
        private Nodo actual = cabeza;
        
        public void remove(){}

        public boolean hasNext(){return actual != null;}

        public Item next()
        {   
            Item valor = actual.valor;
            actual = actual.sig;
            return valor;
        }
    }
}