package com.fudo.store.exception;

import com.fudo.store.type.BaseEnum;

public class BaseException extends RuntimeException {
    private Object data;

    public BaseException(BaseEnum baseEnum) {
        super(baseEnum.getMessage());
    }

    public BaseException(String message, Object data) {
        super(message);
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
