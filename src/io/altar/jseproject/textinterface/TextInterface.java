package io.altar.jseproject.textInterface;

import io.altar.jseproject.textInterface.states.*;


public class TextInterface {

	// Attributes:
	private State[] states = {new MainMenu(), 
							  new ProductsMenu(), 
							  new ShelfsMenu(), 
							  new CreateProductMenu(), 
							  new EditProductMenu(),						 
							  new ConsultProductMenu(),
							  new DeleteProductMenu(),
							  new CreateShelfMenu()};
	
	private int transitionsStates [][] = {{1,2}, 			//Main Menu
										  {3,4,5,6,0},		//ProductsMenu
										  {7,8,9,10,0},		//ShelfsMenu
			  							  {1},				//CreateProductMenu
			  							  {1},				//EditProductMenu
			  							  {1},				//ConsultProductMenu
			  							  {1},				//DeleteProductMenu
			  							  {2}};				//CreateShelfMenu		
															
	private int currentState = 0;
	
	// Getters and Setters:
	public State[] getStates() {
		return states;
	}
	
	public int[][] getTransitionsStates() {
		return transitionsStates;
	}
	
	public int getCurrentState() {
		return currentState;
	}
	
	public void setCurrentState(int currentState) {
		this.currentState = currentState;
	}
	
	
	
}
