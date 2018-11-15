package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.model.Product;

public class TextInterface {

	public static void userInterface() {

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
	private static void productOptions() {

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

			System.out.println("Producto adicionado");
			productOptions();

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
			productOptions();
			break;
		}

		scan.close();
	}

	// ---------------------------------------------------------------------------------------

	private static void shelfOptions() {

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

	private static boolean checkType(String value, String typeMatch) {

		try {
			switch (typeMatch) {
			case "Int":
				Integer.parseInt(value);
				break;
			case "Double":
				Double.parseDouble(value);
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
