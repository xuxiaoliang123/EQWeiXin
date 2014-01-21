package com.faraway.jet.util.noweb;

import java.util.Date;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-15
 * Time: 下午7:52
 * To change this template use File | Settings | File Templates.
 */
public class MakeRandomString {

    private static String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String genString(){
        Random random = new Random();
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 20; i++) {
            int num = random.nextInt(62);
            buf.append(str.charAt(num));
        }
        return buf.toString();
    }
}
