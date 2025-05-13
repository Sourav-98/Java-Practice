package org.src.practices.lambdas.api;

@FunctionalInterface
public interface VolumeCalculator {

    long getVolume (int length, int breadth, int height);
}
