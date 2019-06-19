package com.fudo.store.exception;

public class BaseException extends RuntimeException {
    private Object data;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Object data) {
        super(message);
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
