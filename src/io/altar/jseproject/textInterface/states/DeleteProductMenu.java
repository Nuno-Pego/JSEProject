package io.altar.jseproject.textInterface.states;

import java.util.ArrayList;

import io.altar.jseproject.services.ProductService;

public class DeleteProductMenu implements State {

	// Attributes:
		
	
	@Override
	public int execute() {
		// TODO Auto-generated method stub
		
		if(!ProductService.isEmpty()) {
			showMenu();
		}
				
		return 1;
	}
	
	private void showMenu() {
	ArrayList<Long> rangeIDsExist = new ArrayList<Long>(ProductService.getAllProductsIDs());
	System.out.println("--------------WISER STOCK: Products Menu--------------");
	System.out.println("--               Delete Product               --");
	System.out.println();
	System.out.println(rangeIDsExist.toString());
	Long id = SCANNER_UTILS.checkGetLongFromScannerWithRange("Select an ID to delete: ", rangeIDsExist, true);
	
	
	if(id != -1) {		
		ProductService.removeProduct(id);		
	}
	
	}
}
