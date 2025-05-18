package org.src.threads101;

public class ThreadLifecycle {

    static void threadLogger(String threadName, String threadState) {
        System.out.println("[" + threadName + "] State = " + threadState);
    }

    public void executeLifecycle() {
        Thread t1 = new Thread(() -> {
            System.out.println("New thread created. Thread Name: " + Thread.currentThread().getName());
            threadLogger("FROM Thread " +Thread.currentThread().getName(), Thread.currentThread().getState().toString());
            try {
                Thread.sleep(5000);
                threadLogger("FROM Thread " +Thread.currentThread().getName(), Thread.currentThread().getState().toString());
            } catch (InterruptedException ie) {

            }
        }, "SRC-Thread-1");
        System.out.println("Current Thread: " + Thread.currentThread().getName());
        threadLogger("FROM MAIN " + t1.getName(), t1.getState().toString());
        t1.start();
        threadLogger("FROM MAIN " + t1.getName(), t1.getState().toString());
        try {
            Thread.sleep(500);
            threadLogger("FROM MAIN " + t1.getName(), t1.getState().toString());
            Thread.sleep(6000);
            threadLogger("FROM MAIN " + t1.getName(), t1.getState().toString());
        } catch (Exception e) {

        }
    }
}
