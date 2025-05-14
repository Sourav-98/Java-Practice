package org.src.threads101;

import org.src.tasks.MyClassThreadTask;
import org.src.tasks.MyRunnableThreadTask;

public class Threads101 {

    /**
     * Shows the different ways of creating threads
     */
    public void execute() {
        /**
         * Basic thread creation
         */
        Thread t1 = new Thread(new MyRunnableThreadTask());
        /**
         * Thread creation from a Runnable
         */
        MyClassThreadTask t2 = new MyClassThreadTask();
        /**
         * Anonymous Thread object
         */
        Thread t3 = new Thread() {
            @Override
            public void run() {
                System.out.println("Anonymous Thread created.");
            }
        };
        /**
         * Lambda Runnable.
         */
        Thread t4 = new Thread(() -> {
            System.out.println("Anonymous Lambda Runnable thread created.");
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
