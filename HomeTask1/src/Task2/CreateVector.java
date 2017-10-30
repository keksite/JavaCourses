package Task2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreateVector {
    public static void main(String[] args) {
        LinkedListVector linkedListVector = new LinkedListVector(5);
        linkedListVector.getElement(0);
        linkedListVector.getAllElements();
        linkedListVector.addElement(Math.random() * 100);
        linkedListVector.getAllElements();
        /*System.out.println("Введите значение первого массива:");
        ArrayVector arrayVector = createVector();
        System.out.println("Введите значение второго массива:");
        ArrayVector arrayVector2 = createVector();
        System.out.println("замена элемента: ");
        arrayVector.setElement(1, 10);
        System.out.println("Получем элемент по индексу: " + arrayVector.getElement(1));
        System.out.println("Евклидова норма: " + arrayVector.getNorm());
        System.out.println("Умножение элементов массива на число: ");
        Vectors.mult(arrayVector, 3);
        System.out.print("Cумма двух элементов массива: ");
        Vectors.sum(arrayVector, -1, -1);
        System.out.println("Cкалярная длина вектора: ");
        Vectors.scalarMult(arrayVector, arrayVector2);*/

    }

    /**
     * Создание вектора
     *
     * @return возвращает обьект ArrayVector
     */
    public static ArrayVector createVector() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Установите длину массива:");
            ArrayVector arrayVector = new ArrayVector(Integer.parseInt(reader.readLine()));

            System.out.println("Добавьте элементы в массив:");
            for (int i = 0; i < arrayVector.getSize(); i++) {
                arrayVector.setElement(i, Integer.parseInt(reader.readLine()));
            }
            return arrayVector;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
