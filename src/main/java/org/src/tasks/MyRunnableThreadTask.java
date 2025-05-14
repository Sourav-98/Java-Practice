package org.src.tasks;

public class MyRunnableThreadTask implements Runnable {

    @Override
    public void run() {
        System.out.println("MyRunnableThread running from Runnable implemented class.");
    }
}
