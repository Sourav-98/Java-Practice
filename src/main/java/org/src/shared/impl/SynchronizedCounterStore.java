package org.src.shared.impl;

import org.src.shared.api.CounterStoreAPI;

public class SynchronizedCounterStore implements CounterStoreAPI<Long> {
    private Long count;

    public SynchronizedCounterStore() {
        this.count = (long) 0;
    }

    public synchronized void increment() {
        this.count++;
    }

    public synchronized Long getCount() {
        return this.count;
    }
}
