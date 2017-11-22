package Task6;

public class SequentalReader implements Runnable {
    VectorSynchronizer vectorSynchronizer;

    SequentalReader(VectorSynchronizer vectorSynchronizer) {
        this.vectorSynchronizer = vectorSynchronizer;

    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                vectorSynchronizer.read();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
