package io.altar.jseproject.textInterface.states;

import java.util.Iterator;
import io.altar.jseproject.model.Product;
import io.altar.jseproject.services.ProductService;

public class FirstLevelMenuProducts implements State {

	@Override
	public int execute() {
		// Show Products:
		showProductsInDB();
		// Show Menu:
		showMenu();
		int [] validOptions = {1,2,3,4,5};
		return SCANNER_UTILS.checkGetIntFromScannerWithRange("Select option: ", validOptions);
	}
	
	private void showMenu(){
		System.out.println("--------------WISER STOCK: Products Menu--------------");
		System.out.println("--         Select one of the options bellow         --");
		System.out.println("--                                                  --");
		System.out.println("-- 1| Create new Product                            --");
		System.out.println("-- 2| Edit a Product                                --");
		System.out.println("-- 3| See details of a Product                      --");
		System.out.println("-- 4| Remove a Product                              --");
		System.out.println("-- 5| Return to previous menu                       --");
		System.out.println("------------------------------------------------------");
	}
	
	private void showProductsInDB(){
		// Initializing:
		Iterator<Product> productIterator = ProductService.getAllProducts();
		// Show all Products:
		System.out.println("--------------See all Products--------------");
		while (productIterator.hasNext()) {
				System.out.println(productIterator.next().toString());
		}
		System.out.println("--------------------------------------------");
	}
	

}
