package org.src.threads101;

import org.src.logger.ThreadLogger;

public class ThreadsLifecycleDetailed {

    ThreadLogger threadLogger = (t) -> {
        System.out.println("[" + t.getName() + "] State = " + t.getState());
    };
}
