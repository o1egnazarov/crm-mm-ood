package ru.noleg.crmmm.exception;

public class HeadTeacherNotFoundException extends RuntimeException {
    public HeadTeacherNotFoundException(String message) {
        super(message);
    }

    public HeadTeacherNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
