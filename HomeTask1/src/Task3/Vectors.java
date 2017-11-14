package Task3;


import java.io.*;

public class Vectors {
    /**
     * метод умножает каждое число массива
     *
     * @param arrayVector обьект вектор в который входит массив @see ArrayVector.class
     * @param multiplier  умножитель
     */
    public static void mult(Vector arrayVector, int multiplier) {
        for (int i = 0; i < arrayVector.getSize(); i++) {
            arrayVector.setElement(i, arrayVector.getElement(i) * multiplier);
        }
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

    /**
     * @param v
     * @param out
     */
    public static void outputVector(Vector v, OutputStream out) {
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        try {
            dataOutputStream.write(v.getSize());
            for (int i = 0; i < v.getSize(); i++) dataOutputStream.writeDouble(v.getElement(i));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param in
     * @return
     */
    public static Vector inputVector(InputStream in) {
        Vector vector;
        DataInputStream dataInputStream = new DataInputStream(in);
        try {
            int size = dataInputStream.read();
            vector = new ArrayVector(size);
            for (int i = 0; i < size; i++) {
                vector.setElement(i, dataInputStream.readDouble());
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return vector;
    }

    /**
     * @param v
     * @param out
     */
    public static void writeVector(Vector v, Writer out) {
        PrintWriter pw = new PrintWriter(out);
        pw.printf("%d ", v.getSize());
        for (int i = 0; i < v.getSize(); i++) {
            pw.printf("%g ", v.getElement(i));
        }
        pw.close();

    }

    /**
     * @param in
     * @return
     */
    public static Vector readVector(Reader in) {
        Vector vector;

        StreamTokenizer str = new StreamTokenizer(in);
        try {
            str.nextToken();
            int size = (int) str.nval;
            vector = new LinkedListVector(size);
            for (int i = 0; i < size; i++) {
                str.nextToken();
                vector.setElement(i, str.nval);
            }
            return vector;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
