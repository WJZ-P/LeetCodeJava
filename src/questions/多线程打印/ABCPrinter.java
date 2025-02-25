package questions.多线程打印;

import java.util.concurrent.Semaphore;

public class ABCPrinter {
    private final int max;
    private Semaphore semaphoreA=new Semaphore(1);
    private Semaphore semaphoreB=new Semaphore(0);
    private Semaphore semaphoreC=new Semaphore(0);
    public ABCPrinter(int max) {
        this.max = max;
    }

    public void printA(){
        try {
            for (int i = 0; i < max; i++) {
                semaphoreA.acquire();
                System.out.println(Thread.currentThread().getName()+":"+"A");
                semaphoreB.release();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void printB(){
        try {
            for (int i = 0; i < max; i++) {
                semaphoreB.acquire();
                System.out.println(Thread.currentThread().getName()+":"+"B");
                semaphoreC.release();
            }
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void printC(){
        try {
            for (int i = 0; i < max; i++) {
                semaphoreC.acquire();
                System.out.println(Thread.currentThread().getName()+":"+"C");
                semaphoreA.release();
            }
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ABCPrinter abcPrinter=new ABCPrinter(10);
        new Thread(abcPrinter::printA).start();
        new Thread(abcPrinter::printB).start();
        new Thread(abcPrinter::printC).start();
    }
}
