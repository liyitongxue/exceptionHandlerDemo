package com.example.exceptionHandlerDemo.common;

/**
 * @author ly
 * @since 2022/11/13
 */
public class UserException extends RuntimeException {
    public UserException() {
        super("自定义异常：用户名或密码错误！");
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}