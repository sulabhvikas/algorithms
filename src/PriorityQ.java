import java.util.NoSuchElementException;

public class PriorityQ {

    private int maxSize;
    private int[] queArray;
    private int nItems;
    
    public PriorityQ(int s) { // constructor
        maxSize = s;
        queArray = new int[maxSize];
        nItems = 0;
    }
    
    public void insert(int item) { // insert item
        
        int j;
        if (nItems == 0) // if no items,
        queArray[nItems++] = item; // insert at 0
        else // if any items,
        {
        for (j = nItems-1; j >= 0; j--) // start at end,
        {
        if (item > queArray[j]) // if new item larger,
        queArray[j+1] = queArray[j]; // shift upward
        else // if smaller,
        break; // done shifting
        } // end for
        queArray[j+1] = item; // insert it
        nItems++;
        } // end else (nItems > 0)
    } // end insert()
    
    //-------------------------------------------------------------
    public int remove() { // remove minimum item
        if (nItems == 0) throw new NoSuchElementException();
     return queArray[--nItems]; 
    }
    
    //-------------------------------------------------------------
    public int peekMin() { // peek at minimum item
     return queArray[nItems-1]; 
    }
    
    //-------------------------------------------------------------
    public boolean isEmpty() { // true if queue is empty
     return (nItems == 0); 
    }
    
    //-------------------------------------------------------------
    public boolean isFull() { // true if queue is full
     return (nItems == maxSize); 
    }
    
} // end class PriorityQ


