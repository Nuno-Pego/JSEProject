package io.altar.jseproject.model;

import java.util.ArrayList;

public class Product extends Entity {

	// Attributes
	private ArrayList<Long> listShelfs;
	private int discont;
	private int iva;
	private double pvp;

	// Constructor
	public Product(int discont, int iva, double pvp) {
		this.listShelfs = new ArrayList<Long>();
		this.discont = discont;
		this.iva = iva;
		this.pvp = pvp;

	}
	
	public Product(ArrayList <Long> listShelfs, int discont, int iva, double pvp) {
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

	public void setDiscont(int discont) {
		this.discont = discont;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(int iva) {
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
