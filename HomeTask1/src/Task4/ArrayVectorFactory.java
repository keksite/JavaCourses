package Task4;

public class ArrayVectorFactory implements VectorFactory {
    public Vector createInstance(int size) {
        return new ArrayVector(size);
    }
}
