package io.altar.jseproject.textinterface.states;

import io.altar.jseproject.services.ShelfService;

public class CreateShelfMenu implements State {
	
	int capacity; 
	double price;

	@Override
	public int execute() {
		// TODO Auto-generated method stub
		
		ShelfService.createShelf(100, 10);
		ShelfService.createShelf(200, 20);
		ShelfService.createShelf(300, 30);
		
		return 1;
	}

}
