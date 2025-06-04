package com.java.order.model;

import java.util.List;

public class Menu {
	
	private int menuId;
	private List<Item> itemList;
	private String menuName;
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", itemList=" + itemList + ", menuName=" + menuName + "]";
	}
	public Menu(int menuId, List<Item> itemList, String menuName) {
		super();
		this.menuId = menuId;
		this.itemList = itemList;
		this.menuName = menuName;
	}	
}
