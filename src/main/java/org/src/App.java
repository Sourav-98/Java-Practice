package org.src;

import org.src.threads101.RacingThreads;
import org.src.threads101.ThreadLifecycle;
import org.src.threads101.ThreadsBasics;

import java.util.Arrays;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        ThreadsBasics threadsBasics = new ThreadsBasics();
        RacingThreads racingThreads = new RacingThreads();
        ThreadLifecycle threadLifecycle = new ThreadLifecycle();

//        threadsBasics.execute();

//        racingThreads.startRace();

        threadLifecycle.executeLifecycle();

    }
}
