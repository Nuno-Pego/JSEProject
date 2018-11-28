package io.altar.jseproject.textinterface.states;

import java.util.Iterator;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.services.ShelfService;

public class ShelfsMenu implements State{

	@Override
	public int execute() {
		showShelfs();

		showMenu();

		int[] validOptions = { 1, 2, 3, 4, 5 };
		return SCANNERUTILS.checkGetIntFromScannerWithRange("Select option: ", validOptions);
	}
	
	public void showMenu() {		
		System.out.println("1) Create shelf");
		System.out.println("2) Edit shelf");
		System.out.println("3) Inspect shelf");
		System.out.println("4) Delete shelf");
		System.out.println("5) Back");
		System.out.println("");
	}
	
	private void showShelfs() {	
		Iterator<Shelf> prodIterator = ShelfService.getAllShelfs();
		
		while (prodIterator.hasNext()) {
			System.out.println(prodIterator.next().toString());
		}
	}
	
}
