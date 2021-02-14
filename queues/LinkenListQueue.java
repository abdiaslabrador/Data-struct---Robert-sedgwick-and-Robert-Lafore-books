import java.util.Iterator;

public class LinkedListQueue<Item> implements Iterable {
    private Node head; // link to least recently added node
    private Node rear; // link to most recently added node
    private int N;

    // number of items on the queue
    private class Node
    {
        private Item item;
        private Node next;

        public Node(Item item){
            this.item = item;
        }

    }
    
    public boolean isEmpty() {return head == null;}
    public int size(){return N;}
    public Item seeFirst() {return head.item;}
    public Item seeRear() {return rear.item;}
    // Or: N == 0.
    public void enqueue(Item item)
    { // Add item to the end of the list.
        Node oldlast = rear;
        rear = new Node(item);
        rear.next = null;
        if (isEmpty()) head = rear;
        else
        oldlast.next = rear;
        N++;
    }
    public Item dequeue()
    { // Remove item from the beginning of the list.
        Item item = head.item;
        head = head.next;
        if (isEmpty()) rear = null;
        N--;
        return item;
    }
    public Iterator<Item> iterator(){ return new ListIterator(); }
    private class ListIterator implements Iterator<Item>
    {
        private Node current = head;
        public boolean hasNext(){ return current != null;}
        public void remove() { }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
}