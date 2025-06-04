package com.java.order.bal;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.java.order.Exception.OrderException;
import com.java.order.dao.OrderImpDao;
import com.java.order.model.Item;
import com.java.order.model.Order;

public class OrderBal {
	
	static OrderImpDao orderImpDao;
	static StringBuilder sc;
	static {
		orderImpDao=new OrderImpDao();
		sc=new StringBuilder();
	}
	
	public String addAnItemBal(int price, String name,int menuId) {
		Item item=new Item(OrderImpDao.generateItemId(), price, name, menuId);
		return orderImpDao.addAnItemDao(item, menuId);
	}
	public Item  readAnItemBal(int itemId) {
		return  orderImpDao.readAnItemDao( itemId);
	}
	public String updateAnItemBal(Item item) {
		return orderImpDao.updateAnItemDao(item);
	}
	public String deleteAnItemBal(int itemId) {
		return orderImpDao.deleteAnItemDao( itemId);
	}
	
	
	public String addAnMenuBal(String menuName) {
		return orderImpDao.addAnMenuDao(menuName);
	}
	public String addItemToMenuBal(Item item ,int menuId) {
		return orderImpDao.addItemToMenuDao(item , menuId);
	}
	public List<Item> readAllItemsFromMenuBal(int menuId){
		return orderImpDao.readAllItemsFromMenuDao(menuId);
	}
	public String updateMenuBal(int menuId,String menuName) {
		return orderImpDao.updateMenuDao(menuId,menuName);
	}
	public String deleteMenuBal(int menuId) {
		return orderImpDao.deleteMenuDao(menuId);
	}
	
	
	public String placeAnOrderBal(int customerId , int quantityOrder , String orderComment , int itemId , Date orderDate ,int billAmount ,  Map<Integer, Integer> itemIdAndQuantityList) {
		return orderImpDao.placeAnOrderDao(customerId , quantityOrder , orderComment , itemId , orderDate , billAmount , itemIdAndQuantityList);
	}
	public String placeAnOrderBal(Order order) {
		return 	orderImpDao.placeAnOrderDao( order);
	}
	public String deleteAnOrderBal(int orderId) {
		return 	orderImpDao.deleteAnOrderDao(orderId);
	}

	public boolean validation(Order order) throws OrderException {
		boolean verify=true;
		if(!order.getOrderDate().before(new Date())) {
			verify=false;
			throw new OrderException("order date should not be past ");
		}
		return verify;
	}
}
