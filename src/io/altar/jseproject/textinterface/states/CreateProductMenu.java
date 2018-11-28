package io.altar.jseproject.textinterface.states;

import java.util.ArrayList;

public class CreateProductMenu implements State {

	@Override
	public int execute() {
		
		showMenu();

		return 0;
	}
	
	public void showMenu() {
		
		int discount, iva;
		int [] rangeIvas = {6,12,23};
		double pvp;
		ArrayList<Long> shelfsIDs;
		
		
		SCANNERUTILS.checkGetIntFromScanner("Input Discount (%)");
		SCANNERUTILS.checkGetIntFromScannerWithRange("Input IVA (6%, 12%, 23%)", rangeIvas);
		SCANNERUTILS.checkGetDoubleFromScanner("Input PVP ($)");		
	
	
	}

}
