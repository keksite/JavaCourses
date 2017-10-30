package Task2;


public class ArrayVector implements Vector {
    private int vectorLength;
    private double[] vector;

    /**
     * конструктор которому передается длина массива, которая присваивается массиву;
     *
     * @param vectorLength длина массива
     */
    public ArrayVector(int vectorLength) {
        this.vectorLength = vectorLength;
        vector = new double[vectorLength];
    }

    /**
     * @return возвращает длину вектора
     */
    public int getSize() {
        return vectorLength;
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
}
