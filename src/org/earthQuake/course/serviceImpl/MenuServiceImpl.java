package org.earthQuake.course.serviceImpl;

import java.util.List;

import org.earthQuake.course.common.bean.TabMenuDetail;
import org.earthQuake.course.dao.MenuDao;
import org.earthQuake.course.service.MenuService;

public class MenuServiceImpl implements MenuService{
	private MenuDao menuDao;
	
	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	/**
	 * 修改菜单
	 * @return
	 */
	public int updateMenus(){
		return menuDao.updateMenus();
	}
	
	/**
	 * 删除菜单
	 * @return
	 */
	public int deleteMenu(){
		return menuDao.deleteMenu();
	}
	
	/**
	 * 得到菜单
	 * @return
	 */
	public List<TabMenuDetail> getMenus(){
		return menuDao.getMenus();
	}
}
