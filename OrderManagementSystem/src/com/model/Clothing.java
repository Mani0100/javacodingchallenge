package com.model;

import java.util.Objects;

public class Clothing extends Product{
	private String size;
	private String color;
	public Clothing(int productId, String productName, String description, double price, int quantityInStock,
			String type, String size, String color) {
		super(productId, productName, description, price, quantityInStock, type);
		this.size = size;
		this.color = color;
	}
	public Clothing() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Clothing(int productId, String productName, String description, double price, int quantityInStock,
			String type) {
		super(productId, productName, description, price, quantityInStock, type);
		// TODO Auto-generated constructor stub
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Clothing [size=" + size + ", color=" + color + ", getSize()=" + getSize() + ", getColor()=" + getColor()
				+ ", getProductId()=" + getProductId() + ", getProductName()=" + getProductName()
				+ ", getDescription()=" + getDescription() + ", getPrice()=" + getPrice() + ", getQuantityInStock()="
				+ getQuantityInStock() + ", getType()=" + getType() + ", toString()=" + super.toString()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(color, size);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clothing other = (Clothing) obj;
		return Objects.equals(color, other.color) && Objects.equals(size, other.size);
	}
	

}
