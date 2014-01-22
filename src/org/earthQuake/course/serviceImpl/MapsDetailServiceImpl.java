package org.earthQuake.course.serviceImpl;

import java.util.List;

import org.earthQuake.course.common.bean.MapsDetail;
import org.earthQuake.course.dao.MapsDetailDao;
import org.earthQuake.course.service.MapsDetailService;

public class MapsDetailServiceImpl implements MapsDetailService {

	private MapsDetailDao mapsDetailDao;
	
	public MapsDetailDao getMapsDetailDao() {
		return mapsDetailDao;
	}

	public void setMapsDetailDao(MapsDetailDao mapsDetailDao) {
		this.mapsDetailDao = mapsDetailDao;
	}

	@Override
	public List<MapsDetail> getMaps() {
		return mapsDetailDao.getMaps();
	}

	@Override
	public int updateMaps() {
		return mapsDetailDao.updateMaps();
	}

	@Override
	public int deleteMaps() {
		return mapsDetailDao.deleteMaps();
	}

	@Override
	public int addMaps() {
		return 0;
	}

}
