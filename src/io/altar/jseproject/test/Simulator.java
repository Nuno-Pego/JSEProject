package io.altar.jseproject.test;

import io.altar.jseproject.textinterface.TextInterface;

public class Simulator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TextInterface stateMachine = new TextInterface();

		int userAnswer = 0;

		while (true) {
			userAnswer = stateMachine.getStates()[stateMachine.getCurrentState()].execute();
			if (stateMachine.getCurrentState() == 0 && userAnswer == 3) {
				break;
			}
			stateMachine.setCurrentState(
					stateMachine.getTransitionsStates()[stateMachine.getCurrentState()][userAnswer-1]);
		}
	}
}
