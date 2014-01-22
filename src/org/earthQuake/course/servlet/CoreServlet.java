package org.earthQuake.course.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.earthQuake.course.common.bean.TabMenuDetail;
import org.earthQuake.course.dao.impl.MenuDaoImpl;
import org.earthQuake.course.service.CoreService;
import org.earthQuake.course.service.MenuService;
import org.earthQuake.course.serviceImpl.MenuServiceImpl;
import org.earthQuake.course.util.SignUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 核心请求处理类
 * 
 * @author xuxiaoliang
 * @date 2014-1-5
 */
public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 4440739483644821986L;

	/**
	 * 确认请求来自微信服务器
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 微信加密签名
		String signature = request.getParameter("signature");
		// 时间戳
		String timestamp = request.getParameter("timestamp");
		// 随机数
		String nonce = request.getParameter("nonce");
		// 随机字符串
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.close();
		out = null;
	}

	/**
	 * 处理微信服务器发来的消息
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 消息的接收、处理、响应
		// 将请求、响应的编码均设置为UTF-8（防止中文乱码）  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8"); 
        
        
        //得到菜单
        int i;
        StringBuffer sbf = new StringBuffer();
        
        HttpSession session = request.getSession();
        if(null == session.getAttribute("menu")){
        	ApplicationContext act=new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
            MenuService menuService=(MenuServiceImpl)act.getBean("menuService");
            List<TabMenuDetail> list = menuService.getMenus();
            
            for(i = 0; i < list.size(); i++){
            	TabMenuDetail menu = (TabMenuDetail)list.get(i);
            	if(null != menu.getMenuexplain()){
            		sbf.append(menu.getMenuexplain()).append("\n");
            	}else{
            		sbf.append(menu.getMenuContent()).append("\n");
            	}
            }
            session.setAttribute("menu", sbf.toString());
        }
        
//        String resourceFile = "org.earthQuake.course.properties.MenuProperties_zh_CN";
//        ResourceBundle resource = ResourceBundle.getBundle(resourceFile);
//        
//        StringBuffer sbf = new StringBuffer();
//        sbf.append(resource.getString("menuexplain"));
//        
//        //取得所有菜单项
//        Enumeration <String>enu = resource.getKeys();
//        while(enu.hasMoreElements()) {
//        	if(!enu.nextElement().equals("menuexplain")){
//        		sbf.append(resource.getString(enu.nextElement()));
//        	}
//        }
        
        
        // 调用核心业务类接收消息、处理消息  
        String respMessage = CoreService.processRequest(request);  
          
        // 响应消息  
        PrintWriter out = response.getWriter();  
        out.print(respMessage);  
        out.close();  
	}

}
