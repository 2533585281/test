package com.wzb.config;

import com.wzb.util.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Author Administrator
 * @Date 2021/12/15 0015 11:16
 * 全局处理RESTful 返回结果封装
 */
@ControllerAdvice(basePackages = {"com.wzb.controller"})
public class GlobalResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 判定哪些请求要执行beforeBodyWrite，返回true执行，返回false不执行
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    /**
     * 返回前对body，request，response等请求做处理
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 如果返回的body为null
        if(body == null){
            if (mediaType == MediaType.APPLICATION_JSON) {
                //返回是json个格式类型，无body内容
                return Response.ok();
            } else {
                return null;
            }
        } else if (body instanceof Response) {
            return body;
        } else {
            // 统一返回值处理
            return Response.ok(body);
        }
    }
}
