package com.librarymanagement.library.exception;

public class NotEnoughCopiesAvailable extends RuntimeException {
    public NotEnoughCopiesAvailable(String message) {
        super(message);
    }
}
