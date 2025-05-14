package org.src.shared.impl;

import org.src.shared.api.CounterStoreAPI;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounterStore implements CounterStoreAPI<AtomicLong> {
    private AtomicLong count;

    public AtomicCounterStore() {
        this.count = new AtomicLong(0);
    }

    @Override
    public void increment() {
        this.count.incrementAndGet();
    }

    @Override
    public AtomicLong getCount() {
        return this.count;
    }
}
