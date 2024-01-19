package main.copy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class NameChecker {
	
	private String moveName = "";
	private ArrayList<String> list = new ArrayList<String>();
	
	public NameChecker() {
		
	}
	
	public NameChecker(String name) {
		moveName = name;
	}
	
	public void nameAdd(String name) {
		moveName = moveName + name;
	}
	
	public String returnName() {
		return moveName;
	}
	
	public boolean checkIfPos() {
	
	try {
		/*
		 * Java's Scanner class is a simple lexer for Strings and primitive types.
		 */
		FileReader file = new FileReader("FILELOCATION\\Move_List.txt");
		Scanner fileInput = new Scanner(file);

		/*
		 * The Delimiter will take anything inside the
		 * {
		 * 
		 * }
		 * 
		 */
		fileInput.useDelimiter("(?<=})");

		while (fileInput.hasNextLine()) {
			String t = fileInput.nextLine();
			list.add(t);
				
		}
		fileInput.close();}
	
		catch(FileNotFoundException e) {
			System.err.println("File cannot be found.");
		}
	
	for(int i = 0; i < list.size(); i++) {
		if(list.get(i).compareTo(moveName) == 0) {
			return true;
		}
	}
	
	return false;
}
}
