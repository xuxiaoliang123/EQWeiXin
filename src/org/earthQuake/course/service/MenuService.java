package org.earthQuake.course.service;

import java.util.List;

import org.earthQuake.course.common.bean.TabMenuDetail;
import org.earthQuake.course.dao.MenuDao;

public interface MenuService {
	
	/**
	 * 修改菜单
	 * @return
	 */
	public int updateMenus();
	
	/**
	 * 删除菜单
	 * @return
	 */
	public int deleteMenu();
	
	/**
	 * 得到菜单
	 * @return
	 */
	public List<TabMenuDetail> getMenus();
}
