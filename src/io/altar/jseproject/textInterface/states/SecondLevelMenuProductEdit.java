package io.altar.jseproject.textInterface.states;

import java.util.ArrayList;
import java.util.Iterator;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.services.ProductService;

public class SecondLevelMenuProductEdit implements State{

	// Attributes:
	private ArrayList<Long> rangeIDsExist = ProductService.getAllProductsIDs();
	private int discount, iva;
	private double pvp;
	
	@Override
	public int execute() {
		// Show all exist Products ID's
		showProductsInDB();
		
		// Show Menu
		showMenu();
		
		return 0;
	}
	
	private void showMenu() {
		int [] rangeIvas = {6,12,23};
		System.out.println("--------------WISER STOCK: Products Menu--------------");
		System.out.println("--                  Edit a Product                  --");
		long id = SCANNER_UTILS.checkGetLongFromScannerWithRange("Input product ID (press Enter to exit): ", rangeIDsExist, true);
		Product editProduct = ProductService.getProductById(id);
		discount = SCANNER_UTILS.checkGetIntFromScannerWithMax("Input discount (%) (" + editProduct.getDiscountPrice() + ") " + " : ", 100, true);		
		iva = SCANNER_UTILS.checkGetIntFromScannerWithRange("Input IVA (6% , 12% and 23%) (" + editProduct.getIva() + ") " + " : ", rangeIvas, true);
		pvp = SCANNER_UTILS.checkGetDoubleFromScanner("Input price ($) (" + editProduct.getPvp() + ") " + " : ", true);
		
		
		
		if (discount!=-1) {
			editProduct.setDiscountPrice(discount);
		}
		if (iva!=-1) {
			editProduct.setIva(iva);
		}
		if (pvp!=-1) {
			editProduct.setPvp(pvp);
		}
		
		
		
		
	}
	
	private void showProductsInDB(){
		// Initializing:
		Iterator<Long> productIDsIterator = ProductService.getAllProductsIDs();
		// Show all Products:
		System.out.println("--------------See all Products--------------");
		long id;
		while (productIDsIterator.hasNext()) {
				id = productIDsIterator.next();
				System.out.print(id + " ");
				rangeIDsExist.add(id);
		}
		System.out.println("--------------------------------------------");
	}

}
