package javaapplication1;

public class LinkenListStack<Item> implements Iterable<Item>{
    private Nodo first;
    private int N;
    

    private class Node()
    {
        private Item value;
        private Node next;

        public Node(Item item){
            value = item;
        }
    
        public Item get_value(){return value}

        public set_value(Item item){value = item}

        public String toString() {return String.format(value);} 
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
            return oldNode.value;
        }
        return null;
    }
    public Item peek(){return first.value}
    
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
            current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) return null;
            Node temp = current;
            current.value = current.next;
            return temp.value;
        }
    }
}