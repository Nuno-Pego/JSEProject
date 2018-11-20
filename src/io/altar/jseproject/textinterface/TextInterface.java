package io.altar.jseproject.textinterface;

import java.util.Iterator;
import java.util.Scanner;

import io.altar.jseproject.model.Product;
import io.altar.jseproject.repositories.ProductRepository;
import io.altar.jseproject.repositories.ShelfRepository;

public class TextInterface {
	ProductRepository prodRep = ProductRepository.getInstance();
	ShelfRepository shelfRep = ShelfRepository.getInstance();

	public void userInterface() {

		System.out.println("Por favor seleccione uma das opções:");
		System.out.println("1) Listar productos");
		System.out.println("2) Listar prateleiras");
		System.out.println("3) Sair");

		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine();
		int userChoice = checkType(value, "Int") ? Integer.parseInt(value) : 10;

		switch (userChoice) {
		case 1:
			productOptions();
			break;
		case 2:
			shelfOptions();
			break;
		case 3:
			System.out.println("Programa Terminado!");
			break;
		default:
			System.out.println("Erro! Escolha outra opção por favor");
			userInterface();
			break;
		}

		scan.close();
	}

	// ---------------------------------------------------------------------------------------
	private void productOptions() {

		Iterator<Product> prodIterator = prodRep.findAll();

		while (prodIterator.hasNext()) {
			System.out.println(prodIterator.next().toString());
		}

		System.out.println("Por favor seleccione uma das opções:");
		System.out.println("1) Criar novo producto");
		System.out.println("2) Editar um produto existente");
		System.out.println("3) Consultar o detalhe de um produto");
		System.out.println("4) Remover um produto");
		System.out.println("5) Voltar ao ecrã anterior");

		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine();
		int userChoice = checkType(value, "Int") ? Integer.parseInt(value) : 10;

		switch (userChoice) {
		case 1:

			System.out.println("Insira Desconto");
			value = scan.nextLine();
			while (checkType(value, "Double") == false) {
				System.out.println("Inválido, tente novamente:");
				value = scan.nextLine();
			}
			double discount = Double.parseDouble(value);

			System.out.println("Insira IVA");
			value = scan.nextLine();
			while (checkType(value, "Double") == false) {
				System.out.println("Inválido, tente novamente:");
				value = scan.nextLine();
			}
			double iva = Double.parseDouble(value);

			System.out.println("Insira PVP");
			value = scan.nextLine();
			while (checkType(value, "Double") == false) {
				System.out.println("Inválido, tente novamente:");
				value = scan.nextLine();
			}
			double pvp = Double.parseDouble(value);

			Product newProduct = new Product(discount, iva, pvp);
			prodRep.save(newProduct);

			System.out.println("Producto adicionado");
			productOptions();

			break;
		case 2:
			System.out.println("Insira o ID do produto a editar");
			value = scan.nextLine();
			while (checkType(value, "Long") == false || checkIdExistence(value) == false) {
				System.out.println("Inválido, tente novamente:");
				value = scan.nextLine();
			}
			long editID = Long.parseLong(value);

			Product oldProduct = prodRep.findById(editID);

			System.out.println("Input Discount " + oldProduct.getDiscont());
			value = scan.nextLine();
			if (value.equals("")) {

			} else {
				while (checkType(value, "Double") == false) {
					System.out.println("Inválido, tente novamente:");
					value = scan.nextLine();
				}

				Double editDiscount = Double.parseDouble(value);
				oldProduct.setDiscont(editDiscount);

			}

			System.out.println("Input IVA " + oldProduct.getIva());
			value = scan.nextLine();
			if (value.equals("")) {

			} else {
				while (checkType(value, "Double") == false) {
					System.out.println("Inválido, tente novamente:");
					value = scan.nextLine();
				}
				Double editIva = Double.parseDouble(value);
				oldProduct.setIva(editIva);
			}

			System.out.println("Input PVP " + oldProduct.getPvp());

			value = scan.nextLine();
			if (value.equals("")) {

			} else {
				while (checkType(value, "Double") == false) {
					System.out.println("Inválido, tente novamente:");
					value = scan.nextLine();
				}
				Double editPvp = Double.parseDouble(value);
				oldProduct.setPvp(editPvp);
			}
			System.out.println("Producto Editado");
			productOptions();

			break;
		case 3:
			System.out.println("Insira o ID do produto a consultar");
			value = scan.nextLine();
			while (checkType(value, "Long") == false || checkIdExistence(value) == false) {
				System.out.println("Inválido, tente novamente:");
				value = scan.nextLine();
			}
			Long consultID = Long.parseLong(value);
			oldProduct = prodRep.findById(consultID);
			System.out.println(oldProduct.toString());

			// productOptions();

			break;
		case 4:
			System.out.println("Insira o ID do produto a consultar");
			value = scan.nextLine();
			while (checkType(value, "Long") == false || checkIdExistence(value) == false) {
				System.out.println("Inválido, tente novamente:");
				value = scan.nextLine();
			}
			Long deleteID = Long.parseLong(value);
			oldProduct = prodRep.findById(deleteID);
			System.out.println("Tem a certeza que quer eliminar este produto? " + oldProduct.toString());
			System.out.println("y/n");
			String userAnswer = scan.nextLine();

			while (!userAnswer.equals("y")   && !userAnswer.equals("n") ) {
				System.out.println("Inválido, tente novamente:");
				value = scan.nextLine();
			}
			if (userAnswer.equals("y") ) {
				prodRep.removeById(deleteID);
				System.out.println("Produto Removido");
				productOptions();
			} else if (userAnswer.equals("n")) {
				productOptions();
			}
			break;
		case 5:
			userInterface();
			break;
		default:
			System.out.println("Erro! Escolha outra opção por favor");
			productOptions();
			break;
		}

		scan.close();

	}

	// ---------------------------------------------------------------------------------------

	private void shelfOptions() {

		System.out.println("Por favor seleccione uma das opções:");
		System.out.println("1) Criar nova prateleira");
		System.out.println("2) Editar uma prateleira existente");
		System.out.println("3) Consultar o detalhe de uma prateleira");
		System.out.println("4) Remover uma prateleira");
		System.out.println("5) Voltar ao ecrã anterior");

		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine();
		int userChoice = checkType(value, "Int") ? Integer.parseInt(value) : 10;

		switch (userChoice) {
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:
			userInterface();
			break;
		default:
			System.out.println("Erro! Escolha outra opção por favor");
			shelfOptions();
			break;
		}

		scan.close();
	}

	// ---------------------------------------------------------------------------------------
	// ---------------------------------------------------------------------------------------

	private boolean checkIdExistence(String id) {
		if (prodRep.findById(Long.parseLong(id)) != null)
			return true;
		else {
			return false;
		}

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
