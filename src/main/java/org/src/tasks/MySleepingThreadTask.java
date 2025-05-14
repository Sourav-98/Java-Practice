package org.src.tasks;

public class MySleepingThreadTask implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + " MySleepingThreadTask slept for 2 seconds.");
        } catch (InterruptedException ie) {
            System.out.println(Thread.currentThread().getName() + " MySleepingThreadTask was interrupted. " + ie);
        }
    }
}
