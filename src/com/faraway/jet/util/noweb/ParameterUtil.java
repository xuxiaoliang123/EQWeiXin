package com.faraway.jet.util.noweb;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 14-1-13
 * Time: 下午8:45
 * To change this template use File | Settings | File Templates.
 */
public class ParameterUtil {
    public static Map toMap(HttpServletRequest request){
        Map<String,Object> params=new HashMap<String,Object>();
        Enumeration e  =(Enumeration) request.getParameterNames();
        while(e.hasMoreElements()){
            String  parName=(String)e.nextElement();
            params.put(parName,request.getParameter(parName));
        }
        return params;
    }
}
