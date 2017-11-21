package Task4;

import java.util.Iterator;


public class LinkedListVectorIterator implements Iterator {
    private LinkedListVector.Node current;
    private LinkedListVector.Node head;


    public LinkedListVectorIterator(LinkedListVector v) {
        head = v.getHead();
        current = head;
    }

    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();

    }

    public boolean hasNext() {
        return current.next != head;
    }

    public Object next() {
        if (hasNext()) {
            current = current.next;
        }
        return current.value;
    }
}
