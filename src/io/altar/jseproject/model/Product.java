package io.altar.jseproject.model;

import java.util.ArrayList;

public class Product extends Entity {

	// Attributes
	private ArrayList<Long> listShelfs;
	private double discont;
	private double iva;
	private double pvp;

	// Constructor
	public Product(double discont, double iva, double pvp) {
		this.listShelfs = new ArrayList<Long>();
		this.discont = discont;
		this.iva = iva;
		this.pvp = pvp;

	}

	// Getters and Setters

	public ArrayList<Long> getListShelfs() {
		return listShelfs;
	}

	public void setListShelfs(Long id) {
		this.listShelfs.add(id);
	}

	public double getDiscont() {
		return discont;
	}

	public void setDiscont(double discont) {
		this.discont = discont;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}

	// toString
	@Override
	public String toString() {

		if (listShelfs == null) {
			return "Product " + this.getId() + " [discont=" + discont + "%" + ", iva=" + iva + "%" + ", pvp=" + pvp
					+ "$" + "]";
		} else {

			return "Product " + this.getId() + " [discont=" + discont + "%" + ", iva=" + iva + "%" + ", pvp=" + pvp
					+ "$ " + this.listShelfs.toString() + "]";
		}
	}

}
