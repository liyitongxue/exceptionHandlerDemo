package com.example.exceptionHandlerDemo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author ly
 * @since 2022/11/9
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 用户异常处理
     *
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler(UserException.class)
    public Object handleBusinessException(UserException e) throws Exception {
        log.error("UserNotExistException error", e);
        return CommonResult.create(ResultCode.USER_LOGIN_ERROR);
    }
}