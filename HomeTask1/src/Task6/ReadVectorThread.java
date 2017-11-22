package Task6;

import java.util.Iterator;

public class ReadVectorThread extends Thread implements Vector {
    Vector vector;

    ReadVectorThread(Vector vector) {
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
        vector.setElement(index, element);

    }

    public Iterator iterator() {
        return vector.iterator();
    }

    @Override
    public void run() {
        for (int i = 0; i < this.vector.getSize(); i++) {
            System.out.println(this.getName() + "Read: " + this.vector.getElement(i) + " from position " + i);
        }
    }
}
