package main.copy;

/**
 * Class that deals with the rolling of the bot
 * @author javin
 *
 */
public class Roll {
	
	String type = "";
	//int roll = 0;
	
	public Roll(String dice) {
		type = dice;
	}
	
	public String rollDice() {
		String[] test = type.split("(?i)d");
		if(test.length == 2){
			
			//Checks if both Xdx and xdX is a number. 
			if(!isNumeric(test[0]) || !isNumeric(test[1])) {
				return("Please put it like xDx or xDxSx. x is a number ok");
			}
			else{
				Dice rolled = new Dice();
				//Puts in both parameters into the dice class
				rolled.diceCreation(Integer.parseInt(test[0]), Integer.parseInt(test[1]));
				int[] rolls = rolled.rolls();
				//Builds up the string for the message
				String listOfRolls = "";
				int succsesses = 0;
				int num = 0;
				
				
				if(Integer.parseInt(test[1]) < 2) {
					num = 1;
				}
				else if(Integer.parseInt(test[0]) > 100) {
					return("Too many Dice");
				}
				else {
					num = (Integer.parseInt(test[1])/2) + 1;
					}
				
				for(int i = 0; i < rolls.length - 2; i++) {
					if(rolls[i] >= num) {
						if(rolls[i] == Integer.parseInt(test[1])) {
							
						}
						succsesses++;
						listOfRolls += "**" + rolls[i] + "**" + ", ";
					}
					else {
					listOfRolls += rolls[i] + ", ";
					}
				}
				//Last Number
				if(rolls[rolls.length -1] >= num) {
					if(rolls[rolls.length -1] == Integer.parseInt(test[1])) {
						
					}
					listOfRolls += "**" + rolls[rolls.length - 1] + "**.";
					succsesses++;
				}
				else {
					listOfRolls += rolls[rolls.length - 1] + ".";
				}
				
				listOfRolls += " Ammount of Successes = " + succsesses + "/" + test[0];
				
				return(listOfRolls);
		
			}
		}
		else {
			return ("Please put proll xdx");
		}
		
	}
	
	private static boolean isNumeric(String test) {
		boolean t = true;
		try {
			@SuppressWarnings("unused")
			Double d = Double.parseDouble(test);
		}catch(NumberFormatException c) {
			t = false;
		}
		return t;
		
	}
}
