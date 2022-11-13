package com.example.exceptionHandlerDemo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ly
 * @since 2022/11/13
 */
@Slf4j
@RestController
public class MyErrorController implements ErrorController {
//    @Override
//    public String getErrorPath() {
//        return "/error";
//    }

    @RequestMapping(value = {"/error"})
    public Object error(HttpServletRequest request, WebRequest webRequest) {
        Map<String, Object> body = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();

        // 获取springboot原生报错返回信息
        final ErrorAttributeOptions errorAttributeOptions = ErrorAttributeOptions.of(ErrorAttributeOptions.Include.STACK_TRACE);
        ErrorAttributes errorAttributes = new DefaultErrorAttributes();
        dataMap = errorAttributes.getErrorAttributes(webRequest, errorAttributeOptions);
        dataMap.remove("trace"); // 移除 trace 以避免抛出错误详细信息

        body.put("code", dataMap.get("status"));
        body.put("message", "请求失败");
        body.put("data", dataMap); // 添加到返回体的 “data” 中
        log.info(String.valueOf(body));
        return body;
    }
}