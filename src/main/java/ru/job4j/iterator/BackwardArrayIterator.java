package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIterator implements Iterator<Integer> {
    private final int[] data;
    private int point;

    public BackwardArrayIterator(int[] data) {
        /* реализуйте конструктор */
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        /* Реализуйте метод */
        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[data.length - ++point];
    }
}
