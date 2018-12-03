package io.altar.jseproject.services;

import java.util.ArrayList;
import java.util.Iterator;

import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ShelfRepository;

public class ShelfService {

	// Initializing;
	private static final ShelfRepository SHELF_REPOSITORY = ShelfRepository.getInstance();
	
	//
	public static void addProductToShelf(Shelf shelf, long idProduct){
		shelf.setProduct(ProductService.getProductById(idProduct));
		//SHELF_REPOSITORY.updateByID(shelf);
	}
	
	// Create Shelf
	public static void createShelf(int capacity, float price) {
		Shelf newShelf = new Shelf(capacity, price);
		SHELF_REPOSITORY.save(newShelf);
	}
	
	public static void createShelf (Long productIDs, int capacity, float price) {
		Shelf newShelf = new Shelf(productIDs,capacity,price);
		SHELF_REPOSITORY.save(newShelf);
	}
	
	// Get size of Data
	public static int getSizeOfData(){
		return SHELF_REPOSITORY.lenghtData();				
	}
	
	// Get Shelf by ID
	public static Shelf getShelfById(Long id) {
		Shelf searchShelf = SHELF_REPOSITORY.findByID(id);
		return searchShelf;
	}
	
	// Edit Shelf
	public static void editShelf (Shelf editShelf) {
		SHELF_REPOSITORY.save(editShelf);
	}
	
	// Check if Shelf Repository is empty
	public static boolean isEmpty() {
		return SHELF_REPOSITORY.isEmpty();
	}
	
	// Get all Shelfs
	public static ArrayList<Shelf> getAllShelfs(){
		return SHELF_REPOSITORY.getAll();
	}

	// Get all Shelfs ID's
	public static ArrayList<Long> getAllShelfsIDs(){
		return SHELF_REPOSITORY.getAllIDs();
	}
	
	// Get all Shelfs ID's without products
	public static ArrayList<Long> getAllShelfsIDsWithoutProduct(){
		return SHELF_REPOSITORY.getIDsWithoutProduct();
	}
	
	// Remove Shelf
	public static void removeShelf(long id) {
		SHELF_REPOSITORY.removeByID(id);
	}

}
