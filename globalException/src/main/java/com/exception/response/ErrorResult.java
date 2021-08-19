package com.exception.response;

import com.exception.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author cxks
 * @Date 2021/8/19 23:46
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorResult {

    /**
     * 异常状态码
     */
    private Integer status;

    /**
     * 用户看得见的异常，例如：用户名重复！！
     */
    private String message;

    /**
     * 异常名字
     */
    private String exception;

    /**
     * 异常堆栈信息
     */
    private String errors;

    /**
     * 对异常提示进行封装
     */
    public static ErrorResult fail(ResultCode resultCode, Throwable e, String message){
        ErrorResult result = ErrorResult.fail(resultCode, e);
        result.setMessage(message);
        return result;
    }

    /**
     * 对异常枚举进行封装
     */
    public static ErrorResult fail(ResultCode resultCode, Throwable e){
        ErrorResult result = new ErrorResult();
        result.setMessage(resultCode.message());
        result.setStatus(resultCode.code());
        result.setException(e.getClass().getName());
//        result.setErrors(Throwables.getStackTranceAsString(e));
        return result;
    }
}
