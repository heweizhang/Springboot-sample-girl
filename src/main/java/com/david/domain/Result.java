package com.david.domain;

/**
 * Http 返回示例
 * Created by zhanghewei on 17/10/30.
 */
public class Result<T> {
    private Integer code;//错误码
    private String message;//错误信息
    private T data;//错误具体内容

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
