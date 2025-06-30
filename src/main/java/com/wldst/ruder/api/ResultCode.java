package com.wldst.ruder.api;

/**
 * 返回码
 * @author wldst
 *
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    UPLOAD_SUCCESS(0, "上传成功"),
   
    /**
     * 没有权限
     */
    NO_PERMISSION(403, "No Permission"),
    FORBIDDEN(403, "权限不足"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "token失效"),
    SERVER_ERROR(500, "Internal Server Error"),
    /**
     * 参数错误
     */
    INVALID_PARAMETERS(501, "Invalid Parameters"),
    INVALID_STATE(503,"业务逻辑执行失败"),
    /**
     * Token失效
     */
    INVALID_TOKEN(502, "Invalid Token"),
    TOKEN_EXPIRED(502, "The token has expired"),
    FAILED(503, "操作失败"),
    USER_NOT_FOUND(504,"找不到用户"),
    USER_ALREADY_EXISTS(500,"用户已经存在"),
    /**
     * 数据存在
     */
    DATA_DUPLICATION(505, "Data exists"),
    /**
     * 验证失败
     */
    VERIFICATION_FAILED(506, "Wrong account or password."),

    /**
     * 请求过于频繁
     */
    REQUEST_TOO_FREQUENT(509, "Requests are too frequent"),

    /**
     * Invalid Parameters
     */
    PRIVATE_KEY_EXIST(502, "exist"),

    PRIVATE_KEY_NOT_EXIST(503, "key not exist");
    private long code;
    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String msg) {
	// TODO Auto-generated method stub
	this.message=msg;
    }
}
