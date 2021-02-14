package grafos1;

public class LinkedList<Item> implements Iterable<Item>{
    Nodo cabeza;
    Nodo ultimo;
    int longitud;

    private class Nodo
    {
    	private Item valor;
        public Nodo sig;
        //public Nodo anterior;
        
        Nodo(Item valor)
        {
            sig=null;
            //anterior=null;
            this.valor=valor;
        }
        
        public Item getvalor()
        {
            return valor;
        }
    }
    void inser_orden(Item n)
    {
        Nodo nuevo= new Nodo(n);
        if(cabeza==null)
        {
            cabeza=nuevo;
            ultimo=nuevo;
        }
        else if(n < cabeza.getvalor())
        {
            nuevo.sig=cabeza;
            cabeza=nuevo;
        }
        else
        {  
            Nodo ante=cabeza;
            Nodo p=cabeza;
            while(p.sig!=null && n > p.getvalor())
            {
                ante=p;
                p=p.sig;
            }
            if(n > p.getvalor()){
                ante=p;
            }
            nuevo.sig=ante.sig;
            ante.sig=nuevo; //esto es lo mismo que nuevo.anterior=ante;
        }
    }
    void insertar(ITem n)
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
    }

    void mostrar()
    {
        Nodo aux=cabeza;
        while(aux!=null)
        {
            System.out.println("El numero es: "+ aux.getvalor());
            aux=aux.sig;
        }
    }

    public void remove(){ //elimina la cabeza que esta como una pila
        if(cabeza != null)
        {   
            Nodo temp= cabeza;
            cabeza=cabeza.sig;
            return temp.valor
        }
        return null;
    }

    public Item remove_n(int n)
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
                        return delete;
                }
                        longitud--;
        }
        return null;
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node actual = cabeza;
    
        public boolean hasNext(){return actual != null;}

        public void remove(){}

        public Item next()
        {
            Item valor = actual.valor;
            actual = actual.sig;
            return valor;
        }
    }
}