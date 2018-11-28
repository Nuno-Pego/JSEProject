package io.altar.jseproject.textinterface.states;

import java.util.Iterator;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.services.ProductService;

public class ProductsMenu implements State{

	@Override
	public int execute() {
		showProducts();

		showMenu();

		int[] validOptions = { 1, 2, 3, 4, 5 };
		return SCANNERUTILS.checkGetIntFromScannerWithRange("Select option: ", validOptions);
	}

	public void showMenu() {		
		System.out.println("1) Create Product");
		System.out.println("2) Edit Product");
		System.out.println("3) Inspect Product");
		System.out.println("4) Delete Product");
		System.out.println("5) Back");
		System.out.println("");
	}

	private void showProducts() {		
		Iterator<Product> prodIterator = ProductService.getAllProducts();
		
		while (prodIterator.hasNext()) {
			System.out.println(prodIterator.next().toString());
		}
	}
}
