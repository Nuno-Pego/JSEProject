package io.altar.jseproject.textinterface;

import io.altar.jseproject.textinterface.states.*;


public class TextInterface {
	
	private State[] states = {new MainMenu(), new ProductsMenu(), new ShelfsMenu(), new CreateProductMenu()};
	private int transitionsStates[][] = {{1,2},{3,5,7,9,11},{4,6,8,10,12},{1}};
	
	private int currentState = 0;

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
