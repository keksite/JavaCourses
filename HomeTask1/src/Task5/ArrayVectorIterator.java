package Task5;

import java.util.Iterator;

public class ArrayVectorIterator implements Iterator {
    private ArrayVector aggregate = null;
    private int current = -1;
    private int length;

    public ArrayVectorIterator(ArrayVector v) {
        aggregate = v;
        length = v.getSize();
    }

    public void remove() {
        aggregate.deleteElement(current);
    }

    public boolean hasNext() {
        return this.current < length - 1;
    }

    public Object next() {
        if (hasNext()) {
            this.current++;
        }
        return aggregate.getElement(this.current);
    }
}
