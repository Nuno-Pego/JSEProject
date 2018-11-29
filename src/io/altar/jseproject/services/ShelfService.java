package io.altar.jseproject.services;

import java.util.ArrayList;
import java.util.Iterator;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public class ShelfService {

	
private static final ShelfRepository SHELFREPOSITORY = ShelfRepository.getInstance();
	
	public static void createShelf(int capacity, double price) {
		Shelf newShelf = new Shelf(capacity, price);
		SHELFREPOSITORY.save(newShelf);
	}
	
	public static void createShelf (Long productIDs, int capacity, double price) {
		Shelf newShelf = new Shelf(productIDs,capacity,price);
		SHELFREPOSITORY.save(newShelf);
	}
	
	public static Shelf getShelfById(Long id) {
		Shelf searchShelf = SHELFREPOSITORY.findById(id);
		return searchShelf;
	}
	
	public static void editShelf (Shelf editShelf) {
		SHELFREPOSITORY.save(editShelf);
	}
	
	public static boolean isEmpty() {
		return SHELFREPOSITORY.emptyData();
	}
	
	public static Iterator<Shelf> getAllShelfs(){
		return SHELFREPOSITORY.findAll();
	}

	public static Iterator<Long> getAllShelfsIDs(){
		return SHELFREPOSITORY.getAllIDs();
	}
	
	public static ArrayList<Long> getAllShelfsIDsWithoutProduct() {
		return SHELFREPOSITORY.getIDsWithoutProduct();
	}
	
	public static void removeShelf(long id) {
		SHELFREPOSITORY.removeById(id);
	}
	
}
