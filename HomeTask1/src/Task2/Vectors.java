package Task2;

public class Vectors {
    /**
     * метод умножает каждое число массива
     *
     * @param arrayVector обьект вектор в который входит массив @see ArrayVector.class
     * @param multiplier  умножитель
     */
    public static void mult(Vector arrayVector, int multiplier) {

        for (int i = 0; i < arrayVector.getSize(); i++) {
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
    public static void sum(Vector arrayVector, int firstIndex, int secondIndex) {
        try {
            System.out.println(arrayVector.getElement(firstIndex) + arrayVector.getElement(secondIndex));
        } catch (ArrayIndexOutOfBoundsException e) {
            if (firstIndex + 1 > arrayVector.getSize()) {
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
    public static void scalarMult(Vector firstArrayVector, Vector secondArrayVector) {

        if (firstArrayVector.getSize() == secondArrayVector.getSize()) {
            double[] scalarVector = new double[firstArrayVector.getSize()];
            for (int i = 0; i < firstArrayVector.getSize(); i++) {
                scalarVector[i] = firstArrayVector.getElement(i) * secondArrayVector.getElement(i);
            }
            for (double scalar : scalarVector) {
                System.out.print(scalar + " ");
            }
        } else {
            System.out.println("Длины массивов не совпадают");
        }
        System.out.println();
    }

}
