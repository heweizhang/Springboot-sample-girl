package com.david.handle;

import com.david.domain.Result;
import com.david.enums.ResultEnum;
import com.david.exception.GirlException;
import com.david.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhanghewei on 17/10/30.
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException exception = (GirlException) e;
            return ResultUtils.error(exception.getCode(),exception.getMessage());
        }else{
            logger.error("【系统异常】{}"+ e.getMessage());
            return ResultUtils.error(ResultEnum.UNKNOW_ERROR.getCode(),"未知错误" );
        }
    }
}
