package org.earthQuake.course.common.bean;

/**
 * 菜单基类
 * 
 * @author xuxiaoliang
 * @date 2014-01-14
 */

public class TabMenuDetail implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	//菜单ID
	private int menuId;
	//菜单说明
	private String menuexplain;
	//菜单内容
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
