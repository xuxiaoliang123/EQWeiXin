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
 * ������������
 * 
 * @author xuxiaoliang
 * @date 2014-1-5
 */
public class CoreServlet extends HttpServlet {
	private static final long serialVersionUID = 4440739483644821986L;

	/**
	 * ȷ����������΢�ŷ�����
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ΢�ż���ǩ��
		String signature = request.getParameter("signature");
		// ʱ���
		String timestamp = request.getParameter("timestamp");
		// �����
		String nonce = request.getParameter("nonce");
		// ����ַ���
		String echostr = request.getParameter("echostr");
		
		PrintWriter out = response.getWriter();
		// ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.close();
		out = null;
	}

	/**
	 * ����΢�ŷ�������������Ϣ
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ��Ϣ�Ľ��ա�������Ӧ
		// ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8"); 
        
        
        //�õ��˵�
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
//        //ȡ�����в˵���
//        Enumeration <String>enu = resource.getKeys();
//        while(enu.hasMoreElements()) {
//        	if(!enu.nextElement().equals("menuexplain")){
//        		sbf.append(resource.getString(enu.nextElement()));
//        	}
//        }
        
        
        // ���ú���ҵ���������Ϣ��������Ϣ  
        String respMessage = CoreService.processRequest(request);  
          
        // ��Ӧ��Ϣ  
        PrintWriter out = response.getWriter();  
        out.print(respMessage);  
        out.close();  
	}

}
