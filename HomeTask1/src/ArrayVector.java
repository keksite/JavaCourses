import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayVector {
    private int vectorLength;
    private int[] vector;

    public ArrayVector(int vectorLength) {
        this.vectorLength = vectorLength;
        vector = new int[vectorLength];
    }

    public int getElement(int element) {
        return vector[element];
    }

    public void setElement(int index, int element) {
        vector[index] = element;
    }

    public int getVectorLength() {
        return vectorLength;
    }

    public int getMin() {
        int indexOfMin = vector[0];
        for (int aVector : vector) {
            if (indexOfMin > aVector) {
                indexOfMin = aVector;
            }
        }
        return indexOfMin;
    }

    public int getMax() {
        int indexOfMax = vector[0];
        for (int aVector : vector) {
            if (indexOfMax < aVector) {
                indexOfMax = aVector;
            }
        }
        return indexOfMax;
    }

    public int find(int element) {
        int elementId = -1;
        for (int i = 0; i < vector.length; i++) {
            if (element == vector[i]) {
                elementId = i;
            } else {
                elementId = 0;
            }
        }
        return elementId;
    }

    public int getAverage() {
        int sum = 0;
        for (int i : vector
                ) {
            sum += i;
        }
        return sum / vector.length;
    }

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

    public Double getNorm() {
        Double norm = 0d;
        for (int i : vector
                ) {
            norm += i * i;

        }
        return Math.sqrt(norm);
    }

    public static void mult(ArrayVector arrayVector, int multiplier) {

        for (int i = 0; i < arrayVector.vector.length; i++) {
            arrayVector.vector[i] = arrayVector.vector[i] * multiplier;
            System.out.print(arrayVector.vector[i] + " ");
        }
        System.out.println();


    }

    public static void sum(ArrayVector arrayVector, int firstIndex, int secondIndex) {
        try {
            System.out.println(arrayVector.vector[firstIndex] + arrayVector.vector[secondIndex]);
        } catch (ArrayIndexOutOfBoundsException e) {
            if (firstIndex + 1 > arrayVector.vector.length) {
                System.out.println("первый индекс неверный");
            } else {
                System.out.println("второй индекс не верный");
            }
        }
    }

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
        System.out.println();
    }


    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            ArrayVector arrayVector = new ArrayVector(Integer.parseInt(reader.readLine()));

            for (int i = 0; i < arrayVector.getVectorLength(); i++) {
                arrayVector.setElement(i, Integer.parseInt(reader.readLine()));
            }
            int[] secondArrayVector = {4, 5, 2, 6, 1};
            arrayVector.setElement(3, 10);
            System.out.println(arrayVector.getElement(1));
            System.out.println(arrayVector.find(1));
            System.out.println(arrayVector.getAverage());

            System.out.println(arrayVector.getMax());
            System.out.println(arrayVector.getMin());
            arrayVector.sort();
            System.out.println(arrayVector.getNorm());
            mult(arrayVector, 3);
            sum(arrayVector, -1, -1);
            scalarMult(arrayVector.vector, secondArrayVector);
        } catch (IOException e) {
            System.out.println("Это не число");
        }


    }
}
