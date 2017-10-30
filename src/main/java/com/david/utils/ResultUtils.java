package com.david.utils;

import com.david.domain.Result;
import com.david.enums.ResultEnum;

/**
 * Created by zhanghewei on 17/10/30.
 */
public class ResultUtils {
    /**
     * http 请求成功
     * @param object
     * @return
     */
    public static Result success(Object object) {
        if (object == null) return null;

        Result result = new Result();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setData(object);
        return result;
    }

    /**
     * Http 请求失败
     * @param message
     * @return
     */
    public static Result error(int code ,String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
