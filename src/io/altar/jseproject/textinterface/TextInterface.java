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
		long inputID;

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
			productOptions();
			break;
		case 2:

			if (prodRep.emptyData() == true) {
				System.out.println("No product");
				productOptions();
			} else {
				System.out.println("Product ID?");
				value = scan.nextLine();				
/////////////////////////////				
				do{
				value=invalidInput(value,"Long");				
				}while(checkIdExistenceProducts(value)==false);
				
				inputID = Long.parseLong(value);
				Product oldProduct = prodRep.findById(inputID);
				
				System.out.println("New Discount " + "{" + oldProduct.getDiscont() + "}");
				value = scan.nextLine();
				if (value.equals("")) {
				} else {				
					discount = Double.parseDouble(invalidInput(value, "Double"));
					oldProduct.setDiscont(discount);
				}

				System.out.println("New IVA " + "{" + oldProduct.getIva() + "}");
				value = scan.nextLine();
				if (value.equals("")) {
				} else {				
					iva = Double.parseDouble(invalidInput(value, "Double"));
					oldProduct.setIva(iva);
				}					
				
				System.out.println("New PVP " + oldProduct.getPvp());
				value = scan.nextLine();
				if (value.equals("")) {
				} else {				
					pvp = Double.parseDouble(invalidInput(value, "Double"));
					oldProduct.setPvp(pvp);
				}	
				
				System.out.println("Product Edited");
				productOptions();
			}
			break;
		case 3:
			if (prodRep.emptyData() == true) {
				System.out.println("No product");
				productOptions();
			} else {
				System.out.println("product ID?");
				value = scan.nextLine();
				while (checkType(value, "Long") == false || checkIdExistenceProducts(value) == false) {
					System.out.println("Invalid, try again:");
					value = scan.nextLine();
				}
				Long consultID = Long.parseLong(value);
				Product oldProduct = prodRep.findById(consultID);
				System.out.println(oldProduct.toString());
				System.out.println("");
				System.out.println("Press Enter to back");
				value = scan.next();
				while (!value.equals("")) {
					value = scan.nextLine();
				}
				if (value.equals("")) {
					productOptions();
				}
			}
			break;
		case 4:
			if (prodRep.emptyData() == true) {
				System.out.println("No product");
				productOptions();
			} else {
				System.out.println("Product ID");
				value = scan.nextLine();
				while (checkType(value, "Long") == false || checkIdExistenceProducts(value) == false) {
					System.out.println("Invalid, try again:");
					value = scan.nextLine();
				}
				Long deleteID = Long.parseLong(value);
				Product oldProduct = prodRep.findById(deleteID);
				System.out.println("Are you sure, you want to delete this product? " + oldProduct.toString());
				System.out.println("y/n");
				String userAnswer = scan.nextLine();

				while (!userAnswer.equals("y") && !userAnswer.equals("n")) {
					System.out.println("Invalid, try again:");
					userAnswer = scan.nextLine();
				}
				if (userAnswer.equals("y")) {
					prodRep.removeById(deleteID);
					System.out.println("Product deleted");
					productOptions();
				} else if (userAnswer.equals("n")) {
					productOptions();
				}
			}
			break;
		case 5:
			userInterface();
			break;
		default:
			System.out.println("Error! Choose another option please");
			productOptions();
			break;
		}

		scan.close();

	}

	// SHELF INTERFACE

	private void shelfOptions() {
		Iterator<Shelf> shefIterator = shelfRep.findAll();
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

		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine();
		int userChoice = checkType(value, "Int") ? Integer.parseInt(value) : 10;

		switch (userChoice) {
		case 1:
			System.out.println("Input Capacity (nº)");
			value = scan.nextLine();
			while (checkType(value, "Int") == false) {
				System.out.println("Invalid, try again:");
				value = scan.nextLine();
			}
			int capacity = Integer.parseInt(value);

			System.out.println("Input renting price ($/day)");
			value = scan.nextLine();
			while (checkType(value, "Double") == false) {
				System.out.println("Invalid, try again:");
				value = scan.nextLine();
			}
			double price = Double.parseDouble(value);

			Shelf newShelf = new Shelf(capacity, price);
			shelfRep.save(newShelf);
			System.out.println("Shelf added");
			if (prodRep.emptyData() == true) {
				shelfOptions();
			} else {
				System.out.println("");
				System.out.println("Add product to a shelf?");
				System.out.println("Choose product ID or press Enter to ignore");
				value = scan.nextLine();
				while ((checkType(value, "Long") == false && !value.equals("")
						&& checkIdExistenceShelfs(value) == false)) {
					System.out.println("Invalid, try again:");
					value = scan.nextLine();
				}
				if (value.equals("")) {
					shelfOptions();
				} else {
					Long consultId = Long.parseLong(value);
					newShelf.setProduct(prodRep.findById(consultId));
					System.out.println("Product added");
					shelfOptions();
				}
			}

			break;
		case 2:
			if (shelfRep.emptyData() == true) {
				System.out.println("No shelfs");
				shelfOptions();
			} else {
				System.out.println("Shelf ID?");
				value = scan.nextLine();
				while (checkType(value, "Long") == false || checkIdExistenceShelfs(value) == false) {
					System.out.println("Invalid, try again:");
					value = scan.nextLine();
				}
				long editID = Long.parseLong(value);

				Shelf oldShelf = shelfRep.findById(editID);

				System.out.println("New Capacity " + oldShelf.getCapacity());
				value = scan.nextLine();
				if (value.equals("")) {

				} else {
					while (checkType(value, "Int") == false) {
						System.out.println("Invalid, try again:");
						value = scan.nextLine();
					}

					int editCapacity = Integer.parseInt(value);
					oldShelf.setCapacity(editCapacity);

				}

				System.out.println("New renting price " + oldShelf.getPrice());
				value = scan.nextLine();
				if (value.equals("")) {

				} else {
					while (checkType(value, "Double") == false) {
						System.out.println("Invalid, try again:");
						value = scan.nextLine();
					}
					Double editPrice = Double.parseDouble(value);
					oldShelf.setPrice(editPrice);
				}

				System.out.println("Shelf edited");
				shelfOptions();
			}
			break;
		case 3:
			if (shelfRep.emptyData() == true) {
				System.out.println("No shelfs");
				shelfOptions();
			} else {
				System.out.println("Shelf ID?");
				value = scan.nextLine();
				while (checkType(value, "Long") == false || checkIdExistenceShelfs(value) == false) {
					System.out.println("Invalid, try again:");
					value = scan.nextLine();
				}
				Long consultID = Long.parseLong(value);
				Shelf oldShelf = shelfRep.findById(consultID);
				System.out.println(oldShelf.toString());
				System.out.println("");
				System.out.println("Press Enter to back");
				value = scan.next();
				while (!value.equals("")) {
					value = scan.nextLine();
				}
				if (value.equals("")) {
					shelfOptions();
				}
			}
			break;
		case 4:
			if (shelfRep.emptyData() == true) {
				System.out.println("No shelfs");
				shelfOptions();
			} else {
				System.out.println("Product ID?");
				value = scan.nextLine();
				while (checkType(value, "Long") == false || checkIdExistenceShelfs(value) == false) {
					System.out.println("Invalid, try again:");
					value = scan.nextLine();
				}
				Long deleteID = Long.parseLong(value);
				Shelf oldShelf = shelfRep.findById(deleteID);
				System.out.println("Are you sure, you want to delete this shelf? " + oldShelf.toString());
				System.out.println("y/n");
				String userAnswer = scan.nextLine();

				while (!userAnswer.equals("y") && !userAnswer.equals("n")) {
					System.out.println("Invalid, try again:");
					userAnswer = scan.nextLine();
				}
				if (userAnswer.equals("y")) {
					shelfRep.removeById(deleteID);
					System.out.println("Shelf deleted");
					shelfOptions();
				} else if (userAnswer.equals("n")) {
					shelfOptions();
				}
			}
			break;
		case 5:
			userInterface();
			break;
		default:
			System.out.println("Error! Choose another option please");
			shelfOptions();
			break;
		}

		scan.close();
	}

	// ---------------------------------------------------------------------------------------------------------------------------------

	// Methods
	private boolean checkIdExistenceProducts(String id) {
		if (prodRep.findById(Long.parseLong(id)) != null)
			return true;
		else {
			return false;
		}

	}

	private boolean checkIdExistenceShelfs(String id) {
		if (shelfRep.findById(Long.parseLong(id)) != null)
			return true;
		else {
			System.out.println("This ID dont exists");
			return false;
		}

	}

	private String invalidInput(String value, String match) {
		while (checkType(value, match) == false) {
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
