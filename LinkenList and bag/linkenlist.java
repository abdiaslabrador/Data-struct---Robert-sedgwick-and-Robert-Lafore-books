package grafos1;

public class Lista {
    Nodo cabeza;
    Nodo ultimo;
    int lon;
    Lista()
    {
        lon=0;
        cabeza=null;  
    }
    public class Nodo
    {
    	private int valor;
        public Nodo sig;
        public Nodo anterior;
        
        Nodo(int valor)
        {
            sig=null;
            anterior=null;
            this.valor=valor;
        }
        
        public int getvalor()
        {
            return valor;
        }
    }
    void inser_orden(int n)
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
	   nuevo.anterior=ante;
           ante.sig=nuevo;
        }
    }
    void insertar(int n)
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
}