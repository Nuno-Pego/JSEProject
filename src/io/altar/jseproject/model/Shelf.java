package io.altar.jseproject.model;

public class Shelf {

	private int id;
	private int capacity;
	private Product product;
	private double price;

	public Shelf(int id, int capacity, Product product, double price) {
		this.id = id;
		this.capacity = capacity;
		this.product = product;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
