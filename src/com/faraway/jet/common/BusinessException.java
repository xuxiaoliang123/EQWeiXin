package com.faraway.jet.common;

import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-12-27
 * Time: 下午8:07
 * To change this template use File | Settings | File Templates.
 */
public class BusinessException extends InvocationTargetException {
    public BusinessException() {
    }

    public BusinessException(Throwable target) {
        super(target);
    }

    public BusinessException(Throwable target, String s) {
        super(target, s);
    }
}
