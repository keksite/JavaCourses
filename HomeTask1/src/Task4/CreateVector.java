package Task4;

import java.util.Iterator;

public class CreateVector {
    public static void main(String[] args) {
        //iterate through linkedListVector
        Vector linkedListVector = new LinkedListVector(5);
        Iterator vectorIterator = linkedListVector.iterator();

        while (vectorIterator.hasNext()) {
            System.out.print(vectorIterator.next() + " ");
        }
        System.out.println();

        //iterate through ArrayVector
        ArrayVector arrayVector = new ArrayVector(5);
        Iterator arrayVectorIterator = arrayVector.iterator();

        while (arrayVectorIterator.hasNext()) {
            System.out.print(arrayVectorIterator.next() + " ");
        }
    }

}
