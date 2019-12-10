package com.jbos.common.websecurity.exception;
/**
 * UserIncorrectException
 * @author youfu.wang
 * @date 2019-10-28
 */
public class UserIncorrectException extends AuthenticationException{

    public UserIncorrectException() {
        super();
    }

    public UserIncorrectException(String message) {
        super(message);
    }

    public UserIncorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIncorrectException(Throwable cause) {
        super(cause);
    }
}
