import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;



import java.lang.reflect.Array;


public class HolaMundo {
	
    public static void main(String args[]){
    	String a = "cristal";
    	String b = "aristal";
    	
    	System.out.println(a.compareTo(a));
    	LinkedList<String> lista = new LinkedList<String>();
    	lista.inser_orden("daniel");
    	lista.inser_orden("zanahoria");
    	lista.inser_orden("cristal");
    	lista.inser_orden("aristal");
    	lista.inser_orden("abdias");
    	
    	System.out.println(lista.remove_n(1));
    	
    	
    	lista.mostrar();
	     
    }
}