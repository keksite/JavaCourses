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
     * @param index номер элемента в массивке
     * @return возвращает элемент по номеру
     */
    public int getElement(int index) {
        return vector[index];
    }

    public int[] getVector() {
        return vector;
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
     * @return возвращает длину вектора
     */
    public int getVectorLength() {
        return vectorLength;
    }

    /**
     * @return возвращает минимальный элемент вектора
     */
    public int getMin() {
        int indexOfMin = vector[0];
        for (int aVector : vector) {
            if (indexOfMin > aVector) {
                indexOfMin = aVector;
            }
        }
        return indexOfMin;
    }

    /**
     * @return возвращает максимальный элемент вектора
     */
    public int getMax() {
        int indexOfMax = vector[0];
        for (int aVector : vector) {
            if (indexOfMax < aVector) {
                indexOfMax = aVector;
            }
        }
        return indexOfMax;
    }

    /**
     * поиск элемента в массиве
     *
     * @param element искомый элемент
     * @return возвращает порядковый номер элемента в массиве
     */
    public int find(int element) {
        for (int i = 0; i < vector.length; i++) {
            if (element == vector[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @return возвращает среднее арифметическое массива
     */
    public int getAverage() {
        int sum = 0;
        for (int i : vector) {
            sum += i;
        }
        return sum / vector.length;
    }

    /**
     * Сортировка массива по возрастанию
     */
    public void sort() {
        for (int i = vector.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (vector[j] > vector[j + 1]) {
                    int tmp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = tmp;
                }
            }
        }
        for (int element : vector) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * @return возвращает эвклидову норму чисел в массиве
     */
    public double getNorm() {
        int norm = 0;
        for (int i : vector) {
            norm += i * i;
        }
        return  Math.sqrt(norm);
    }

    /**
     * метод умножает каждое число массива
     *
     * @param arrayVector обьект вектор в который входит массив @see ArrayVector.class
     * @param multiplier  умножитель
     */
    public static void mult(ArrayVector arrayVector, int multiplier) {

        for (int i = 0; i < arrayVector.vector.length; i++) {
            arrayVector.vector[i] = arrayVector.vector[i] * multiplier;
            System.out.print(arrayVector.vector[i] + " ");
        }
        System.out.println();
    }

    /**
     * сумма двух элементов вектора
     *
     * @param arrayVector обьект, который хранит массив
     * @param firstIndex  первый элемент массива
     * @param secondIndex второй элемент массива
     */
    public static void sum(ArrayVector arrayVector, int firstIndex, int secondIndex) {
        try {
            System.out.println(arrayVector.getElement(firstIndex) + arrayVector.getElement(secondIndex));
        } catch (ArrayIndexOutOfBoundsException e) {
            if (firstIndex + 1 > arrayVector.getVectorLength()) {
                System.out.println("первый индекс неверный");
            } else {
                System.out.println("второй индекс не верный");
            }
        }
    }

    /**
     * Скаярая велечина между двумя векторами
     *
     * @param firstArrayVector  первый массив
     * @param secondArrayVector второй массив
     */
    public static void scalarMult(ArrayVector firstArrayVector, ArrayVector secondArrayVector) {

        if (firstArrayVector.getVectorLength() == secondArrayVector.getVectorLength()) {
            int[] scalarVector = new int[firstArrayVector.getVectorLength()];
            for (int i = 0; i < firstArrayVector.getVectorLength(); i++) {
                scalarVector[i] = firstArrayVector.getElement(i) * secondArrayVector.getElement(i);
            }
            for (int scalar : scalarVector) {
                System.out.print(scalar + " ");
            }
        } else {
            System.out.println("Длины массивов не совпадают");
        }
        System.out.println();
    }
}
