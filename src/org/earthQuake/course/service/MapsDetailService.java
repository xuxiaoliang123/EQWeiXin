package org.earthQuake.course.service;

import java.util.List;

import org.earthQuake.course.common.bean.MapsDetail;

public interface MapsDetailService {

	/**
	 * 得到地震图片信息
	 * @return
	 */
	public List<MapsDetail> getMaps();
	
	/**
	 * 修改地震图片信息
	 * @return
	 */
	public int updateMaps();
	
	/**
	 * 删除地震图片信息
	 * @return
	 */
	public int deleteMaps();
	
	/**
	 * 增加地震图片信息
	 * @return
	 */
	public int addMaps();
}
