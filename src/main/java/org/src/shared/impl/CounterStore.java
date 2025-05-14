package org.src.shared.impl;

import org.src.shared.api.CounterStoreAPI;

public class CounterStore implements CounterStoreAPI<Long> {
    private Long count;

    public CounterStore() {
        this.count = (long) 0;
    }

    public void increment() {
        this.count++;
    }

    public Long getCount() {
        return this.count;
    }
}
