package com.model;

import java.util.Objects;

public class Electronics extends Product{

	private String brand;
	private int warrantyPeriod;
	public Electronics(int productId, String productName, String description, double price, int quantityInStock,
			String type, String brand, int warrantyPeriod) {
		super(productId, productName, description, price, quantityInStock, type);
		this.brand = brand;
		this.warrantyPeriod = warrantyPeriod;
	}
	public Electronics() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Electronics(int productId, String productName, String description, double price, int quantityInStock,
			String type) {
		super(productId, productName, description, price, quantityInStock, type);
		// TODO Auto-generated constructor stub
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getWarrantyPeriod() {
		return warrantyPeriod;
	}
	public void setWarrantyPeriod(int warrantyPeriod) {
		this.warrantyPeriod = warrantyPeriod;
	}
	@Override
	public String toString() {
		return "Electronics [brand=" + brand + ", warrantyPeriod=" + warrantyPeriod + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(brand, warrantyPeriod);
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
		Electronics other = (Electronics) obj;
		return Objects.equals(brand, other.brand) && warrantyPeriod == other.warrantyPeriod;
	}
	
}
