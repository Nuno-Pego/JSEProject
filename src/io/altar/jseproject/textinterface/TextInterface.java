package io.altar.jseproject.textinterface;

import java.util.Scanner;

import io.altar.jseproject.model.Product;

public class TextInterface {

	public void userInterface() {

		System.out.println("Por favor seleccione uma das opções:");
		System.out.println("1) Listar productos");
		System.out.println("2) Listar prateleiras");
		System.out.println("3) Sair");

		Scanner scan = new Scanner(System.in);
		int userChoice = scan.nextInt();
		scan.close();

		switch (userChoice) {
		case 1:
			productOptions();
			break;
		case 2:
			shelfOptions();
			break;
		case 3:
			break;
		default:
			System.out.println("Erro! Escolha outra opção por favor");
			userInterface();
			break;

		}
	}
	
//---------------------------------------------------------------------------------------
	private void productOptions() {

		System.out.println("Por favor seleccione uma das opções:");
		System.out.println("1) Criar novo producto");
		System.out.println("2) Editar um produto existente");
		System.out.println("3) Consultar o detalhe de um produto");
		System.out.println("4) Remover um produto");
		System.out.println("5) Voltar ao ecrã anterior");

		Scanner scan = new Scanner(System.in);
		int userChoice = scan.nextInt();
		scan.close();

		switch (userChoice) {
		case 1:
			Scanner scann = new Scanner(System.in);

			System.out.println("Insira Desconto");
			double discount = scann.nextDouble();
			System.out.println("Insira IVA");
			double iva = scann.nextDouble();
			System.out.println("Insira PVP");
			double pvp = scann.nextDouble();
			
			scann.close();
			
			Product newProduct = new Product(discount,iva,pvp); 

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
	}

//---------------------------------------------------------------------------------------
	
	private void shelfOptions() {

		System.out.println("Por favor seleccione uma das opções:");
		System.out.println("1) Criar nova prateleira");
		System.out.println("2) Editar uma prateleira existente");
		System.out.println("3) Consultar o detalhe de uma prateleira");
		System.out.println("4) Remover uma prateleira");
		System.out.println("5) Voltar ao ecrã anterior");

		Scanner scan = new Scanner(System.in);
		int userChoice = scan.nextInt();
		scan.close();

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
	}
}
