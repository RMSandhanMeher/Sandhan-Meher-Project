package com.java.order.main;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.java.order.Exception.OrderException;
import com.java.order.bal.OrderBal;
import com.java.order.model.Item;
import com.java.order.model.Order;

public class Main {

    private static OrderBal orderBal ;
    private static Scanner scanner ;
    private static int itemIdCounter = 1;
    private static int menuIdCounter = 1;
    private static int orderIdCounter = 1;
    
    static {
    	 orderBal = new OrderBal();
    	 scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n Order Management System - Bengaluru, India (" + new Date() + ")");
            System.out.println("--------------------------------------------------");
            System.out.println("1. Add an Item to a Menu");
            System.out.println("2. Read an Item");
            System.out.println("3. Update an Item");
            System.out.println("4. Delete an Item");
            System.out.println("5. Add a Menu");
            System.out.println("6. Add Item to a Menu (Existing Menu)");
            System.out.println("7. Read All Items from a Menu");
            System.out.println("8. Update a Menu Name");
            System.out.println("9. Delete a Menu");
            System.out.println("10. Place an Order");
            System.out.println("11. Delete an Order");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    readItem();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    addMenu();
                    break;
                case 6:
                    addItemToExistingMenu();
                    break;
                case 7:
                    readAllItemsFromMenu();
                    break;
                case 8:
                    updateMenu();
                    break;
                case 9:
                    deleteMenu();
                    break;
                case 10:
				try {
					placeOrder();
				} catch (OrderException e) {
					e.printStackTrace();
				}
                    break;
                case 11:
                    deleteOrder();
                    break;
                case 12:
                    running = false;
                    System.out.println("Exiting the Order Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void addItem() {
        System.out.println("\n--- Add New Item ---");
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Menu ID to add this item to: ");
        int menuId = scanner.nextInt();
        scanner.nextLine(); 

        String result = orderBal.addAnItemBal(price, itemName, menuId);
        System.out.println(result);
        itemIdCounter++;
    }

    private static void readItem() {
        System.out.println("\n--- Read Item ---");
        System.out.print("Enter item ID to read: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); 

        Item item = orderBal.readAnItemBal(itemId);
        if (item != null) {
            System.out.println("Item details: " + item);
        } else {
            System.out.println("Item with ID " + itemId + " not found.");
        }
    }

    private static void updateItem() {
        System.out.println("\n--- Update Item ---");
        System.out.print("Enter item ID to update: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); 

        Item existingItem = orderBal.readAnItemBal(itemId);
        if (existingItem == null) {
            System.out.println("Item with ID " + itemId + " not found.");
            return;
        }

        System.out.print("Enter new item name (" + existingItem.getItemName() + "): ");
        String itemName = scanner.nextLine();
        System.out.print("Enter new item price (" + existingItem.getPrice() + "): ");
        int price = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter new Menu ID (" + existingItem.getMenuId() + "): ");
        int menuId = scanner.nextInt();
        scanner.nextLine(); 

        Item updatedItem = new Item(itemId, price, itemName, menuId);
        String result = orderBal.updateAnItemBal(updatedItem);
        System.out.println(result);
    }

    private static void deleteItem() {
        System.out.println("\n--- Delete Item ---");
        System.out.print("Enter item ID to delete: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); 

        String result = orderBal.deleteAnItemBal(itemId);
        System.out.println(result);
    }

    private static void addMenu() {
        System.out.println("\n--- Add New Menu ---");
        System.out.print("Enter menu name: ");
        String menuName = scanner.nextLine();

        String result = orderBal.addAnMenuBal(menuName);
        System.out.println(result);
        menuIdCounter++;
    }

    private static void addItemToExistingMenu() {
        System.out.println("\n--- Add Item to Existing Menu ---");
        System.out.print("Enter Menu ID to add item to: ");
        int menuId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter item price: ");
        int price = scanner.nextInt();
        scanner.nextLine(); 

        Item newItem = new Item(itemIdCounter++, price, itemName, menuId);
        String result = orderBal.addItemToMenuBal(newItem, menuId);
        System.out.println(result);
    }

    private static void readAllItemsFromMenu() {
        System.out.println("\n--- Read All Items from Menu ---");
        System.out.print("Enter Menu ID to view items: ");
        int menuId = scanner.nextInt();
        scanner.nextLine(); 

        List<Item> items = orderBal.readAllItemsFromMenuBal(menuId);
        if (items != null && !items.isEmpty()) {
            System.out.println("Items in Menu ID " + menuId + ":");
            for (Item item : items) {
                System.out.println("- " + item);
            }
        } else {
            System.out.println("No items found in Menu ID " + menuId + " or the menu does not exist.");
        }
    }

    private static void updateMenu() {
        System.out.println("\n--- Update Menu Name ---");
        System.out.print("Enter Menu ID to update: ");
        int menuId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new menu name: ");
        String menuName = scanner.nextLine();

        String result = orderBal.updateMenuBal(menuId, menuName);
        System.out.println(result);
    }

    private static void deleteMenu() {
        System.out.println("\n--- Delete Menu ---");
        System.out.print("Enter Menu ID to delete: ");
        int menuId = scanner.nextInt();
        scanner.nextLine(); 

        String result = orderBal.deleteMenuBal(menuId);
        System.out.println(result);
    }

    private static void placeOrder() throws OrderException {
        System.out.println("\n--- Place New Order ---");
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); 

        Map<Integer, Integer> itemIdAndQuantityList = new HashMap<>();
        boolean addingItems = true;
        while (addingItems) {
            System.out.print("Enter item ID to order (or 0 to finish): ");
            int itemId = scanner.nextInt();
            scanner.nextLine(); 
            if (itemId == 0) {
                addingItems = false;
            } else {
                System.out.print("Enter quantity for item " + itemId + ": ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                itemIdAndQuantityList.put(itemId, quantity);
            }
        }

        System.out.print("Enter order comment (optional): ");
        String orderComment = scanner.nextLine();

      
        int billAmount = 0;
        for (Map.Entry<Integer, Integer> entry : itemIdAndQuantityList.entrySet()) {
            Item item = orderBal.readAnItemBal(entry.getKey());
            if (item != null) {
                billAmount += item.getPrice() * entry.getValue();
            } else {
                System.out.println("Warning: Item with ID " + entry.getKey() + " not found, not included in bill.");
            }
        }
        System.out.println("Enter date of order in yyyy-mm-dd : ");
        String date=scanner.next();
        
        Date orderDate = new Date();
        Order newOrder = new Order(orderIdCounter++, customerId, itemIdAndQuantityList, billAmount, orderComment, orderDate);

        if (orderBal.validation(newOrder)) {
            String result = orderBal.placeAnOrderBal(newOrder);
            System.out.println(result + ". Order ID is " + newOrder.getOrderId());
        } else {
            System.out.println("Order date is invalid (cannot be in the past). Order not placed.");
        }
    }

    private static void deleteOrder() {
        System.out.println("\n--- Delete Order ---");
        System.out.print("Enter order ID to delete: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); 

        String result = orderBal.deleteAnOrderBal(orderId);
        System.out.println(result);
    }
}