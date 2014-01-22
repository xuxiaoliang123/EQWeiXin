package org.earthQuake.course.common.bean;

import java.util.Date;

/**
 * 地图图片基类
 * @author xuxiaoliang
 * @date 2014-01-19
 */
public class MapsDetail {

	//地图ID
	private int mapid;
	//图片
	private String image;
	//时间
	private Date time;
	//地点
	private String address;
	//经度
	private int longitude;
	//纬度
	private int latitude;
	//震级
	private int magnitude;
	//震中烈度
	private int intensity;
	//震源深度
	private double depth;
	
	/**
	 * default constructor
	 */
	public MapsDetail() {
	}
	
	/**
	 * full constructor
	 * @param mapid
	 * @param image
	 * @param time
	 * @param address
	 * @param longitude
	 * @param latitude
	 * @param magnitude
	 * @param intensity
	 * @param depth
	 */
	public MapsDetail(int mapid, String image, Date time, String address,
			int longitude, int latitude, int magnitude, int intensity,
			double depth) {
		super();
		this.mapid = mapid;
		this.image = image;
		this.time = time;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
		this.magnitude = magnitude;
		this.intensity = intensity;
		this.depth = depth;
	}
	
	public int getMapid() {
		return mapid;
	}

	public void setMapid(int mapid) {
		this.mapid = mapid;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getMagnitude() {
		return magnitude;
	}
	public void setMagnitude(int magnitude) {
		this.magnitude = magnitude;
	}
	public int getIntensity() {
		return intensity;
	}
	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}
	
}
