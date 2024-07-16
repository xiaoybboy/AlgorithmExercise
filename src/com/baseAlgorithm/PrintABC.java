package com.baseAlgorithm;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {

    private static Lock lock = new ReentrantLock();
    private static Condition condition1 = lock.newCondition();
    private static Condition condition2 = lock.newCondition();
    private static Condition condition3 = lock.newCondition();
    static int count = 0;

    static class ThreadA extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    if (count % 3 != 0) {
                        condition1.await();
                    }
                    System.out.print("A");
                    count++;
                    condition2.signal();
                }
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadB extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    if (count % 3 != 1) {
                        condition2.await();
                    }
                    System.out.print("B");
                    count++;
                    condition3.signal();
                }
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    static class ThreadC extends Thread {
        @Override
        public void run() {
            try {
                lock.lock();
                for (int i = 0; i < 10; i++) {
                    if (count % 3 != 2) {
                        condition3.await();
                    }
                    System.out.print("C");
                    count++;
                    condition1.signal();
                }
            } catch (Exception e) {

            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new ThreadA().start();
        new ThreadB().start();
        new ThreadC().start();
    }
}
