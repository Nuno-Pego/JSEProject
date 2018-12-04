package io.altar.jseproject.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

//Import:
import io.altar.jseproject.model.Shelf;

//Class Shelf Repository that Extends to DataBase - Singleton
public class ShelfRepository extends EntityRepository<Shelf> {

	// Instance:
	private final static ShelfRepository INSTANCE = new ShelfRepository();
	
	// Constructor:
	private ShelfRepository(){	
	}
	
	// Get:
	public static ShelfRepository getInstance(){
		return INSTANCE;
	}
	
	// Get ID's without Product
	public Collection<Long> getIDsWithoutProduct(){
		Iterator <Shelf> allShelfs = INSTANCE.getAll().iterator();
		ArrayList<Long> allShelfsWithoutProduct = new ArrayList<Long>();
		
		while(allShelfs.hasNext()){
			Shelf checkShelf = allShelfs.next();
			if (checkShelf.getProduct()==null) {
				allShelfsWithoutProduct.add(checkShelf.getId());
			}
		}
		return allShelfsWithoutProduct;
	}
	
	
}
