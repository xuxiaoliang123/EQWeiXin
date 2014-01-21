package com.faraway.jet.common;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-25
 * Time: 下午7:57
 * To change this template use File | Settings | File Templates.
 */
public class AppException extends Exception {
    public AppException(String message) {
        super(message);
    }

    public AppException() {
    }
}
