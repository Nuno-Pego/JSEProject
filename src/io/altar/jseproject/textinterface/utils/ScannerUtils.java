package io.altar.jseproject.textInterface.utils;

import java.util.ArrayList;
import java.util.Scanner;

public class ScannerUtils {
	
	// Initializing:
	private Scanner scanner = new Scanner(System.in);
	
	// Interaction with user, get yes or no answer - return answer
	public String checkGetYesOrNoAnswer(String message){
		String userInput;
		do{
			System.out.println(message);
			userInput= scanner.nextLine();
		} while (!userInput.equals("y")&&!userInput.equals("n"));
		return userInput;
	}

	// Interaction with user checking input - return double value
	public double checkGetDoubleFromScanner (String message, boolean canBeNull){
		String userInput;
		do {
			System.out.println(message);
			userInput = scanner.nextLine();
			if (canBeNull && userInput.equals("")) {
				return -1;
			}
		} while (!isType(userInput, "Double"));
		return Double.parseDouble(userInput); 
	}
		
	public double checkGetDoubleFromScanner(String message){
		return checkGetDoubleFromScanner(message, false);
	}
	
	// Interaction with user checking input - return int value
	public int checkGetIntFromScanner (String message, boolean canBeNull){
		String userInput;
		do {
			System.out.println(message);
			userInput = scanner.nextLine();
			if (canBeNull && userInput.equals("")) {
				return -1;
			}
		} while (!isType(userInput, "Int"));
		return Integer.parseInt(userInput); 
	}
	
	public int checkGetIntFromScanner(String message){
		return checkGetIntFromScanner(message, false);
	}
	
	// Interaction with user checking input and validation with max value
	public int checkGetIntFromScannerWithMax (String message, int max, boolean canBeNull){
		int value;
		do {
			value = checkGetIntFromScanner(message, canBeNull);
			if (value > max){
				System.out.println("The number must be under: " + max);
			}
		} while (value > max);
		return value;
	}
	
	public int checkGetIntFromScannerWithMax (String message, int max){
		return checkGetIntFromScannerWithMax(message, max, false);
	}
	
	// Interaction with user checking input and validation with range values - int
	public int checkGetIntFromScannerWithRange (String message, int[] rangeValidValues, boolean canBeNull){
		int value;
		boolean validValue = false;
		do {
			value = checkGetIntFromScanner(message, canBeNull);
			if (canBeNull && value == -1) {
				return value;
			} else {
				for (int i : rangeValidValues){
					if (value == i) {
						validValue = true;
					}
				}
				if (!validValue){
					String validValuesShow = "";
					for(int i : rangeValidValues){
						validValuesShow += " " + i;
					}
					System.out.println("The number must be in the range of: " + validValuesShow);
				}
			}
			
		} while (!validValue);
		return value;
	}
	
	public int checkGetIntFromScannerWithRange (String message, int[] rangeValidValues){
		return checkGetIntFromScannerWithRange(message, rangeValidValues, false);
	}
	
	// Interaction with user checking input and validation with range values - Long
	public long checkGetLongFromScannerWithRange (String message, ArrayList<Long> rangeValidValues, boolean canBeNull){
		long value;
		boolean validValue = false;
		do {
			value = checkGetLongFromScanner(message, canBeNull);
			if (canBeNull && value == -1) {
				return value;
			} else {
				for (long i : rangeValidValues){
					if (value == i) {
						validValue = true;
					}
				}
				if (!validValue){
					String validValuesShow = "";
					for(long i : rangeValidValues){
						validValuesShow += " " + i;
					}
					System.out.println("The number must be: " + validValuesShow);
				}
			}
			
		} while (!validValue);
		return value;
	}
	
	public long checkGetLongFromScannerWithRange (String message, ArrayList<Long> rangeValidValues){
		return checkGetLongFromScannerWithRange(message, rangeValidValues, false);
	}
	
	// Interaction with user checking input - return Long value
		public long checkGetLongFromScanner (String message, boolean canBeNull){
			String userInput;
			do {
				System.out.println(message);
				userInput = scanner.nextLine();
				if (canBeNull && userInput.equals("")) {
					return -1;
				}
			} while (!isType(userInput, "Long"));
			return Long.parseLong(userInput); 
		}
		
		public long checkGetLongFromScanner(String message){
			return checkGetLongFromScanner(message, false);
		}
	
	// Check if variable is type.
	public boolean isType (String input, String match){
		Scanner checkScanner = new Scanner(input);
		boolean answer = false;
		
		switch (match) {
		case "Int":
			if (checkScanner.hasNextInt()){
				answer = true;
			}else {
				System.out.println("Invalid number, insert an integer number!");
			}
			break;
		case "Double":
			if (checkScanner.hasNextDouble()){
				answer = true;
			}else {
				System.out.println("Invalid number, insert an double number!");
			}
			break;
		case "Float":
			if (checkScanner.hasNextFloat()){
				answer = true;
			}else {
				System.out.println("Invalid number, insert an float number!");
			}
			break;
		case "Long":
			if (checkScanner.hasNextLong()){
				answer = true;
			}else {
				System.out.println("Invalid number, insert an Long number!");
			}
			break;
		default:
			answer = true;
		}
		checkScanner.close();
		return answer;
	}

}
