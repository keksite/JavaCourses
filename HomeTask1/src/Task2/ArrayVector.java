package Task2;

public class ArrayVector {
    private int vectorLength;
    private int[] vector;

    /**
     * конструктор которому передается длина массива, которая присваивается массиву;
     *
     * @param vectorLength длина массива
     */
    public ArrayVector(int vectorLength) {
        this.vectorLength = vectorLength;
        vector = new int[vectorLength];
    }

    /**
     * @return возвращает длину вектора
     */
    public int getVectorLength() {
        return vectorLength;
    }

    /**
     * @param index номер элемента в массивке
     * @return возвращает элемент по номеру
     */
    public int getElement(int index) {
        return vector[index];
    }

    /**
     * устанавливает новый элемент
     *
     * @param index   порядковый номер в массиве
     * @param element новый элемент массива
     */
    public String setElement(int index, int element) {
        if (index < vector.length) {
            vector[index] = element;
            return element + " установлен " + " на позицию " + (index + 1);
        } else {
            return "Индекс больше, чем размер вектора";
        }
    }

    /**
     * @return возвращает эвклидову норму чисел в массиве
     */
    public double getNorm() {
        int norm = 0;
        for (int i : vector) {
            norm += i * i;
        }
        return Math.sqrt(norm);
    }
}
