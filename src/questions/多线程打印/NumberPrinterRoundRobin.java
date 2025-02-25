package questions.多线程打印;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class NumberPrinterRoundRobin {

    private int max; // 打印上限
    private int current = 1; // 当前要打印的数字，初始值为 1
    private final ReentrantLock lock = new ReentrantLock(); // 可重入锁
    private Condition condition1 = lock.newCondition(); // 控制线程 1 的 Condition
    private Condition condition2 = lock.newCondition(); // 控制线程 2 的 Condition
    private Condition condition3 = lock.newCondition(); // 控制线程 3 的 Condition

    public NumberPrinterRoundRobin(int max) {
        this.max = max;
    }

    public void printer1() {
        try {
            while (current <= max) { // 循环直到打印到上限
                lock.lock(); // 获取锁
                try {
                    if (current % 3 != 1) { // 只有当 current % 3 == 1 时，才轮到线程 1 打印
                        condition1.await();// 线程 1 等待 condition1 的信号
                    }
                    if (current <= max) { // 再次检查 current <= max，防止最后一次多打印
                        System.out.println(Thread.currentThread().getName() + ": " + current++);
                    }
                    condition2.signal(); // 发送信号给 condition2，唤醒线程 2
                } finally {
                    lock.unlock(); // 释放锁
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 响应中断
            throw new RuntimeException(e);
        }
    }

    public void printer2() {
        try {
            while (current <= max) { // 循环直到打印到上限
                lock.lock(); // 获取锁
                try {
                    if (current % 3 != 2) { // 只有当 current % 3 == 2 时，才轮到线程 2 打印
                        condition2.await();// 线程 2 等待 condition2 的信号
                    }
                    if (current <= max) { // 再次检查 current <= max，防止最后一次多打印
                        System.out.println(Thread.currentThread().getName() + ": " + current++);
                    }
                    condition3.signal(); // 发送信号给 condition3，唤醒线程 3
                } finally {
                    lock.unlock(); // 释放锁
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 响应中断
            throw new RuntimeException(e);
        }
    }

    public void printer3() {
        try {
            while (current <= max) { // 循环直到打印到上限
                lock.lock(); // 获取锁
                try {
                    if (current % 3 != 0) { // 只有当 current % 3 == 0 时，才轮到线程 3 打印 (或者 current % 3 == 0 && current <= max)
                        condition3.await();// 线程 3 等待 condition3 的信号
                    }
                    if (current <= max) { // 再次检查 current <= max，防止最后一次多打印
                        System.out.println(Thread.currentThread().getName() + ": " + current++);
                    }
                    condition1.signal(); // 发送信号给 condition1，唤醒线程 1，形成循环
                } finally {
                    lock.unlock(); // 释放锁
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 响应中断
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NumberPrinterRoundRobin printer = new NumberPrinterRoundRobin(100); // 设置打印上限为 100

        new Thread(printer::printer1, "线程1").start(); // 启动线程 1
        new Thread(printer::printer2, "线程2").start(); // 启动线程 2
        new Thread(printer::printer3, "线程3").start(); // 启动线程 3

        // 启动打印的初始信号，让线程 1 先开始打印
        try {
            Thread.sleep(100); // 稍微等待一下，确保线程都启动并等待
            printer.lock.lock(); // 获取锁才能 signal
            printer.condition1.signal(); // 发送信号给 condition1，启动线程 1
        } finally {
            printer.lock.unlock(); // 释放锁
        }
    }
}