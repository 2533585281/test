package com.wzb.util;


/**
 * @Author Administrator
 * @Date 2021/12/15 0015 11:05
 */
public class Response<T> {
    private boolean success;
    private int code;
    private Object msg;
    private T data;

    public Response() {
    }

    public Response(int code, Object status) {
        this.code = code;
        this.msg = status;
        if (code == 1) {
            this.success = true;
        } else {
            this.success = false;
        }

    }

    public Response(int code, String status, T result) {
        this.code = code;
        this.msg = status;
        this.data = result;
        if (code == 1) {
            this.success = true;
        } else {
            this.success = false;
        }

    }

    public static Response<?> ok() {
        return new Response(1, "success");
    }

    public static <T> Response<T> ok(T t) {
        return new Response(1, "success", t);
    }

    public static Response<?> error(String status) {
        return new Response(500, status);
    }

    public static Response<?> error(int code, String status) {
        return new Response(code, status);
    }

    public static Response<?> error(ErrorCode errorCode) {
        return new Response(Integer.valueOf(errorCode.getErrorCode()), errorCode.getMessage());
    }

    public static Response<?> error(Exception e) {
        return new Response(500, e);
    }

    public static <T> Response<T> builder(int code, String status, T t) {
        return new Response(code, status, t);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getMsg() {
        return this.msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
