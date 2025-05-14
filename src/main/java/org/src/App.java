package org.src;

import org.src.threads101.Threads101;

/**
 * Hello world!
 *
 */
public class App 
{

    static Threads101 threads101 = new Threads101();
    public static void main( String[] args )
    {
        threads101.execute();
    }
}
