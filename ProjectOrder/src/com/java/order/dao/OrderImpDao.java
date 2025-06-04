package com.java.order.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.java.order.model.Item;
import com.java.order.model.Menu;
import com.java.order.model.Order;

public class OrderImpDao implements OrderDao {

	static List<Menu> menuList;
	static List<Order> orderList;
	static Item lastItemAdded;


	static {
		menuList = new ArrayList<Menu>();
		orderList = new ArrayList<Order>();
	}
	
	public static int generateMenuId() {
		if (menuList.size() ==0) 
		{
			return 1;
		}
		else {
			return menuList.get(menuList.size()-1).getMenuId() +1;
		}
	}
	public static int generateOrderId() {
		if (orderList.size() ==0) 
		{
			return 1;
		}
		else {
			return orderList.get(orderList.size()-1).getOrderId() +1;
		}
	}
	public static int generateItemId() {
		if(lastItemAdded==null) {
			return 1;
		}
		return lastItemAdded.getItemId()+1;
	}

	@Override
	public String addAnItemDao(int price, String name, int menuId) {
		
		
		Item item=new Item(generateItemId(), price, name, menuId);
		Menu menuPoin=null;
		for (Menu menu : menuList) {
			if(menu.getMenuId()==menuId) {
				menuPoin=menu;
				break;
			}
		}
		if (menuPoin != null && menuPoin.getItemList() != null) {
			menuPoin.getItemList().add(item);
			return "Item Added Successfully and itemId is "+item.getItemId();
		} else {
			return "Error: Menu with ID " + menuId + " not found.";
		}
	}
	
	@Override
	public String addAnItemDao(Item item ,int menuId) {
		Menu menuToFind=null;
		for (Menu menu : menuList) {
			if(menu.getMenuId()==menuId) {
				menuToFind=menu;
			}
		}
		menuToFind.getItemList().add(item);
		return "Item Added Successfully and itemId is ";
	}

	@Override
	public Item readAnItemDao(int itemId) {
		Item item=null;
		for (Menu menu : menuList) {
			if (menu.getItemList() != null) {
				for (Item ite : menu.getItemList()) {
					if(ite.getItemId()==itemId) {
						item=ite;
						break;
					}
				}
			}
			if (item != null) break; 
		}
		return item;
	}

	@Override
	public String updateAnItemDao(Item item) {
		Item itemtoFind=null;
		Menu menuToFind=null;
		for (Menu menu : menuList) {
			if (menu.getItemList() != null) {
				for (Item ite : menu.getItemList()) {
					if(ite.getItemId()==item.getItemId()) {
						itemtoFind=ite;
						menuToFind=menu;
						break;
					}
				}
			}
			if (itemtoFind != null) break; 
		}
		if (menuToFind != null && menuToFind.getItemList() != null && itemtoFind != null) {
			menuToFind.getItemList().remove(itemtoFind);
			menuToFind.getItemList().add(item);
			return "Item update is successful at "+menuToFind.getMenuId()+" menu id and item id is "+item.getItemId();
		} else {
			return "Error: Item with ID " + item.getItemId() + " not found.";
		}
	}

	@Override
	public String deleteAnItemDao(int itemId) {
		Item itemToFind=null;
		Menu menuToFind=null;
		for (Menu menu : menuList) {
			if (menu.getItemList() != null) {
				for (Item ite : menu.getItemList()) {
					if(ite.getItemId()==itemId) {
						itemToFind=ite;
						menuToFind=menu;
						break;
					}
				}
			}
			if (itemToFind != null) break; 
		}
		if (menuToFind != null && menuToFind.getItemList() != null && itemToFind != null) {
			menuToFind.getItemList().remove(itemToFind);
			return "Item with item id "+itemId+" is deleted";
		} else {
			return "Error: Item with ID " + itemId + " not found.";
		}
	}

	@Override
	public String addAnMenuDao(String menuName) {
		Menu menu= new Menu(generateMenuId(), new ArrayList<>(), menuName); 
		menuList.add(menu);
		return "Menu with menuid "+menu.getMenuId()+" is added to database";
	}

	@Override
	public String addItemToMenuDao(Item item ,int menuId) {
		Menu menuToFind=null;
		for (Menu menu : menuList) {
			if(menu.getMenuId()==menuId) {
				menuToFind=menu;
				break;
			}
		}
		if (menuToFind != null && menuToFind.getItemList() != null) {
			menuToFind.getItemList().add(item);
			return "item added to menu " + menuId;
		} else {
			return "Error: Menu with ID " + menuId + " not found.";
		}
	}

	@Override
	public List<Item> readAllItemsFromMenuDao(int menuId) {
		Menu menuToFind=null;
		for (Menu menu : menuList) {
			if(menu.getMenuId()==menuId) {
				menuToFind=menu;
				break;
			}
		}
		if (menuToFind != null) {
			return menuToFind.getItemList();
		} else {
			return null;
		}
	}

	@Override
	public String updateMenuDao(int menuId,String menuName) {
		Menu menuToFind=null;
		for (Menu menu : menuList) {
			if(menu.getMenuId()==menuId) {
				menuToFind=menu;
				break;
			}
		}
		if (menuToFind != null) {
			menuToFind.setMenuName(menuName);
			return "menu name updated for menu id " + menuId;
		} else {
			return "Error: Menu with ID " + menuId + " not found.";
		}
	}
	
	@Override
	public String updateMenuDao(Menu menu,String newName) {
		menu.setMenuName(newName);
		return "menu name updated ";
	}

	@Override
	public String deleteMenuDao(int menuId) {
		Menu menuToFind=null;
		for (Menu menu : menuList) {
			if(menu.getMenuId()==menuId) {
				menuToFind=menu;
				break;
			}
		}
		if (menuToFind != null) {
			menuList.remove(menuToFind);
			return "menu with id " + menuId + " is removed";
		} else {
			return "Error: Menu with ID " + menuId + " not found.";
		}
	}

	@Override
	public String placeAnOrderDao(int customerId , int quantityOrder , String orderComment , int itemId , Date orderDate ,int billAmount , Map<Integer, Integer> itemIdAndQuantityList){
		Order or=new Order(generateOrderId(), customerId, itemIdAndQuantityList, billAmount, orderComment, orderDate); // Increment here
		orderList.add(or);
		return "order placed successfully with order id " + or.getOrderId();
	}

	@Override
	public String deleteAnOrderDao(int orderId) {
		Order or=null;
		for (Order orderr : orderList) {
			if(orderr.getOrderId()==orderId) {
				or=orderr;
				break;
			}
		}
		if (or != null) {
			orderList.remove(or);
			return "order with id " + orderId + " deleted successfully";
		} else {
			return "Error: Order with ID " + orderId + " not found.";
		}
	}

	@Override
	public String placeAnOrderDao(Order order) {
		orderList.add(order);
		return "order placed bro";
	}
}