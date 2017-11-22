package Task6;

import java.util.Iterator;

public class WriteVectorThread extends Thread implements Vector {
    Vector vector;

    WriteVectorThread(Vector vector) {
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
        for (int i = 0; i < this.getSize(); i++) {
            double element = Math.random() * 100;
            this.setElement(i, element);
            System.out.println(this.getName() + "Write: " + element + " to position " + i + ".");
        }
    }
}
