package Task6;

import java.util.Iterator;

public class SynchronizedVector implements Vector, Iterable {
    private Vector vector;

    SynchronizedVector(Vector vector) {
        this.vector = vector;
    }

    public synchronized int getSize() {
        return this.vector.getSize();
    }

    public synchronized double getNorm() {
        return this.vector.getNorm();
    }

    public synchronized double getElement(int index) {
        return this.vector.getElement(index);
    }

    public synchronized void setElement(int index, double element) {
        this.setElement(index, element);

    }

    public synchronized Iterator iterator() {
        return this.iterator();
    }
}
