package org.src.practices.lambdas.api;

@FunctionalInterface
public interface AreaCalculator {

    long getArea(int length, int breadth);

//    default Integer getSqArea(Integer side) {
//        return side * side;
//    }
}
