package com.jbos.infrastructure.websecurity.exception;
/**
 * UserInvalidException
 * @author youfu.wang
 * @date 2019-10-28
 */
public class UserInvalidException extends AuthenticationException{

    public UserInvalidException() {
        super();
    }

    public UserInvalidException(String message) {
        super(message);
    }

    public UserInvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserInvalidException(Throwable cause) {
        super(cause);
    }
}
