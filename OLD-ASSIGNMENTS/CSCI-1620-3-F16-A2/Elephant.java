// Name     : Mikayla Thomas
    // Class    : Your section of 1620
    // Program #    : 1
    // Due Date     : 9-28-2016
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
import Zoo.Animals.*;

public class Elephant extends Animal {
	
	private int loneliness;
	
	//Constructor
	public Elephant()
	{
		super();
		loneliness = modifyLoneliness(100);
	}
	
	@Override
	public void eat(Food meal) {
		double hungerValue = 0;
		double happyValue = 0;
		
		if(meal instanceof Grass){
			hungerValue = meal.getNutrition();
			happyValue = 0;
		}
		if(meal instanceof Fish){
			hungerValue = meal.getNutrition() * 0.4;
			happyValue = -10;
		}
		if(meal instanceof Fruit){
			hungerValue = meal.getNutrition();
			happyValue = 20;
		}
		if(meal instanceof Meat){
			hungerValue = meal.getNutrition() * 0.7;
			happyValue = -20;
		}
		if(meal instanceof Seeds){
			hungerValue = meal.getNutrition() * 0.5;
			happyValue = 0;
		}
		
		int hungerV = (int)(hungerValue);
		int happyV = (int)(happyValue);
		modifyHunger(hungerV);
		modifyHappiness(happyV);
		modifyLoneliness(10);
	}
	//Loneliness Class
	public int getLoneliness() {
		return loneliness;
	}
	public int modifyLoneliness(int lon){
		loneliness = loneliness + lon;
		
		//validate amount
		if(loneliness > 100) {
			loneliness = 100;
		}
		if(loneliness < 0) {
			loneliness = 0;
		}
		return loneliness;
	}
	//Sleep Method
	@Override
	public int sleep() {
		modifyHunger(-15);
		modifyHappiness(-10);
		//Loneliness penalty
		if(getLoneliness() < 50) {
			modifyHappiness(-20);
		}
		
		modifyLoneliness(-20);
		int total = getHappiness() + getHunger();
		return total;
	}
	//Clean Method
	@Override
	public void clean() {
		modifyHappiness(30);
		modifyLoneliness(20);
	}
	@Override
	public String toString() {
		return String.format("Elephant\n%s\nLoneliness: %d\n", super.toString(),getLoneliness());
	}
}