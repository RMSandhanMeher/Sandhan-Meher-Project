package com.java.order.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.java.order.model.Item;
import com.java.order.model.Menu;
import com.java.order.model.Order;

public interface OrderDao {
	
//	functions for items 
	public String addAnItemDao(int price, String name,int menuId);
	public String addAnItemDao(Item item ,int menuId);
	public Item readAnItemDao(int itemId);
	public String updateAnItemDao(Item item);
	public String deleteAnItemDao(int itemId);

//	functions for menu
	public String addAnMenuDao(String menuName);
	public String addItemToMenuDao(Item item ,int menuId);
	public List<Item> readAllItemsFromMenuDao(int menuId);
	public String updateMenuDao(int menuId,String menuName);
	public String updateMenuDao(Menu menu,String newName);
	public String deleteMenuDao(int menuId);
	
// function for order
	public String placeAnOrderDao(int customerId , int quantityOrder , String orderComment , int itemId , Date orderDate ,int billAmount ,  Map<Integer, Integer> itemIdAndQuantityList);
	public String placeAnOrderDao(Order order);
	public String deleteAnOrderDao(int orderId);

}
