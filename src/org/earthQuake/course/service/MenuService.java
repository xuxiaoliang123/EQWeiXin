package org.earthQuake.course.service;

import java.util.List;

import org.earthQuake.course.common.bean.TabMenuDetail;
import org.earthQuake.course.dao.MenuDao;

public interface MenuService {
	
	/**
	 * �޸Ĳ˵�
	 * @return
	 */
	public int updateMenus();
	
	/**
	 * ɾ���˵�
	 * @return
	 */
	public int deleteMenu();
	
	/**
	 * �õ��˵�
	 * @return
	 */
	public List<TabMenuDetail> getMenus();
}
