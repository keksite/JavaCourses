package Task5;

import java.util.Iterator;

public interface Vector {

    int getSize();

    double getNorm();

    double getElement(int index);

    void setElement(int index, double element);

    Iterator iterator();
}
