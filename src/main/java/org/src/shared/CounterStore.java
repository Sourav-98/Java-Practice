package org.src.shared;

public class CounterStore {
    private long count;

    public CounterStore() {
        this.count = 0;
    }

    public void increment() {
        this.count++;
    }

    public long getCount() {
        return this.count;
    }
}
