package org.earthQuake.course.service;

import java.util.List;

import org.earthQuake.course.common.bean.MapsDetail;

public interface MapsDetailService {

	/**
	 * �õ�����ͼƬ��Ϣ
	 * @return
	 */
	public List<MapsDetail> getMaps();
	
	/**
	 * �޸ĵ���ͼƬ��Ϣ
	 * @return
	 */
	public int updateMaps();
	
	/**
	 * ɾ������ͼƬ��Ϣ
	 * @return
	 */
	public int deleteMaps();
	
	/**
	 * ���ӵ���ͼƬ��Ϣ
	 * @return
	 */
	public int addMaps();
}
