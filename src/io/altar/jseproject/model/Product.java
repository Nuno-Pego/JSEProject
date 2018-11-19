package io.altar.jseproject.model;

public class Product extends Entity{
	
	private Shelf[] listShelfs;
	private double discont;
	private double iva;
	private double pvp;

	public Product(double discont, double iva, double pvp) {		
		this.discont = discont;
		this.iva = iva;
		this.pvp = pvp;
	}	

	public Shelf[] getListShelfs() {
		return listShelfs;
	}

	public void setListShelfs(Shelf[] listShelfs) {
		this.listShelfs = listShelfs;
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

}
