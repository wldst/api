package com.wldst.ruder.exception;

import com.wldst.ruder.api.IErrorCode;

/**
 * @author PailieXiangLong
 */
public class CommonException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private IErrorCode errorCode;

    public CommonException(IErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public CommonException(IErrorCode errorCode, String message) {
        errorCode.setMessage(message);
        this.errorCode = errorCode;
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }

}
