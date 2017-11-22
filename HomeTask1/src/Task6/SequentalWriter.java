package Task6;

public class SequentalWriter implements Runnable {
    VectorSynchronizer vectorSynchronizer;

    SequentalWriter(VectorSynchronizer vectorSynchronizer) {
        this.vectorSynchronizer = vectorSynchronizer;
    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted())
                vectorSynchronizer.write(Math.random() * 100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
