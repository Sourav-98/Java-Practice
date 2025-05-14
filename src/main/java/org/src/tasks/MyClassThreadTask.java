package org.src.tasks;

public class MyClassThreadTask extends Thread{

    @Override
    public void run() {
        System.out.println("MyClassThread running from a sub-class of Thread class.");
    }
}
