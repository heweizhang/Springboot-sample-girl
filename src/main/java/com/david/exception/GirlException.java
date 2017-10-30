package com.david.exception;

import com.david.enums.ResultEnum;

/**
 * Created by zhanghewei on 17/10/30.
 */
public class GirlException extends RuntimeException {

    private Integer code;


    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
