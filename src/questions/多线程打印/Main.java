package questions.多线程打印;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore1= new Semaphore(1);
        Semaphore semaphore2= new Semaphore(1);

        new Thread(()->{
            try {
                semaphore1.acquire();
                for(int i=0;i<10;i++){
                    System.out.println("我是A线程，正在打印"+i);
                }
                semaphore1.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                semaphore2.acquire();
                for(int i=0;i<10;i++){
                    System.out.println("我是B线程，正在打印"+i);
                }
                semaphore2.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(()->{
            try {
                semaphore1.acquire();
                semaphore2.acquire();
                System.out.println("我是C线程，AB执行完了我才能执行");
                semaphore1.release();
                semaphore2.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

}