package com.fudo.store.config;

import com.fudo.store.dto.BaseResponse;
import com.fudo.store.exception.BaseException;
import com.fudo.store.type.ResponseCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice implements ResponseBodyAdvice {
    private final static Logger LOG = LoggerFactory.getLogger(ControllerAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (o instanceof BaseResponse) {
            return o;
        } else {
            return new BaseResponse(o, "请求成功", ResponseCodeEnum.SUCCESS);
        }
    }


    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public BaseResponse handle(BaseException e) {
        LOG.error("exception:{},data:{}", e, e.getData());
        return new BaseResponse(e.getMessage(), ResponseCodeEnum.FAIL);
    }
}
