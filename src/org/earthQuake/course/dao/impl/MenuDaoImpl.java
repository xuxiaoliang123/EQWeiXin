package org.earthQuake.course.dao.impl;

import java.util.List;

import org.earthQuake.course.common.bean.TabMenuDetail;
import org.earthQuake.course.dao.BaseDao;
import org.earthQuake.course.dao.MenuDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuDaoImpl extends BaseDao implements MenuDao{

	public Logger log = LoggerFactory.getLogger(MenuDaoImpl.class);
	/**
	 * 得到菜单
	 * @return
	 */
	public List<TabMenuDetail> getMenus() {
		Session session = getSession();
		Query query = session.createQuery("from TabMenuDetail order by menuid");
		List<TabMenuDetail> list = query.list();
		close(session);
		return list;
	}

	@Override
	public int updateMenus() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

}
