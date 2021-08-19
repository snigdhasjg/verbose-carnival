package com.joe.datastructure;

public interface Group<T extends Comparable<T>, U extends Group<T, U>> {
    boolean isEmpty();

    U add(T value);

    void remove(T value);
}
