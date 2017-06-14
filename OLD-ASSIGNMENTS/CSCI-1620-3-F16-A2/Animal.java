// Name	 	: Mikayla Thomas
	// Class 	: Your section of 1620
	// Program # 	: 1
	// Due Date  	: 9-28-2016
	//
	// Honor Pledge:  On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// NAME: Mikayla Thomas
// NUID: 692
// EMAIL: mikaylathomas@unomaha.edu
	
	// Partners:  NONE
	
	// Assignment #2 is a zoo game based on polymorphism
package Zoo.Animals;
import Zoo.Foods.*;

public abstract class Animal {
	
	private int hunger;
	private int happiness;
	
	public Animal() {
		hunger = modifyHunger(100);
		happiness = modifyHappiness(100);
		
	}
	//Get Hunger Method
	public int getHunger() {
		return hunger;
	}
	//Get Happiness Method
	public int getHappiness() {
		return happiness;
	}
	//Modify Hunger
	public int modifyHunger(int hun){
		hunger = hunger + hun;
		
		//validate amount
		if(hunger > 100) {
			hunger = 100;
		}
		if(hunger < 0) {
			hunger = 0;
		}
		return hunger;
	}
	//Modify Happiness
	public int modifyHappiness(int hap){
		happiness = happiness + hap;
		
		//validate amount
		if(happiness > 100) {
			happiness = 100;
		}
		if(happiness < 0) {
			happiness = 0;
		}
		return happiness;
	}
	
	//Abstract classes
	public abstract int sleep(); 
	public abstract void eat(Food meal); 
	public abstract void clean();
	
	//toString
	public String toString () {
		return String.format("Hunger: %d\nHappiness: %d", getHunger(), getHappiness());
	}
	
}