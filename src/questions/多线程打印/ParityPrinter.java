package questions.多线程打印;

public class ParityPrinter {
    private int max;//最大打印次数
    private int current;//当前打印次数
    private boolean printOdd;//是否打印奇数
    public ParityPrinter(int max) {
        this.max = max;
    }
    //打印奇数
    public synchronized void printOdd(){
        while(current < max){
            while(!printOdd){
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + "打印奇数" + current);
            current++;
            printOdd = false;
            //唤醒另一个线程
            notify();
        }
    }
    //打印偶数
    public synchronized void printEven(){
        while(current < max){
            while(printOdd){
                try {
                    wait();
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println(Thread.currentThread().getName() + "打印偶数" + current);
            current++;
            printOdd = true;
            //唤醒另一个线程
            notify();
        }
    }
}
