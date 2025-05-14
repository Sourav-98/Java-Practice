package org.src.threads101;

import org.src.shared.api.CounterStoreAPI;
import org.src.shared.impl.AtomicCounterStore;
import org.src.shared.impl.CounterStore;
import org.src.shared.impl.SynchronizedCounterStore;

/**
 * This demonstrates Read-Modify-Write racing threads.
 *
 * Both threads read the same Counter object, increments the value (modify) and writes back the incremented value.
 *
 * There is a synchronised counter, and an atomic counter created. Both follow the same behaviour.
 */
public class RacingThreads {

    static Runnable getRunnableCounter (CounterStoreAPI counterStore) {
        return () -> {
            for(int i=0; i<10000000; i++) {
                counterStore.increment();
            }
            System.out.println("Counter value from " + Thread.currentThread().getName() +  ": " + counterStore.getCount());
        };
    }

    public void startRace() {
        CounterStore counterStore = new CounterStore();
        SynchronizedCounterStore syncCounterStore = new SynchronizedCounterStore();
        AtomicCounterStore atomicCounterStore = new AtomicCounterStore();
        // race-condition threads
        Thread t1 = new Thread(getRunnableCounter(counterStore), "Runnable Counter 1");
        Thread t2 = new Thread(getRunnableCounter(counterStore), "Runnable Counter 2");
        t1.start();
        t2.start();
        // synchronized updates
        Thread t3 = new Thread(getRunnableCounter(syncCounterStore), "Sync Runnable Counter 1");
        Thread t4 = new Thread(getRunnableCounter(syncCounterStore), "Sync Runnable Counter 2");
        t3.start();
        t4.start();
        // atomic updates.
        Thread t5 = new Thread(getRunnableCounter(atomicCounterStore), "Atomic Runnable Counter 1");
        Thread t6 = new Thread(getRunnableCounter(atomicCounterStore), "Atomic Runnable Counter 2");
        t5.start();
        t6.start();
    }
}
