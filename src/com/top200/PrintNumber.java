package com.top200;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程交替打印0-100
 */
public class PrintNumber {

    private static Lock lock = new ReentrantLock();

    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();

    private static volatile int count = 0;

    private static int max = 100;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                lock.lock();
                while (count < max) {
                    if (count % 2 == 0) {
                        System.out.print("thread1  " + count + "\n");
                        count = count + 1;
                        condition2.signalAll();
                    }

                    try {
                        condition1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                while (count < max) {
                    if (count % 2 != 0) {
                        System.out.print("thread2  " + count+ "\n");
                        count = count + 1;
                        condition1.signalAll();
                    }

                    try {
                        condition2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
