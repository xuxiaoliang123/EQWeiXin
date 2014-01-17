package org.earthQuake.course.common.bean;

/**
 * �˵�����
 * 
 * @author xuxiaoliang
 * @date 2014-01-14
 */

public class TabMenuDetail implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	//�˵�ID
	private int menuId;
	//�˵�˵��
	private String menuexplain;
	//�˵�����
	private String menuContent;
	
	/** default constructor */
	public TabMenuDetail() {
	}

	/** full constructor */
	public TabMenuDetail(int menuId, String menuexplain, String menuContent) {
		super();
		this.menuId = menuId;
		this.menuexplain = menuexplain;
		this.menuContent = menuContent;
	}

	public String getMenuexplain() {
		return menuexplain;
	}

	public void setMenuexplain(String menuexplain) {
		this.menuexplain = menuexplain;
	}

	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuContent() {
		return menuContent;
	}
	public void setMenuContent(String menuContent) {
		this.menuContent = menuContent;
	}
}
