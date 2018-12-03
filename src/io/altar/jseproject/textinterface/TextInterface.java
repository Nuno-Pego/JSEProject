package io.altar.jseproject.textInterface;

import io.altar.jseproject.textInterface.states.*;


public class TextInterface {

	// Attributes:
	private State[] states = {new FirstLevelMenu(), 
							  new FirstLevelMenuProducts(), 
							  new FirstLevelMenuShelfs(), 
							  new SecondLevelProductCreate(), 
							  new SecondLevelShelfCreate()};
	
	private int transitionsStates [][] = {{1,2},{3,5,7,9,0},{4,6,8,10,0},
			  							  {1},
			  							  {2}};
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
