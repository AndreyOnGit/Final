package ru.ae.iterator;

import ru.ae.linkedlist.IndexExceedsSizeLengthException;

public class RandomIterator {
    int count;
    int limit;

    public double next() {
        if (count < limit) {
            count++;
            return Math.random();
        }
        throw new NoSuchElementException(String.format("Limit %s exceeded", limit));
    }

    public RandomIterator(int limit) {
        this.count = 0;
        this.limit = limit;
    }

    public boolean hasNext() {
        if (count < limit) return true;
        else return false;
    }
}
