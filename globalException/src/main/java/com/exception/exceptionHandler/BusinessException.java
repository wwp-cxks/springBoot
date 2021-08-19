package com.exception.exceptionHandler;

import com.exception.enums.ResultCode;
import lombok.Data;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author cxks
 * @Date 2021/8/20 0:23
 */
@Data
public class BusinessException extends RuntimeException {

    protected Integer code;

    protected String message;


    public BusinessException(ResultCode resultCode) {
        this.code = resultCode.code();
        this.message = resultCode.message();
    }

}