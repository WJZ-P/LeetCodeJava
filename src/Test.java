import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
//    static class Producer implements Runnable {
//        private List<UUID> list;
//        private int maxLength;
//
//        public Producer(List list, int maxLength) {
//            this.list = list;
//            this.maxLength = maxLength;
//        }
//        @Override
//        public void run() {
//            while (true) {
//                synchronized (list) {
//                    while (list.size() == maxLength) {
//                        try {
//                            System.out.println("队列已满，等待");
//                            list.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                    //说明列表还没满
//                    UUID uuid = UUID.randomUUID();
//
//                    System.out.println("生产一个UUID！-" + uuid + ":" + list.size());
//                    list.add(uuid);
//                    list.notifyAll();
//                }
//            }
//        }
//    }
//
//    static class Consumer implements Runnable {
//        private List<UUID> list;
//
//        public Consumer(List list) {
//            this.list = list;
//        }
//
//        @Override
//        public void run() {
//            while (true) {
//                synchronized (list) {
//                    while (list.isEmpty()) {
//                        try {
//                            list.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                    //不为空，可以消费辣
//                    System.out.println("消费者消费UUID-" + list.remove(0));
//                    list.notifyAll();
//                }
//            }
//        }
//    }

//    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList<>();
//        ExecutorService service = new ThreadPoolExecutor(15, 20, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
//        for (int i = 0; i < 5; i++) {
//            service.submit(new Producer(linkedList, 10));
//        }
//        for (int i = 0; i < 10; i++) {
//            service.submit(new Consumer(linkedList));
//        }
//    }

    //用Condition实现生产者消费者
    static ReentrantLock lock = new ReentrantLock();
    static Condition producerCondition = lock.newCondition();
    static Condition consumerCondition = lock.newCondition();
    static int maxSize = 10;
    static LinkedList<UUID> list = new LinkedList();

    static class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();//先获得锁，因为要操作list
                try {
                    while (list.size() == maxSize) {
                        System.out.println("队列数量满，生产者等待");
                        producerCondition.await();
                        System.out.println("生产者恢复工作");
                    }
                    UUID uuid = UUID.randomUUID();
                    list.add(UUID.randomUUID());//添加完毕，唤醒消费者
                    System.out.println("生产者生产了一个UUID：" + uuid);
                    consumerCondition.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (list.isEmpty()) {
                        System.out.println("队列为空，消费者等待");
                        consumerCondition.await();
                    }
                    System.out.println("队列不为空，消费者消费：" + list.remove(0));
                    producerCondition.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 4; i++) {
            System.out.println("执行生产者任务");
            service.submit(new Producer());
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("执行消费者任务");
            service.submit(new Consumer());
        }
    }
}
