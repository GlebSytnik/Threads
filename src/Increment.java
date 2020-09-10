import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Increment implements Runnable {


    TransferQueue<Integer> reseption = new LinkedTransferQueue<Integer>();
    TransferQueue<Integer> output = new LinkedTransferQueue<Integer>();


    Increment(TransferQueue<Integer> reseption, TransferQueue<Integer> output) {
        this.reseption = reseption;
        this.output = output;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer increment = reseption.take();
                System.out.println(Thread.currentThread().getName() + " took " + increment);
                if (increment == 100) {
                    break;
                } else {
                    output.put(increment + 1);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}