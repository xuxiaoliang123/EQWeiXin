package com.faraway.jet.framework.sysmanager;

import com.faraway.jet.common.AppException;
import com.faraway.jet.common.BusinessException;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: weipan
 * Date: 13-12-23
 * Time: 下午10:25
 * To change this template use File | Settings | File Templates.
 */
public class Rain extends HttpServlet {

    private ApplicationContext applicationContext=null;



    protected void doGet (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        applicationContext=
                WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        String eventName=(String)request.getParameter("eventName");
        if(request.getParameter("pageModel")==null){
            responPrint(response,"缺少请求信息");
            return ;
        }
        if(eventName!=null&&!"".equals(eventName)){
            String message="";
            try{
                message=doEvent(request,response);
                responPrint(response,message);
            }catch (AppException e){
                responPrint(response, e.getMessage() == null ? "操作失败" : e.getMessage());
            }catch (Exception e){
                responPrint(response,e.getMessage());
            }
            return ;
        }else {
            Map<String,String> map=new HashMap<String,String>();
            map.put("pageModel",request.getParameter("pageModel"));

            map.put("pageSelectedAtRuntime",request.getParameter("pageModel").replace('.','/')+".jsp");
            map.put("jsSelectedAtRuntime","page/"+request.getParameter("pageModel").replace('.','/')+".js");
            return ;
        }
    }

    private String doEvent(HttpServletRequest request, HttpServletResponse response)throws AppException{
        String result=null;
        try {
            Class pm=  Class.forName("com.faraway.local.pagemodel."+request.getParameter("pageModel")+"PageModel");
            Object o=pm.newInstance();
            Field req=pm.getSuperclass().getDeclaredField("request");
            req.setAccessible(true);
            req.set(o,request);
            Field res=pm.getSuperclass().getDeclaredField("response");
            res.setAccessible(true);
            res.set(o,response);
            Field jdbc=pm.getSuperclass().getDeclaredField("jdbcTemplate");
            jdbc.setAccessible(true);
            jdbc.set(o,(JdbcTemplate) applicationContext.getBean("jdbcTemplate"));

            result=(String)pm.getMethod(request.getParameter("eventName")).invoke(o);

        } catch (BusinessException e){
            /*e.printStackTrace();*/
            System.out.println("Exception###"+1);
            throw new AppException(e.getMessage());
        }catch (Exception e) {
            System.out.println("Exception###"+2);
            e.printStackTrace();
            throw new AppException(e.getMessage());
        }catch(Throwable e){
            System.out.println("Exception###"+3);
        }
        return result;
    }


    private void responPrint(HttpServletResponse response,String message) throws IOException {
        //response.setCharacterEncoding("utf-8");
        response.setContentType("text/plain; charset=utf-8");
        PrintWriter printWriter=response.getWriter();
        printWriter.print(message);
        printWriter.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
