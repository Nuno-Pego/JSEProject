package io.altar.jseproject.textInterface.states;

import java.util.Iterator;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.services.ShelfService;

public class FirstLevelMenuShelfs implements State {
	

	@Override
	public int execute() {
		// Show Shelfs:
		showShelfsInDB();
		// Show Menu:
		showMenu();
		int [] validOptions = {1,2,3,4,5};
		return SCANNER_UTILS.checkGetIntFromScannerWithRange("Select option: ", validOptions);
	}
	
	private void showMenu(){
		System.out.println("---------------WISER STOCK: Shelfs Menu---------------");
		System.out.println("--         Select one of the options bellow         --");
		System.out.println("--                                                  --");
		System.out.println("-- 1| Create new Shelf                              --");
		System.out.println("-- 2| Edit a Shelf                                  --");
		System.out.println("-- 3| See details of a Shelf                        --");
		System.out.println("-- 4| Remove a Shelf                                --");
		System.out.println("-- 5| Return to previous menu                       --");
		System.out.println("------------------------------------------------------");
	}

	private void showShelfsInDB() {
		// Initializing:
		Iterator<Shelf> shelfsIterator = ShelfService.getAllShelfs().iterator();
		// Show all Products:
		System.out.println("---------------See all Shelfs---------------");
		while (shelfsIterator.hasNext()) {
			System.out.println(shelfsIterator.next().toString());
		}
		System.out.println("--------------------------------------------");
	}
}
