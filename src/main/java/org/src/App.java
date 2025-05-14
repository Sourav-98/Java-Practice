package org.src;

import org.src.threads101.RacingThreads;
import org.src.threads101.ThreadsBasics;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ThreadsBasics threadsBasics = new ThreadsBasics();
        RacingThreads racingThreads = new RacingThreads();
        threadsBasics.execute();
        racingThreads.startRace();
    }
}
