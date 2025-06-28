package org.src.logger;

@FunctionalInterface
public interface ThreadLoggerWithExpectation {
    void log(Thread thread, Thread.State state);
}