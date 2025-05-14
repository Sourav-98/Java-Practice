package org.src.shared.impl;

import org.src.shared.api.CounterStoreAPI;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicCounterStore implements CounterStoreAPI {
    private AtomicLong count;

    public AtomicCounterStore() {
        this.count = new AtomicLong(0);
    }

    @Override
    public void increment() {
        this.count.getAndAdd(1);
    }

    @Override
    public AtomicLong getCount() {
        return this.count;
    }
}
