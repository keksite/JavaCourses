package Task6;

public class CreateVector {
    public static void main(String[] args) {
        LinkedListVector linkedListVector1 = new LinkedListVector(5);
        LinkedListVector linkedListVector2 = new LinkedListVector(5);
        LinkedListVector linkedListVector3 = new LinkedListVector(5);

        WriteVectorThread writeVectorThread1 = new WriteVectorThread(linkedListVector1);
        WriteVectorThread writeVectorThread2 = new WriteVectorThread(linkedListVector2);
        WriteVectorThread writeVectorThread3 = new WriteVectorThread(linkedListVector3);
        ReadVectorThread readVectorThread1 = new ReadVectorThread(linkedListVector1);
        ReadVectorThread readVectorThread2 = new ReadVectorThread(linkedListVector2);
        ReadVectorThread readVectorThread3 = new ReadVectorThread(linkedListVector3);


        VectorSynchronizer vectorSynchronizer = new VectorSynchronizer(linkedListVector1);
        SequentalWriter writeSynchronizeVectorThread = new SequentalWriter(vectorSynchronizer);
        SequentalReader readSynchronizeVectorThread = new SequentalReader(vectorSynchronizer);

        try {
            writeVectorThread1.start();
            writeVectorThread1.join();
            readVectorThread1.start();
            writeVectorThread2.start();
            writeVectorThread2.join();
            readVectorThread2.start();
            writeVectorThread3.start();
            writeVectorThread3.join();
            readVectorThread3.start();


            new Thread(readSynchronizeVectorThread).start();
            new Thread(writeSynchronizeVectorThread).start();

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }

}
