package io.altar.jseproject.textInterface.states;

public class FirstLevelMenu implements State {

	@Override
	public int execute() {
		// Show Menu:
		showMenu();
		
		int[] validOptions = {1,2,3};
		return SCANNER_UTILS.checkGetIntFromScannerWithRange("Select option: ", validOptions);			
	}
	
	public void showMenu(){
		System.out.println("----------------------WISER STOCK---------------------");
		System.out.println("--         Select one of the options bellow         --");
		System.out.println("--                                                  --");
		System.out.println("-- 1| Show Products                                 --");
		System.out.println("-- 2| Show Shelfs                                   --");
		System.out.println("-- 3| Exit                                          --");
		System.out.println("------------------------------------------------------");
		System.out.println("");
	}

}
