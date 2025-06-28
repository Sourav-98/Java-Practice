package org.src.threads101;

import org.src.logger.ThreadLogger;
import org.src.logger.ThreadLoggerWithExpectation;

import java.util.Optional;

public class ThreadLifecycle {

    static ThreadLogger threadLogger = (Thread thread) -> {
        Optional<ThreadGroup> tGroup = Optional.ofNullable(thread.getThreadGroup());
        System.out.println("[Thread: " + thread.getName() + " , ThreadGroup: " + (tGroup.isPresent() ? tGroup.get().getName() : "--") + "] STATE = " + thread.getState());
    };

    static ThreadLoggerWithExpectation expectThreadLogger = (Thread thread, Thread.State state) -> {
        Optional<ThreadGroup> tGroup = Optional.ofNullable(thread.getThreadGroup());
        System.out.println("[Thread: " + thread.getName() + " , ThreadGroup: " + (tGroup.isPresent() ? tGroup.get().getName() : "--") + "] EXPECTED STATE = "+ state.name() +" | ACTUAL STATE = " + thread.getState());
    };

    public void executeLifecycle() {
        Thread t1 = new Thread(() -> {
            System.out.println("New thread created. Thread Name: " + Thread.currentThread().getName());
            expectThreadLogger.log(Thread.currentThread(), Thread.State.RUNNABLE);
            try {
                Thread.sleep(4000);
                expectThreadLogger.log(Thread.currentThread(), Thread.State.RUNNABLE);
            } catch (InterruptedException ie) {
                System.out.println("Interrupted...");
            }
        }, "SRC-Thread-1");
        System.out.print("Current Thread: ");
        expectThreadLogger.log(Thread.currentThread(), Thread.State.RUNNABLE);
        expectThreadLogger.log(t1, Thread.State.NEW);
        t1.start();
        expectThreadLogger.log(t1, Thread.State.RUNNABLE);
        try {
            Thread.sleep(200);
            expectThreadLogger.log(t1, Thread.State.TIMED_WAITING);
            Thread.sleep(7000);
            expectThreadLogger.log(t1, Thread.State.TERMINATED);
        } catch (Exception e) {
        }
    }
}
