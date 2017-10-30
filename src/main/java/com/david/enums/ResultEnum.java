package com.david.enums;

/**
 * Created by zhanghewei on 17/10/30.
 */
public enum  ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"success"),
    ERROR(1,"error"),
    PRIMARY_SCHOOl(100,"上小学"),
    MIDDLE_SCHOOl(101,"上初中");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
