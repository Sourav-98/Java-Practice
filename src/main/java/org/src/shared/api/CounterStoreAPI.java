package org.src.shared.api;

public interface CounterStoreAPI<T> {
    void increment();

    T getCount();
}
