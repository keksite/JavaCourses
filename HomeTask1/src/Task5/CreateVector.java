package Task5;

public class CreateVector {
    public static void main(String[] args) {

        try {
            LinkedListVector linkedListVector = new LinkedListVector(5);
            ArrayVector arrayVector = new ArrayVector(5);

            //overrided toString() method
            System.out.println(linkedListVector.toString());
            System.out.println(arrayVector.toString());

            //clone vectors
            LinkedListVector linkedListVector1 = (LinkedListVector) linkedListVector.clone();
            ArrayVector arrayVector1 = (ArrayVector) arrayVector.clone();

            //Check if equals of two vectors
            System.out.println(linkedListVector.equals(linkedListVector1));
            System.out.println(arrayVector.equals(arrayVector1));

            //Receiving hashcode() of vectors
            System.out.println(linkedListVector.hashCode());
            System.out.println(arrayVector.hashCode());

            //wrapping vectors into unmodifieble object and check that we cannt modify that vector using method setElement

            try {
                Vector arrayVector2 = Vectors.unmodifiableVector(arrayVector);
                System.out.println(arrayVector2.getElement(2));
                arrayVector2.setElement(2, 4.0656);

            } catch (UnsupportedOperationException ex) {
                ex.printStackTrace();
            }

            try {
                Vector linkedListVector2 = Vectors.unmodifiableVector(linkedListVector);
                System.out.println(linkedListVector2.getElement(2));
                linkedListVector2.setElement(2, 2.9012740);
            } catch (UnsupportedOperationException ex) {
                ex.printStackTrace();
            }
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace();
        }


    }

}
