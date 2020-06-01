package com.tofix.kidmall.common;

/**
 * @author duskry ren
 * @description 状态码
 * @date 2020/6/1
 **/
public enum ResultCode implements IErrorCode {
    /**
     * 状态码
     */
    SUCCESS(200, "成功"),
    FAILED(500, "失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限");

    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
