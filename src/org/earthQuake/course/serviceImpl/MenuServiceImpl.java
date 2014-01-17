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
	 * �޸Ĳ˵�
	 * @return
	 */
	public int updateMenus(){
		return menuDao.updateMenus();
	}
	
	/**
	 * ɾ���˵�
	 * @return
	 */
	public int deleteMenu(){
		return menuDao.deleteMenu();
	}
	
	/**
	 * �õ��˵�
	 * @return
	 */
	public List<TabMenuDetail> getMenus(){
		return menuDao.getMenus();
	}
}
