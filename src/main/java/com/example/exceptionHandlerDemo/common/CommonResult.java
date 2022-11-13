package com.example.exceptionHandlerDemo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 通用返回响应
 *
 * @author ly
 * @since 2022/11/9
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CommonResult<T> {
    private Integer code;
    private T data;
    private String message;

    public CommonResult(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public CommonResult(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CommonResult(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public static <T> CommonResult create(ResultCode resultCode) {
        return new CommonResult(resultCode);
    }


    public static <T> CommonResult getErrorResult(String message) {
        return new CommonResult(-1, message);
    }

    public static <T> CommonResult create(ResultCode resultCode, T data) {
        return new CommonResult(resultCode, data);
    }

}
