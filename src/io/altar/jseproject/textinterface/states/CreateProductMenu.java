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

			String userAnswer = SCANNERUTILS.checkGetStringFromScanner("Do you want to add to a Shelf? (y/n)");

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
		ArrayList<Long> shelfsIDs = new ArrayList<Long>();
		long id;
		do {
			id = SCANNERUTILS.checkGetLongFromScannerWithRange("Input Shelf ID (Press Enter to ignore)", rageShelfsIDs,
					true);
			if(id!=-1) {
			rageShelfsIDs.remove(rageShelfsIDs.indexOf(id));
			shelfsIDs.add(id);			
			}
		} while (id != -1 && !rageShelfsIDs.isEmpty());

		ProductService.createProduct(shelfsIDs, discount, iva, pvp);
		
		for (int i = 0; i < shelfsIDs.size(); i++) {
			long IdShelf = shelfsIDs.get(i);
			
			ShelfService.addProductToShelf(ShelfService.getShelfById(IdShelf), ProductService.getCurrentID());
		}
	}
}
