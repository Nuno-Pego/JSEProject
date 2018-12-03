package io.altar.jseproject.test;

//Import:
import io.altar.jseproject.textInterface.*;

//Class with Main for Tests
public class Development {
	
	public static void main(String[] args) {
		TextInterface stateMachine = new TextInterface();
		int userChoice = 0;
		
		while (true){
			userChoice = stateMachine.getStates()[stateMachine.getCurrentState()].execute();
			if (stateMachine.getCurrentState() == 0 && userChoice == 3) { break; }
			stateMachine.setCurrentState(stateMachine.getTransitionsStates()[stateMachine.getCurrentState()][userChoice-1]);
		}

	}

}
