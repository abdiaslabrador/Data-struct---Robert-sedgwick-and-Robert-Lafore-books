package stacks;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*This code are from "Data Structures& Algorithms in Java Second Edition page 166-167"
 * but a make some changes for example: expand the array when the queue is full.
 * This queue is a circular queue whose expand the capacity when is necessary
 * */
public class ResizingArrayQueue<Item> implements Iterable<Item> {
    
	private int maxSize;
	public Item[] queArray;
	public int front;
	private int rear;
	public int front2;
    public int rear2;
	
	
    /**
     * Initializes an empty queue.
     */
	public ResizingArrayQueue(int s) // constructor
	{
		maxSize = s+1; // array is 1 cell larger
		queArray =  (Item[]) new Object[maxSize]; // than requested
		front = 0;
		rear =-1;
	}
    
	/*
	 * I show the queue information to  understand the circular queue. Is circular because is necessary
	 * use the space that are null
	 * */
	public void showMe()
    {
		System.out.println("MaxSize:" + maxSize + " Front:" + front + " Rear:" + rear);
		
		int w = 0;
		String f = "", r = "";
		for(int i = 0; i < queArray.length; i++) 
				System.out.print(i+1  + " - " );
		System.out.println();

		for(Item i : queArray){
			if(w== front)f="F";
			else f="";
			
			if(w== rear)r="R";
			else r="";
			
            System.out.print( w+f+r+i  + " - " );
            w++;
        }
		System.out.println();
		
		Iterator t = iterator();
		while(t.hasNext())
		{	
			System.out.print(t.next() + " - ");
			
		}
		System.out.println();
    }
	  
    public void insert(Item j) // put item at rear of queue
    {
    	if (isFull())resize(2 * queArray.length, "Expand");
	    if(rear == maxSize-1)
	    	rear = -1;
	    queArray[++rear] = j;
    }

    public Item remove() // take item from front of queue
    {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item temp = queArray[front];
        queArray[front]=null;
        front++;
        if(front == maxSize) front = 0;
        if (size() > 0 && size() == queArray.length/4) resize(queArray.length/2, "Minimize");
        return temp;
    }
    
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return queArray[front];
    }
    
    public int size() // (assumes queue not empty)
    {
        if(rear >= front) // contiguous sequence
            return rear-front+1;
        else // broken sequence
            return (maxSize-front) + (rear+1);
    }

    public boolean isEmpty() // true if queue is empty
	{
		return ( rear+1==front || (front+maxSize-1==rear) );
	}

    public boolean isFull() // true if queue is full
    {
    	return ( rear+2==front || (front+maxSize-2==rear) );
    }

    private void resize(int capacity, String EorM) {
    	/*Depends of the situation i put the rear at the last of the new array size.
         * The case is different if the queue is full and insert a item: we need to expand the array and re-order
         * the array. After put the front=0 and rear at (queArray.length/2)-2. 
         * But if removing an item and the queue is less than queArray.length/4: we minimize the array and 
         * put the front=0 and the rear=rear = (queArray.length/2)-1.
         * The RorI is a variable that indicate either the action to realize is "expand" or "minimize".
         * */
    	
        assert capacity >= maxSize;
        int i =0;
        
        Item[] copy = (Item[]) new Object[capacity];
        
        for (Iterator iterator = iterator(); iterator.hasNext();) {
			copy[i] = (Item) iterator.next();
			i++;
		}
        queArray = copy;
        front =0;
        
        if (EorM == "Expand")
        	rear = (queArray.length/2)-2;
        else if (EorM == "Minimize")
        	rear = (queArray.length/2)-1;
        maxSize = queArray.length;
    }
    
    
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ArrayIterator implements Iterator<Item> {

        private int i;
        
        public ArrayIterator() {
            front2 = front;
            rear2 = rear;            
        }

        public boolean hasNext() {
            return !isEmpty2();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
        
        public Item next() {
        	
            //if (!hasNext()) throw new NoSuchElementException();
        	if (isEmpty()) throw new NoSuchElementException("Queue underflow");
            Item temp = queArray[front2];
            front2++;
            if(front2 == maxSize) front2 = 0;
            return temp;
        }
        
        /*The isEmpty2 and isFull2 function are a copy of the other function to do a for throughout
         * the queue and don't affect the position of front and rear  
         * */
        public boolean isEmpty2() // true if queue is empty
    	{
    		return ( rear2+1==front2 || (front2+maxSize-1==rear2) );
    	}    
    	public boolean isFull2() // true if queue is full
        {
        	return ( rear2+2==front2 || (front2+maxSize-2==rear2) );
        }
    }
    
}
