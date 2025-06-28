package org.src.logger;

@FunctionalInterface
public interface ThreadLogger {
    void log(Thread thread);
}
