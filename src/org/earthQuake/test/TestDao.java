package org.earthQuake.test;

import java.util.List;

import org.earthQuake.course.common.bean.TabMenuDetail;
import org.earthQuake.course.dao.impl.MenuDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

public class TestDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		MenuDao user = new MenuDaoImpl();
//		MenuService us = new MenuServiceImpl();
//        
//        List<MenuBean> list = us.getMenus();
//        int i;
//        StringBuffer sbf = new StringBuffer();
//        for(i = 0; i < list.size(); i++){
//        	MenuBean menu = (MenuBean)list.get(i);
//        	if(null != menu.getMenuexplain()){
//        		sbf.append(menu.getMenuexplain());
//        	}else{
//        		sbf.append(menu.getMenuContent());
//        	}
//        }
		//spring ����
		ApplicationContext act=new FileSystemXmlApplicationContext("classpath:applicationContext.xml");
		MenuDaoImpl MenuDaoImpl=(MenuDaoImpl)act.getBean("menuDao"); //�������spring�����ļ��е����õ����id
		List<TabMenuDetail> menu = MenuDaoImpl.getMenus();
		TabMenuDetail m = menu.get(1);
		System.out.println(m.getMenuContent());
		//hibernate����
//		Configuration cfg = new Configuration().configure();
//		  SchemaExport se = new SchemaExport(cfg);
//		  se.create(true, true);
	}

}
