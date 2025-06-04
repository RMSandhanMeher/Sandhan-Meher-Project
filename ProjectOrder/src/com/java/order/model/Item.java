package com.java.order.model;

public class Item {
	private int itemId;
	private int price;
	private String itemName;
	private int menuId;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", price=" + price + ", itemName=" + itemName + ", menuId=" + menuId + "]";
	}
	public Item(int itemId, int price, String itemName, int menuId) {
		super();
		this.itemId = itemId;
		this.price = price;
		this.itemName = itemName;
		this.menuId = menuId;
	}
	
}
