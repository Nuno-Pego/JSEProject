package io.altar.jseproject.textInterface.states;

import io.altar.jseproject.services.ShelfService;

public class SecondLevelShelfCreate implements State {

	int capacity;
	double price;
	
	
	@Override
	public int execute() {

		ShelfService.createShelf(100, 10);
		ShelfService.createShelf(200, 30);
		ShelfService.createShelf(200, 10);
		
		
		return 1;
	}

}
