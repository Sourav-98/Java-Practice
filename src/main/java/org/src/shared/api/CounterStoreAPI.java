package org.src.shared.api;

public interface CounterStoreAPI<T> {
    public void increment();
    public T getCount();
}
