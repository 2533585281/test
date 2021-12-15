package com.wzb.config;

import com.wzb.util.ErrorCode;
import com.wzb.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @Author Administrator
 * @Date 2021/12/15 0015 11:03
 * 全局处理RESTful API异常
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 请求参数验证错误，使用@RequestParam上@Validate失败后抛出的异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public Response constraintViolationException(HttpServletRequest request, ConstraintViolationException e) {
        log.error("【请求接口】{}，执行出错：请求参数验证失败，message：{}", request.getServletPath(), e.getMessage());
        String errorMsg = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(";"));
        return Response.error("请求参数验证失败：" + errorMsg);
    }

    /**
     * GET请求中 使用@Valid验证路径中请求实体校验失败后抛出的异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public Response bindExceptionHandler(HttpServletRequest request, BindException e) {
        log.error("【请求接口】{}，执行出错：请求参数验证失败，message：{}", request.getServletPath(), e.getMessage());
        String errorMsg = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));
        return Response.error("请求参数验证失败：" + errorMsg);
    }

    /**
     * POST请求中，使用@RequestBody上@Validate失败后抛出的异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response methodArgumentNotValidExceptionHandler(HttpServletRequest request, MethodArgumentNotValidException e) {
        log.error("【请求接口】{}，执行出错：请求参数验证失败，message：{}", request.getServletPath(), e.getMessage());
        String errorMsg = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(";"));
        return Response.error("请求参数验证失败：" + errorMsg);
    }

    /**
     * 缺少请求参数
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Response missingServletRequestParameterException(HttpServletRequest request, MissingServletRequestParameterException e) {
        log.error("【请求接口】{}，执行出错：缺少请求参数，message：{}", request.getServletPath(), e.getMessage());
        String msg = String.format("缺少请求参数：%s", e.getParameterName());
        return Response.error(msg);
    }

    /**
     * 请求参数类型错误
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Response methodArgumentTypeMismatchException(HttpServletRequest request, MethodArgumentTypeMismatchException e) {
        log.error("【请求接口】{}，执行出错：请求参数类型错误，message：{}", request.getServletPath(), e.getMessage());
        String msg = String.format("请求参数类型错误：%s，应为：%s", e.getName(), e.getRequiredType().getSimpleName());
        return Response.error(msg);
    }

    /**
     * 接口请求方式错误
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response httpRequestMethodNotSupportedException(HttpServletRequest request, HttpRequestMethodNotSupportedException e) {
        log.info("【请求接口】{}，执行出错：接口请求方式错误，message：{}", request.getServletPath(), e.getMessage());
        return Response.error("HTTP请求方式不支持");
    }

    /**
     * 404错误异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    public Response noHandlerFoundException(HttpServletRequest request, Exception e) {
        log.error("【请求接口】{}，执行出错：未找到该方法，message：{}", request.getServletPath(), e.getMessage());
        return Response.error(ErrorCode.BAD_REQUEST);
    }

    /**
     * 其他异常
     *
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Response exception(HttpServletRequest request, Exception e) {
        log.error("【请求接口】{}，执行出错，message：{}", request.getServletPath(), e.getMessage());
        return Response.error(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
