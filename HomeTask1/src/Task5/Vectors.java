package Task5;


import java.io.*;

public class Vectors {

    private static VectorFactory factory;

    public static VectorFactory setVectorFactory() {
        return factory = new ArrayVectorFactory();

    }

    public static Vector createInstance(int size) {
        return setVectorFactory().createInstance(size);
    }

    /**
     * метод умножает каждое число массива
     *
     * @param vector     обьект вектор в который входит массив @see ArrayVector.class
     * @param multiplier умножитель
     */
    public static void mult(Vector vector, int multiplier) {
        Vector res = createInstance(vector.getSize());
        for (int i = 0; i < vector.getSize(); i++) {
            res.setElement(i, vector.getElement(i) * multiplier);
        }
    }

    /**
     * сумма двух элементов вектора
     *
     * @param vector      обьект, который хранит массив
     * @param firstIndex  первый элемент массива
     * @param secondIndex второй элемент массива
     */
    public static Vector sum(Vector firstVector, Vector secondVector) {
        Vector sumVector = createInstance(firstVector.getSize());

        if (firstVector.getSize() == secondVector.getSize()) {
            for (int i = 0; i < firstVector.getSize(); i++) {
                sumVector.setElement(i, firstVector.getElement(i) + secondVector.getElement(i));
            }
            return sumVector;
        } else {
            return null;
        }

    }

    /**
     * Скаярая велечина между двумя векторами
     *
     * @param firstArrayVector  первый массив
     * @param secondArrayVector второй массив
     */
    public static Vector scalarMult(Vector firstArrayVector, Vector secondArrayVector) {
        Vector scalarVector = createInstance(firstArrayVector.getSize());

        if (firstArrayVector.getSize() == secondArrayVector.getSize()) {
            for (int i = 0; i < firstArrayVector.getSize(); i++) {
                scalarVector.setElement(i, firstArrayVector.getElement(i) * secondArrayVector.getElement(i));
            }
            return scalarVector;
        } else {
            return null;
        }

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
        Vector res;
        DataInputStream dataInputStream = new DataInputStream(in);
        try {
            int size = dataInputStream.read();
            res = createInstance(size);
            for (int i = 0; i < size; i++) {
                res.setElement(i, dataInputStream.readDouble());
            }

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return res;
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
        Vector res;

        StreamTokenizer str = new StreamTokenizer(in);
        try {
            str.nextToken();
            int size = (int) str.nval;
            res = createInstance(size);
            for (int i = 0; i < size; i++) {
                str.nextToken();
                res.setElement(i, str.nval);
            }
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public static Vector unmodifiableVector(Vector vector) {
        return new VectorDecorator(vector);
    }

}
