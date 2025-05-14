package org.src.shared;

public class SynchronizedCounterStore {
    private long count;

    public SynchronizedCounterStore() {
        this.count = 0;
    }

    public long increment() {
        synchronized (this) {
            this.count++;
            return this.count;
        }
    }

    public long getCount() {
        synchronized (this) {
            return this.count;
        }
    }
}
