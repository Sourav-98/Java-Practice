package org.src;

import org.src.threads101.RacingThreads;
import org.src.threads101.ThreadsBasics;

/**
 * Hello world!
 *
 */
public class App 
{

    static ThreadsBasics threadsBasics = new ThreadsBasics();
    static RacingThreads racingThreads = new RacingThreads();
    public static void main( String[] args )
    {
//        threadsBasics.execute();
        racingThreads.startRace();
    }
}
