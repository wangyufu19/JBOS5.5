package com.jbos.common.websecurity.exception;
/**
 * UserLockedException
 * @author youfu.wang
 * @date 2019-10-28
 */
public class UserLockedException extends AuthenticationException{

    public UserLockedException() {
        super();
    }

    public UserLockedException(String message) {
        super(message);
    }

    public UserLockedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserLockedException(Throwable cause) {
        super(cause);
    }
}
