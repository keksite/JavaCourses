package Task2;

public class Vectors {
    /**
     * метод умножает каждое число массива
     *
     * @param arrayVector обьект вектор в который входит массив @see ArrayVector.class
     * @param multiplier  умножитель
     */
    public static void mult(ArrayVector arrayVector, int multiplier) {

        for (int i = 0; i < arrayVector.getVectorLength(); i++) {
            arrayVector.setElement(i, arrayVector.getElement(i) * multiplier) ;
            System.out.print(arrayVector.getElement(i) + " ");
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
