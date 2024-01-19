package main.copy;

import java.util.Random;

public class Dice {
	private int amountOfDice = 1;
	private int typeOfDice = 1;
	private Random rng = new Random();
	
	public void diceCreation(int amount, int type) {
		amountOfDice = amount;
		typeOfDice = type;
	}
	
	public void diceCreation(int type) {
		typeOfDice = type;
	}
	
	public int[] rolls() {
		int[] rolls = new int[amountOfDice + 1];
		for(int i = 0; i < amountOfDice + 1; i ++) {
			rolls[i] = rng.nextInt(typeOfDice) + 1;
		}
		return rolls;
		
	}
	
	
	
}
