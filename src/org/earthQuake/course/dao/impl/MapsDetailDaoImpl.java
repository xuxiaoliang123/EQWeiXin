package org.earthQuake.course.dao.impl;

import java.util.List;

import org.earthQuake.course.common.bean.MapsDetail;
import org.earthQuake.course.dao.BaseDao;
import org.earthQuake.course.dao.MapsDetailDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MapsDetailDaoImpl extends BaseDao implements MapsDetailDao{

	public Logger log = LoggerFactory.getLogger(MapsDetailDaoImpl.class);
	@Override
	public List<MapsDetail> getMaps() {
		Session session = getSession();
		Query query = session.createQuery("from MapsDetail");
		List<MapsDetail> list = query.list();
		close(session);
		return list;
	}

	@Override
	public int updateMaps() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMaps() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addMaps() {
		// TODO Auto-generated method stub
		return 0;
	}

}
