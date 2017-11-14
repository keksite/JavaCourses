package Task3;

import java.io.*;

public class CreateVector {
    public static void main(String[] args) {
        LinkedListVector linkedListVector = new LinkedListVector(2);
        linkedListVector.getAllElements();
        Vectors.mult(linkedListVector, 4);
        linkedListVector.getAllElements();


        /**
         * Write and read Vector object from file
         */
        try {
            Vectors.outputVector(linkedListVector, new FileOutputStream("data.txt"));
            ArrayVector arrayVector = (ArrayVector) Vectors.inputVector(new FileInputStream("data.txt"));
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        /**
         * Create new LinkeListVector through console and output vector values on the console.
         */
        LinkedListVector linkedListVector2 = (LinkedListVector) Vectors.readVector(new InputStreamReader(System.in));
        Vectors.writeVector(linkedListVector2, new OutputStreamWriter(System.out));

        /**
         * Serializing LinkedListVector object
         */
        ObjectOutputStream out;
        ObjectInputStream in;
        LinkedListVector listVector = null;
        try {

            out = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream("data.txt")));
            out.writeObject(linkedListVector);
            out.close();
            in = new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream("data.txt")));
            listVector = (LinkedListVector) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (listVector != null) {
            listVector.getAllElements();
        }


    }

    /**
     * Creating ArrayVector through console.
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
