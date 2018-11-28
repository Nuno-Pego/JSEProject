package io.altar.jseproject.textinterface.states;

public class MainMenu implements State{

	@Override
	public int execute() {
		showMenu();
		
		int[] validOptions = {1,2,3};
		return SCANNERUTILS.checkGetIntFromScannerWithRange("Select option: ", validOptions);
	}
	
	public void showMenu() {		
		System.out.println("1) Products");
		System.out.println("2) Shelfs");
		System.out.println("3) Exit");
		System.out.println("");		
	}	
}
