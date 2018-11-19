package io.altar.jseproject.model;

public class Shelf extends Entity {
	
	private int capacity;
	private Product product;
	private double price;

	public Shelf(int capacity, Product product, double price) {		
		this.capacity = capacity;
		this.product = product;
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
