package org.src.threads101;

import org.src.tasks.MyClassThreadTask;
import org.src.tasks.MyRunnableThreadTask;
import org.src.tasks.MySleepingThreadTask;

public class ThreadsBasics {

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
         * Anonymous Thread object - getName of the thread
         */
        Thread t3 = new Thread("anonymous thread - src") {
            @Override
            public void run() {
                System.out.println("Anonymous Thread created. Name=" + getName());
            }
        };

        /**
         * Lambda Runnable.
         */
        Thread t4 = new Thread(() -> {
            System.out.println("Anonymous Lambda Runnable thread created.");
        });

        /**
         * A time-taking thread
         */
        Thread t5 = new Thread(new MySleepingThreadTask(), "SleepingThread 1");
        /**
         * A time-taking thread, which will be interrupted.
         */
        Thread t6 = new Thread(new MySleepingThreadTask(), "SleepingThread 2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t6.start();
        t6.interrupt();
    }
}
