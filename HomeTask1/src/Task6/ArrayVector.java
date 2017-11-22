package Task6;


import java.io.Serializable;
import java.util.Iterator;

public class ArrayVector implements Vector, Serializable, Cloneable {
    private int size;
    private double[] vector;

    /**
     * конструктор которому передается длина массива, которая присваивается массиву;
     *
     * @param size длина массива
     */
    public ArrayVector(int size) throws NegativeArraySizeException {
        this.size = size;
        this.vector = new double[size];
        for (int i = 0; i < size; i++) {
            this.vector[i] = 0;

        }

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ArrayVector{size=").append(size).append(",").append(" ").append("elements: ");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                builder.append(getElement(i));
            } else {
                builder.append(getElement(i)).append(", ");
            }
        }
        builder.append("}");
        return builder.toString();
    }

    /**
     * @return возвращает длину вектора
     */
    public int getSize() {
        return size;
    }

    /**
     * @param index номер элемента в массивке
     * @return возвращает элемент по номеру
     */
    public double getElement(int index) {
        return vector[index];
    }

    /**
     * устанавливает новый элемент
     *
     * @param index   порядковый номер в массиве
     * @param element новый элемент массива
     */
    public void setElement(int index, double element) {
        if (index < vector.length) {
            vector[index] = element;
        } else {
            System.out.println("Индекс больше, чем размер вектора");
        }
    }

    public Iterator iterator() {
        return new ArrayVectorIterator(this);
    }

    /**
     * @return возвращает эвклидову норму чисел в массиве
     */
    public double getNorm() {
        double norm = 0;
        for (double i : vector) {
            norm += i * i;
        }
        return Math.sqrt(norm);
    }

    public void deleteElement(int index) {
        for (int i = index; i < vector.length - 1; i++) {
            vector[i] = vector[i + 1];
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return false;
        if (!(o instanceof ArrayVector)) return false;
        ArrayVector that = (ArrayVector) o;
        return getSize() == that.getSize() && that.vector == this.vector;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int hashCode() {
        int result = 0;
        long t;
        for (double aVector : this.vector) {
            t = Double.doubleToLongBits(aVector);
            result ^= (((int) (t >> 32)) ^ (int) (t));
        }
        return result;
    }

}
