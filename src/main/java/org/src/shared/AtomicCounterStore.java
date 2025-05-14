package org.src.shared;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounterStore {
    private AtomicLong count;

    public AtomicCounterStore() {
        this.count = new AtomicLong(0);
    }

    public void increment() {
        this.count.getAndAdd(1);
    }

    public long getCount() {
        return this.count.longValue();
    }
}
