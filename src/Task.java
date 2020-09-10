import java.util.concurrent.*;

public class Task {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<Integer> t1t2 = new LinkedTransferQueue<>();
        TransferQueue<Integer> t2t3 = new LinkedTransferQueue<>();
        TransferQueue<Integer> t3t1 = new LinkedTransferQueue<>();
        t1t2.put(0);
        new Thread(new Increment(t3t1, t1t2)).start();
        new Thread(new Increment(t1t2, t2t3)).start();
        new Thread(new Increment(t2t3, t3t1)).start();

    }
}
