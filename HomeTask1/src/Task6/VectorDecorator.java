package Task6;

import java.util.Iterator;

public class VectorDecorator implements Vector {
    private Vector vector;

    VectorDecorator(Vector vector) {
        this.vector = vector;
    }

    public int getSize() {
        return vector.getSize();
    }

    public double getNorm() {
        return vector.getNorm();
    }

    public double getElement(int index) {
        return vector.getElement(index);
    }

    public void setElement(int index, double element) {
        throw new UnsupportedOperationException();
    }

    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }
}
