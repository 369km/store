package com.fudo.store.exception;

import com.fudo.store.type.BaseEnum;

public class BaseException extends RuntimeException {
    private Object data;

    public BaseException(BaseEnum baseEnum) {
        super(baseEnum.getMessage());
    }

    public BaseException(BaseEnum baseEnum, Object data) {
        this(baseEnum);
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
