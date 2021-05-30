package ru.ae.arraylist;

public class IndexExceedsSizeLengthException extends RuntimeException {
    public IndexExceedsSizeLengthException(String message) {
        super(message);
    }
}