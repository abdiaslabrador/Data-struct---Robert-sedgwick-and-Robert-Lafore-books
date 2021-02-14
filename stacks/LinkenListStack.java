package javaapplication1;

public class Stack<Item> implements Iterable<Item>{
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
    
    public boolean isEmpty(){ return first == null;}
    public int size(){return N;}

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private Node node;

        public ReverseArrayIterator() {
            node = first;
        }

        public boolean hasNext() {
            return !isEmpty();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) return null;
            Node temp = node;
            node.value = node.next;
            return temp.item;
        }
    }
}
