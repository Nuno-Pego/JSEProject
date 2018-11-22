package io.altar.jseproject.model;

public class Shelf extends Entity {

	// Attributes
	private int capacity;
	private Product product;
	private double price;

	// Constructor
	public Shelf(int capacity, double price) {
		this.capacity = capacity;
		this.price = price;
	}

	// Getters and Setters
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
		this.product.setListShelfs(this.getId());
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	// toString
	@Override
	public String toString() {
		if (this.getProduct() == null) {
			return "Shelf " + this.getId() + " [capacity=" + capacity + ", price=" + price + "$]";
		} else {
			return "Shelf " + this.getId() + " [capacity=" + capacity + ", price=" + price + "$" + " | "
					+ this.getProduct().toString() + "]";
		}
	}

}
