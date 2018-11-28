package io.altar.jseproject.textinterface;

import io.altar.jseproject.textinterface.states.*;


public class TextInterface {
	
	private State[] states = {new MainMenu(), new ProductsMenu(), new ShelfsMenu()};
	private int transitionsStates[][] = {{1,2},{0,0,0,0,0},{0,0,0,0,0}};
	
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
