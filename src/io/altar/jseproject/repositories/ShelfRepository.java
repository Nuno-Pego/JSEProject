package io.altar.jseproject.repositories;

import java.util.ArrayList;
import java.util.Iterator;

import io.altar.jseproject.model.Shelf;

public class ShelfRepository extends EntityRepository<Shelf> {

	private static final ShelfRepository INSTANCE = new ShelfRepository();

	private ShelfRepository() {

	}

	public static ShelfRepository getInstance() {
		return INSTANCE;
	}
	
	public ArrayList<Long> getIDsWithoutProduct(){
		Iterator<Shelf> allShelfs = INSTANCE.findAll();
		ArrayList<Long> allShelfsWithoutProduct = new ArrayList<Long>();
		
		while(allShelfs.hasNext()) {
			Shelf checkShelf = allShelfs.next();
			if(checkShelf.getProduct()==null) {
				allShelfsWithoutProduct.add(checkShelf.getId());
			}
		}		
		return allShelfsWithoutProduct;
	}
}
