package com.java.order.model;

import java.util.Date;
import java.util.Map;

public class Order {
	
	private int orderId;
	private int customerId;
	private Map<Integer,Integer> itemIdAndQuantityList;
	private int billAmount;
	private String orderComment;
	private Date orderDate;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public Map<Integer, Integer> getItemIdAndQuantityList() {
		return itemIdAndQuantityList;
	}
	public void setItemIdAndQuantityList(Map<Integer, Integer> itemIdAndQuantityList) {
		this.itemIdAndQuantityList = itemIdAndQuantityList;
	}
	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	public String getOrderComment() {
		return orderComment;
	}
	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerId=" + customerId + ", itemIdAndQuantityList="
				+ itemIdAndQuantityList + ", billAmount=" + billAmount + ", orderComment=" + orderComment
				+ ", orderDate=" + orderDate + "]";
	}
	public Order(int orderId, int customerId, Map<Integer, Integer> itemIdAndQuantityList, int billAmount,
			String orderComment, Date orderDate) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.itemIdAndQuantityList = itemIdAndQuantityList;
		this.billAmount = billAmount;
		this.orderComment = orderComment;
		this.orderDate = orderDate;
	}
}
