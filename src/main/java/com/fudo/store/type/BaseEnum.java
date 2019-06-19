package com.fudo.store.type;

public enum BaseEnum {
    DATA_NOT_FOND("数据不存在"),
    INSUFFICIENT_STOCK("库存量不足"),
    ;

    private String message;

    BaseEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
