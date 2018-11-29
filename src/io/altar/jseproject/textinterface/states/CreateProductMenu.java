package io.altar.jseproject.textinterface.states;

import java.util.ArrayList;

import io.altar.jseproject.services.ProductService;
import io.altar.jseproject.services.ShelfService;

public class CreateProductMenu implements State {

	int discount, iva;	
	double pvp;
	
	@Override
	public int execute() {

		showMenu();

		return 1;
	}

	public void showMenu() {
		
		int[] rangeIvas = { 6, 12, 23 };

		discount = SCANNERUTILS.checkGetIntFromScannerWithMax("Input Discount (%)", 100);
		iva = SCANNERUTILS.checkGetIntFromScannerWithRange("Input IVA (6%, 12%, 23%)", rangeIvas);
		pvp = SCANNERUTILS.checkGetDoubleFromScanner("Input PVP ($)");

		if (!ShelfService.getAllShelfsIDsWithoutProduct().isEmpty()) {

			String userAnswer = SCANNERUTILS.checkGetStringFromScanner("Do you want to add to a Shelf?");

			if (userAnswer.equals("y")) {
				addToShelf();
			} else {
				ProductService.createProduct(discount, iva, pvp);
			}
		} else {
			ProductService.createProduct(discount, iva, pvp);
		}
	}

	public void addToShelf() {
		ArrayList<Long> rageShelfsIDs = ShelfService.getAllShelfsIDsWithoutProduct();
		 
		long id;
		do {
			id = SCANNERUTILS.checkGetLongFromScannerWithRange("Input Shelf ID (Press Enter to ignore)", rageShelfsIDs,
					true);			
			rageShelfsIDs.remove(rageShelfsIDs.indexOf(id));
		} while (id != -1 || !rageShelfsIDs.isEmpty());		
	}
}
