import java.util.Iterator;

public class LinkedListStack<Item> implements Iterable<Item>{
    private Node first;
    private int N;
    

    private class Node
    {
        protected Item item;
        protected Node next;

        public Node(Item item){
            this.item = item;
        }
    }

    public void push(Item item)
    {
        Node newdNode = new Node(item);
        newdNode.next=first;
        first=newdNode;
        N++;
    }
    
    //integer sirve como int pero podemos retornar null
    public Item pop()
    {   if(!isEmpty())
        {
            Node oldNode = first;
            first=first.next;
            N--;
            return oldNode.item;
        }
        return null;
    }
    public Item peek(){return first.item;}
    
    public boolean isEmpty(){ return first == null;}
    public int size(){return N;}

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private Node current;

        public ReverseArrayIterator() {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) return null;
            Node temp = current;
            current = current.next;
            return temp.item;
        }
    }
}
