import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackLLWithIterator<T> implements  Iterable<T> {

    private Node first = null;
    
    private class Node {
        private T item;
        private Node next;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void push(T item) {
        if (item == null) throw new NullPointerException();
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }
    
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException();
        T item = first.item;
        first = first.next;
        return item;
    }
    
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return first.item;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }
    
    private class ListIterator implements Iterator<T> {
        
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
            
        }

        @Override
        public T next() {
            if (current == null) throw new NoSuchElementException(); 
            T item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
            
        }
        
    }

}
