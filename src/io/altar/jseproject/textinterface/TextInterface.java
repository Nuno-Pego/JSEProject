package io.altar.jseproject.textinterface;

import java.util.Iterator;
import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.model.Shelf;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class TextInterface {

	// Initializing
	ProductRepository prodRep = ProductRepository.getInstance();
	ShelfRepository shelfRep = ShelfRepository.getInstance();

	Scanner scan = new Scanner(System.in);

	// Attributes
	String value;
	int userChoice;
	long inputID;
	String userConfirmation;
	Shelf oldShelf;
	Product oldProduct;
	

	// MAIN INTERFACE
	public void userInterface() {

		System.out.println("Choose an option please:");
		System.out.println("1) Products");
		System.out.println("2) Shelfs");
		System.out.println("3) Exit");

		value = scan.nextLine();
		userChoice = checkType(value, "Int") ? Integer.parseInt(value) : 10;

		switch (userChoice) {
		case 1:
			productOptions();
			break;
		case 2:
			shelfOptions();
			break;
		case 3:
			System.out.println("--Programm terminated!--");
			break;
		default:
			System.out.println("Error! Choose another option please");
			userInterface();
			break;
		}

		scan.close();
	}

	// PRODUCTS INTERFACE
	private void productOptions() {

		// Initializing
		Iterator<Product> prodIterator = prodRep.findAll();

		// Attributes
		double discount;
		double iva;
		double pvp;

		System.out.println("");
		while (prodIterator.hasNext()) {
			System.out.println(prodIterator.next().toString());
		}
		System.out.println("");

		System.out.println("Choose an option please:");
		System.out.println("1) Create Product");
		System.out.println("2) Edit Product");
		System.out.println("3) Inspect Product");
		System.out.println("4) Delete Product");
		System.out.println("5) Back");

		value = scan.nextLine();
		userChoice = checkType(value, "Int") ? Integer.parseInt(value) : 10;

		switch (userChoice) {
		case 1:
			System.out.println("Input Discount (%)");
			value = scan.nextLine();
			discount = Double.parseDouble(invalidInput(value, "Double"));

			System.out.println("Input IVA (%)");
			value = scan.nextLine();
			iva = Double.parseDouble(invalidInput(value, "Double"));

			System.out.println("Input PVP ($)");
			value = scan.nextLine();
			pvp = Double.parseDouble(invalidInput(value, "Double"));

			Product newProduct = new Product(discount, iva, pvp);
			prodRep.save(newProduct);
			System.out.println("Product added");

			/////////// Shelf to Product

			productOptions();
			break;
		case 2:			
				oldProduct = prodRep.findById(validIdProduct());

				System.out.println("New Discount " + "{" + oldProduct.getDiscont() + "%}");
				value = scan.nextLine();
				if (value.equals("")) {
				} else {
					discount = Double.parseDouble(invalidInput(value, "Double"));
					oldProduct.setDiscont(discount);
				}

				System.out.println("New IVA " + "{" + oldProduct.getIva() + "%}");
				value = scan.nextLine();
				if (value.equals("")) {
				} else {
					iva = Double.parseDouble(invalidInput(value, "Double"));
					oldProduct.setIva(iva);
				}

				System.out.println("New PVP " + "{" + oldProduct.getPvp() + "$}");
				value = scan.nextLine();
				if (value.equals("")) {
				} else {
					pvp = Double.parseDouble(invalidInput(value, "Double"));
					oldProduct.setPvp(pvp);
				}
				System.out.println("Product Edited");

				/////////// Edit Shelf

				productOptions();			
			break;
		case 3:			
				oldProduct = prodRep.findById(validIdProduct());

				System.out.println(oldProduct.toString());
				System.out.println("");
				System.out.println("Press Enter to back");
				value = scan.nextLine();

				productOptions();			
			break;
		case 4:			
				oldProduct  = prodRep.findById(validIdProduct());
				deleteConfirmationProducts();				
			break;
		case 5:
			userInterface();
			break;
		default:
			System.out.println("Error! Choose another option please");
			productOptions();
			break;
		}

	}

	// SHELF INTERFACE

	private void shelfOptions() {
		// Initializing
		Iterator<Shelf> shefIterator = shelfRep.findAll();
		// Attributes
		int capacity;
		double price;

		System.out.println("");
		while (shefIterator.hasNext()) {
			System.out.println(shefIterator.next().toString());
		}
		System.out.println("");

		System.out.println("Choose an option please:");
		System.out.println("1) Create shelf");
		System.out.println("2) Edit shelf");
		System.out.println("3) Inspect shelf");
		System.out.println("4) Delete shelf");
		System.out.println("5) Back");

		value = scan.nextLine();
		userChoice = checkType(value, "Int") ? Integer.parseInt(value) : 10;

		switch (userChoice) {
		case 1:
			System.out.println("Input Capacity (Number)");
			value = scan.nextLine();
			capacity = Integer.parseInt(invalidInput(value, "Int"));

			System.out.println("Input renting price ($/day)");
			value = scan.nextLine();
			price = Double.parseDouble(invalidInput(value, "Double"));

			Shelf newShelf = new Shelf(capacity, price);
			shelfRep.save(newShelf);
			System.out.println("Shelf added");
			
			addProductToShelf(newShelf);
			
			break;
		case 2:		
				oldShelf = shelfRep.findById(validIdShef());

				System.out.println("New Capacity " + "{" + oldShelf.getCapacity() + "}");
				value = scan.nextLine();
				if (value.equals("")) {
				} else {
					capacity = Integer.parseInt(invalidInput(value, "Int"));
					oldShelf.setCapacity(capacity);
				}

				System.out.println("New renting price " + oldShelf.getPrice());
				value = scan.nextLine();
				if (value.equals("")) {
				} else {
					price = Double.parseDouble(invalidInput(value, "Double"));
					oldShelf.setPrice(price);
				}

				/////////// Edit Product

				System.out.println("Shelf edited");
				shelfOptions();			
			break;
		case 3:			
				oldShelf = shelfRep.findById(validIdShef());

				System.out.println(oldShelf.toString());
				System.out.println("");
				System.out.println("Press Enter to back");
				value = scan.nextLine();

				productOptions();			
			break;
		case 4:		
				oldShelf = shelfRep.findById(validIdShef());
				deleteConfirmationShelfs();				
			break;
		case 5:
			userInterface();
			break;
		default:
			System.out.println("Error! Choose another option please");
			shelfOptions();
			break;
		}		
	}

	// ---------------------------------------------------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------------------------------------------------	
	// Methods
	
	private void addProductToShelf(Shelf newShelf) {
		if (prodRep.emptyData() == true) {
			shelfOptions();
		} else {
			System.out.println("");
			System.out.println("Add product to a shelf?");
			System.out.println("Choose product ID or press Enter to ignore");
			value = scan.nextLine();

			if (!value.equals("")) {
				value = invalidInputEnter(value, "Long");
				while (!value.equals("") && checkIdExistenceProducts(value) == false) {
					value = scan.nextLine();
					if (!value.equals("")) {
						value = invalidInputEnter(value, "Long");
					} else {
						break;
					}
				}
			}
			if (value.equals("")) {
				shelfOptions();
			} else {
				inputID = Long.parseLong(value);
				newShelf.setProduct(prodRep.findById(inputID));
				System.out.println("Product added");
				shelfOptions();
			}
		}
	}

	private long validIdProduct() {
		if (prodRep.emptyData() == true) {
			System.out.println("No product");
			productOptions();
		} else {
			System.out.println("Product ID?");
			value = scan.nextLine();
			value = invalidInput(value, "Long");
			while (checkIdExistenceProducts(value) == false) {
				value = scan.nextLine();
				value = invalidInput(value, "Long");
			}
			inputID = Long.parseLong(value);
		}
			return inputID;			
	}	

	private long validIdShef() {
		if (shelfRep.emptyData() == true) {
			System.out.println("No shelfs");
			shelfOptions();
		} else {
			System.out.println("Shelf ID?");
			value = scan.nextLine();
			value = invalidInput(value, "Long");
			while (checkIdExistenceShelfs(value) == false) {
				value = scan.nextLine();
				value = invalidInput(value, "Long");
			}
			inputID = Long.parseLong(value);
	}
		return inputID;
	}
	
	private boolean checkIdExistenceProducts(String id) {
		if (prodRep.findById(Long.parseLong(id)) != null)
			return true;
		else {
			System.out.println("ID dont exists, try again:");
			return false;
		}
	}

	private boolean checkIdExistenceShelfs(String id) {
		if (shelfRep.findById(Long.parseLong(id)) != null)
			return true;
		else {
			System.out.println("ID dont exists, try again:");
			return false;
		}
	}
	
	private void deleteConfirmationProducts() {
		System.out.println("Are you sure, you want to delete this product? " + oldProduct.toString());
		System.out.println("y/n");
		userConfirmation = scan.nextLine();

		while (!userConfirmation.equals("y") && !userConfirmation.equals("n")) {
			System.out.println("Invalid, try again:");
			userConfirmation = scan.nextLine();
		}
		if (userConfirmation.equals("y")) {
			prodRep.removeById(inputID);
			System.out.println("Product deleted");
			productOptions();
		} else if (userConfirmation.equals("n")) {
			productOptions();
		}			
	}
	
	private void deleteConfirmationShelfs() {
		System.out.println("Are you sure, you want to delete this shelf? " + oldShelf.toString());
		System.out.println("y/n");
		userConfirmation = scan.nextLine();

		while (!userConfirmation.equals("y") && !userConfirmation.equals("n")) {
			System.out.println("Invalid, try again:");
			userConfirmation = scan.nextLine();
		}
		if (userConfirmation.equals("y")) {
			shelfRep.removeById(inputID);
			System.out.println("Shelf deleted");
			shelfOptions();
		} else if (userConfirmation.equals("n")) {
			shelfOptions();
		}			
	}

	private String invalidInput(String value, String match) {
		while (checkType(value, match) == false) {
			System.out.println("Invalid, try again:");
			value = scan.nextLine();
		}
		return value;
	}

	private String invalidInputEnter(String value, String match) {
		while (!value.equals("") && checkType(value, match) == false) {
			System.out.println("Invalid, try again:");
			value = scan.nextLine();
		}
		return value;
	}

	private boolean checkType(String value, String typeMatch) {

		try {
			switch (typeMatch) {
			case "Int":
				Integer.parseInt(value);
				break;
			case "Double":
				Double.parseDouble(value);
				break;
			case "Long":
				Long.parseLong(value);
				break;
			default:
				break;
			}

		} catch (Exception e) {
			return false;
		}
		return true;
	}
}

// private <T extends Number> T checkType(String value, Function<String, T>
// operation) {
// return operation.apply(value);
// }
