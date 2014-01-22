package org.earthQuake.course.dao;

import java.util.List;

import org.earthQuake.course.common.bean.TabMenuDetail;

public interface MenuDao {
	/**
	 * �õ��˵�
	 * @return
	 */
	public List<TabMenuDetail> getMenus();
	
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
}
