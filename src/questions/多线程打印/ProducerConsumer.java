package questions.多线程打印;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    private static final BlockingQueue<Integer> queue
            = new ArrayBlockingQueue<>(1000);
    ;

    public static void main(String[] args) {
        new Thread(() -> {
            //生产者
            for (int i = 0; i < 1000; i++) {
                try {
                    synchronized (queue) {
                        queue.put(i);
                        System.out.println("生产者生产了" + i);
                    }
                    for (int j = 0; j < 1000; j++){}

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(() -> {
            //消费者
            for (int i = 0; i < 1000; i++) {
                try {
                    synchronized (queue) {
                        if(!queue.isEmpty())
                            System.out.println("消费者消费了" + queue.take());
                        else System.out.println("消费者拿不到东西，直接返回");
                    }
                    for (int j = 0; j < 1000; j++){}
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }
}