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

package Zoo.Foods;
import java.util.Scanner;

public abstract class Food {
	private int exhaustionCost;
	private int nutrition;
	private int amount;
	
	//Constructor for Food superclass
	public Food(int exC, int nut) {
		exhaustionCost = exC;
		nutrition = nut;
		recieveDelivery();
	}
	//Get exhaustion cost
	public int getExhaustionCost() {
		return exhaustionCost;
	}
	//Get exhaustion cost
	public int getNutrition() {
		return nutrition;
	}
	//Get amount method - returns amount
	public int getAmount(){
		return amount;
	}
	
	//Recieve Delivery
	public int recieveDelivery() {
		amount = getAmount() + 1;
		return amount;
	}
	//Consume
	public int consume() {
		int amount = getAmount() - 1;
		return amount;
	}
	//ToString
	public String toString () {
		return String.format("Exhastion: %d\nNutrition: %d\nAmount: %d\n", exhaustionCost, nutrition, amount);
	}
	
}