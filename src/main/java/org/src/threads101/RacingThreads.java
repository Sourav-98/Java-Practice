package org.src.threads101;

import org.src.shared.AtomicCounterStore;
import org.src.shared.CounterStore;
import org.src.shared.SynchronizedCounterStore;

/**
 * This demonstrates Read-Modify-Write racing threads.
 *
 * Both threads read the same Counter object, increments the value (modify) and writes back the incremented value.
 *
 * There is a synchronised counter, and an atomic counter created. Both follow the same behaviour.
 */
public class RacingThreads {

    static CounterStore counterStore = new CounterStore();
    static SynchronizedCounterStore syncCounterStore = new SynchronizedCounterStore();
    static AtomicCounterStore atomicCounterStore = new AtomicCounterStore();

    static Runnable runnableCounter = () -> {
        for(int i=0; i<10000000; i++) {
            counterStore.increment();
        }
        System.out.println("Counter value from " + Thread.currentThread().getName() +  ": " + counterStore.getCount());
    };

    static Runnable syncRunnableCounter = () -> {
        for(int i=0; i<10000000; i++) {
            syncCounterStore.increment();
        }
        System.out.println("Counter value from " + Thread.currentThread().getName() +  ": " + syncCounterStore.getCount());
    };

    static Runnable atomicRunnableCounter = () -> {
        for(int i=0; i<10000000; i++) {
            atomicCounterStore.increment();
        }
        System.out.println("Counter value from " + Thread.currentThread().getName() +  ": " + atomicCounterStore.getCount());
    };

    public void startRace() {
        Thread t1 = new Thread(runnableCounter, "Runnable Counter 1");
        Thread t2 = new Thread(runnableCounter, "Runnable Counter 2");
        // synchronized updates
        Thread t3 = new Thread(syncRunnableCounter, "Sync Runnable Counter 1");
        Thread t4 = new Thread(syncRunnableCounter, "Sync Runnable Counter 2");
        // atomic updates.
        Thread t5 = new Thread(atomicRunnableCounter, "Atomic Runnable Counter 1");
        Thread t6 = new Thread(atomicRunnableCounter, "Atomic Runnable Counter 2");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
