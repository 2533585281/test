package com.wzb.util;

/**
 * @Author Administrator
 * @Date 2021/12/15 0015 11:09
 */
public enum ErrorCode {
    INTERNAL_SERVER_ERROR("500", "Internal Server Error"),
    BAD_REQUEST("400", "Bad request"),
    NOT_FOUND("404", "Page not found"),
    UNAUTHORIZED("401", "Unauthorized"),
    FORBIDDEN("403", "无权访问"),
    MEMBER_NOT_FOUND("9000", "用户不存在"),
    LOGIN_FAILURE("9001", "用户名或密码错误"),
    LOGOUT_FAILURE("9002", "用户退出异常"),
    OLD_PASSWORD_INCORRECT("9003", "原密码不正确"),
    TOKEN_ERROR("9004", "TOKEN错误"),
    USER_DISABLE("9005", "用户已被禁用"),
    NOT_LOGIN("9006", "未登录"),
    OTHER_LOGIN("9007", "已在其他地方登陆"),
    REGIST_PARAM_ERROR("9101", "请求参数有误"),
    REGIST_VERIFY_ERROR("9102", "图片验证码不正确"),
    REGIST_DYNAMIC_ERROR("9103", "动态验证码不正确"),
    REGIST_MOBILE_EXIST("9104", "手机号已注册"),
    REGIST_USERNAME_EXIST("9110", "用户名已注册"),
    DATA_EXIST("9111", "数据重复添加"),
    REGIST_FAILURE("9105", "用户注册失败"),
    ACCOUNT_NOT_FOUND("9201", "获取账户信息失败"),
    FORGET_NOT_FOUND("9301", "该手机号尚未注册"),
    FORGET_NOT_MATCH("9302", "短信验证码不正确"),
    FORGET_UNAUTHORIZED("9303", "该手机号未经验证"),
    FORGET_RESET_FAILED("9304", "登录密码重置失败"),
    PASSWORD_MODIFY_FAILED("9305", "登录密码修改失败"),
    SMS_DAILY_LIMIT("9901", "今日短信发送已达上限"),
    INVALID_CODE("40029", "invalid code");

    private String errorCode;
    private String message;

    private ErrorCode(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return this.errorCode;
    }
}
