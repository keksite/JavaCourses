import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreateVector {
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
            System.out.println("Умножение элементов массива на число: ");ArrayVector.mult(arrayVector, 3);
            System.out.print("Cумма двух элементов массива: ");ArrayVector.sum(arrayVector.getVector(), -1, -1);
            System.out.println("Cкалярная длина вектора: ");ArrayVector.scalarMult(arrayVector.getVector(), secondArrayVector);
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
