package com.model;

import java.util.Objects;

public class Orders {

	private int productId;
	private int userId;
	private int ordersId;
	private String productName;
	private String userName;
	public Orders(int productId, int userId, int ordersId, String productName, String userName) {
		super();
		this.productId = productId;
		this.userId = userId;
		this.ordersId = ordersId;
		this.productName = productName;
		this.userName = userName;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public String toString() {
		return "Orders [productId=" + productId + ", userId=" + userId + ", ordersId=" + ordersId + ", productName="
				+ productName + ", userName=" + userName + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(ordersId, productId, productName, userId, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		return ordersId == other.ordersId && productId == other.productId
				&& Objects.equals(productName, other.productName) && userId == other.userId
				&& Objects.equals(userName, other.userName);
	}
	
}
