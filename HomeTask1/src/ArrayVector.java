import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayVector {
    private int vectorLength;
    private int[] vector;

    /**
     * конструктор которому передается длина массива, которая присваивается массиву;
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

    /**
     * устанавливает новый элемент
     * @param index порядковый номер в массиве
     * @param element новый элемент массива
     */
    public String setElement(int index, int element) {
        if(index<vector.length) {
            vector[index] = element;
            return element + " установлен " + " на позицию " + (index +1);
        }
        else{
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
     * @param element искомый элемент
     * @return возвращает порядковый номер элемента в массиве
     */
    public int find(int element) {
        int elementId = -1;
        for (int i = 0; i < vector.length; i++) {
            if (element == vector[i]) {
                elementId = i;
            } else {
                elementId = -1;
            }
        }
        return elementId;
    }

    /**
     * @return возвращает среднее арифметическое массива
     */
    public int getAverage() {
        int sum = 0;
        for (int i : vector
                ) {
            sum += i;
        }
        return sum / vector.length;
    }

    /**
     *Сортировка массива по возрастанию
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
        for (int element : vector
                ) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * @return возвращает эвклидову норму чискел в массиве
     */
    public Double getNorm() {
        Double norm = 0d;
        for (int i : vector
                ) {
            norm += i * i;
        }
        return Math.sqrt(norm);
    }

    /**
     * метод умножает каждое число массива
     * @param arrayVector обьект вектор в который входит массив @see ArrayVector.class
     * @param multiplier умножитель
     */
    public static void mult(ArrayVector arrayVector, int multiplier) {

        for (int i = 0; i < arrayVector.vector.length; i++) {
            arrayVector.vector[i] = arrayVector.vector[i] * multiplier;
            System.out.print(arrayVector.vector[i] + " ");
        }
        System.out.println();
    }

    /**
     * сумма двух элементов массива
     * @param arrayVector обьект, который хранит массив
     * @param firstIndex первый элемент массива
     * @param secondIndex второй элемент массива
     */
    public static void sum(int[] arrayVector, int firstIndex, int secondIndex) {
        try {
            System.out.println(arrayVector[firstIndex] + arrayVector[secondIndex]);
        } catch (ArrayIndexOutOfBoundsException e) {
            if (firstIndex + 1 > arrayVector.length) {
                System.out.println("первый индекс неверный");
            } else {
                System.out.println("второй индекс не верный");
            }
        }
    }

    /**
     * Скаярая велечина между двумя массивами
     * @param firstArrayVector первый массив
     * @param secondArrayVector второй массив
     */
    public static void scalarMult(int[] firstArrayVector, int[] secondArrayVector) {
        if (firstArrayVector.length == secondArrayVector.length) {
            int[] scalarVector = new int[firstArrayVector.length];
            for (int i = 0; i < firstArrayVector.length; i++) {
                scalarVector[i] = firstArrayVector[i] * secondArrayVector[i];
            }
            for (int scalar : scalarVector
                    ) {
                System.out.print(scalar + " ");
            }
        }
        else{
            System.out.println("Длины массивов не совпадают");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        try {
            ArrayVector arrayVector = createVector();
            int[] secondArrayVector = {4, 5, 2, 6, 1};
            //
            System.out.println("замена элемента: "); System.out.println(arrayVector.setElement(1, 10));

            System.out.println("Получем элемент по индексу: " + arrayVector.getElement(1));
            System.out.println("Поиск индекса элемента: " + arrayVector.find(1));
            System.out.println("Среднее арифметическое всех элементов: " +arrayVector.getAverage());

            System.out.println("Максимальный элемент массива: " + arrayVector.getMax());
            System.out.println("Минимальный элемент массива: " + arrayVector.getMin());
            System.out.println("Сортируем массив: ");arrayVector.sort();
            System.out.println("Евклидова норма: " + arrayVector.getNorm());
            System.out.println("Умножение элементов массива на число: ");mult(arrayVector, 3);
            System.out.print("Cумма двух элементов массива: ");sum(arrayVector.vector, -1, -1);
            System.out.println("Cкалярная длина вектора: ");scalarMult(arrayVector.vector, secondArrayVector);
        }
        catch (Exception e){
            System.out.println("Что-то пошло не так");
        }
    }

    /**
     * Создание вектора
     * @return возвращает обьект ArrayVector
     */
    public static ArrayVector createVector() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayVector arrayVector = null;
        try {
            arrayVector = new ArrayVector(Integer.parseInt(reader.readLine()));

            for (int i = 0; i < arrayVector.getVectorLength(); i++) {
                arrayVector.setElement(i, Integer.parseInt(reader.readLine()));
            }
            return arrayVector;

        } catch (Exception e) {
            System.out.println("Это не число");
            return null;
        }


    }
}
