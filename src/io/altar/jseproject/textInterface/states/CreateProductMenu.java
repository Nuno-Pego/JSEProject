package io.altar.jseproject.textInterface.states;


import java.util.ArrayList;

import io.altar.jseproject.services.ProductService;
import io.altar.jseproject.services.ShelfService;

public class CreateProductMenu implements State {
	
	// Attributes:
	private int discount, iva;
	private double pvp;
	
	
	@Override
	public int execute() {
		// Show Menu:
		showMenu();
		
		return 1;
	}
	
	private void showMenu(){
		int [] rangeIvas = {6,12,23};
		System.out.println("--------------WISER STOCK: Products Menu--------------");
		System.out.println("--               Create a new Product               --");
		
		discount = SCANNER_UTILS.checkGetIntFromScannerWithMax("Input discount (%) : ", 100);
		iva = SCANNER_UTILS.checkGetIntFromScannerWithRange("Input IVA (6% , 12% and 23%) : ", rangeIvas);
		pvp = SCANNER_UTILS.checkGetDoubleFromScanner("Input price ($) : ");
		
		if (!ShelfService.getAllShelfsIDsWithoutProduct().isEmpty()){
			// ask if want to add product to a shelf
			String answer = SCANNER_UTILS.checkGetYesOrNoAnswer("Do you want to add this product to a Shelf? (y/n)");
			if (answer.equals("y")) {
				addToShelf();	
			} else { ProductService.createProduct(discount, iva, pvp); }
		} else { ProductService.createProduct(discount, iva, pvp); }
	}
	
	private void addToShelf(){		
		ArrayList<Long> rangeShelfsIDs = new ArrayList<Long>(ShelfService.getAllShelfsIDsWithoutProduct());		
		ArrayList<Long> shelfsToProduct = new ArrayList<Long>();
		long id;
		
		do{
			id = SCANNER_UTILS.checkGetLongFromScannerWithRange("Input Shelf ID (press Enter to exit): ", rangeShelfsIDs, true);
			if (id !=-1){
				rangeShelfsIDs.remove(rangeShelfsIDs.indexOf(id));
				shelfsToProduct.add(id);	
			}
		}while (id != -1 && !rangeShelfsIDs.isEmpty());
		
		ProductService.createProduct(shelfsToProduct, discount, iva, pvp);
		
		for (int i = 0; i < shelfsToProduct.size(); i++) {
			long idShelf = shelfsToProduct.get(i);
			ShelfService.addProductToShelf(ShelfService.getShelfById(idShelf),ProductService.getActualID());
			
		}
		
	}
	
}
