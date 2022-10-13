package com.top200;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {

    private BlockingQueue<Runnable> workQueue;
    List<WorkThread> workThreads = new ArrayList<>();

    public MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        for (int i = 0; i < poolSize; i++) {
            WorkThread thread = new WorkThread();
            thread.start();
            workThreads.add(thread);
        }
    }

    void excute(Runnable command) throws InterruptedException {
        workQueue.put(command);
    }

    class WorkThread extends Thread {
        @Override
        public void run() {
            while (true) {
                Runnable task = null;
                try {
                    task = workQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
