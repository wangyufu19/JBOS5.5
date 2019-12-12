package com.jbos.infrastructure.websecurity.exception;
/**
 * AuthenticationException
 * @author youfu.wang
 * @date 2019-10-28
 */
public class AuthenticationException extends Exception{

    public AuthenticationException() {
        super();
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthenticationException(Throwable cause) {
        super(cause);
    }
}
