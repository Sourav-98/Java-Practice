package org.src.shared.impl;

import org.src.shared.api.CounterStoreAPI;

public class SynchronizedCounterStore implements CounterStoreAPI {
    private Long count;

    public SynchronizedCounterStore() {
        this.count = (long) 0;
    }

    public void increment() {
        synchronized (this) {
            this.count++;
        }
    }

    public Long getCount() {
        synchronized (this) {
            return this.count;
        }
    }
}
