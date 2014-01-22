package org.earthQuake.course.dao;

import java.util.List;

import org.earthQuake.course.common.bean.TabMenuDetail;

public interface MenuDao {
	/**
	 * 得到菜单
	 * @return
	 */
	public List<TabMenuDetail> getMenus();
	
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
}
