package com.librarymanagement.library.exception;

public class NoLoansException extends RuntimeException {
    public NoLoansException(String message) {
        super(message);
    }
}
