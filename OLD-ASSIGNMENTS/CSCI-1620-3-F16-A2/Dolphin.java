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

public class Dolphin extends Animal {
	
	//Constructor
	public Dolphin()
	{
		super();
	}
	
	@Override
	public void eat(Food meal) {
		double hungerValue = 0;
		double happyValue = 0;
		
		if(meal instanceof Grass){
			hungerValue = meal.getNutrition() * 0.4;
			happyValue = -10;
		}
		if(meal instanceof Fish){
			hungerValue = meal.getNutrition();
			happyValue = 10;
		}
		if(meal instanceof Fruit){
			hungerValue = meal.getNutrition();
			happyValue = 20;
		}
		if(meal instanceof Meat){
			hungerValue = meal.getNutrition() * 0.8;
			happyValue = 0;
		}
		if(meal instanceof Seeds){
			hungerValue = meal.getNutrition() * 0.2;
			happyValue = -30;
		}
		
		int hungerV = (int)(hungerValue);
		int happyV = (int)(happyValue);
		modifyHunger(hungerV);
		modifyHappiness(happyV);
	}
	//Sleep Method
	@Override
	public int sleep() {
		modifyHunger(-10);
		modifyHappiness(-30);
		int total = getHappiness() + getHunger();
		return total;
	}
	//Clean Method
	@Override
	public void clean() {
		modifyHappiness(10);
	}
	//Swim Class
	public void swim() {
		modifyHappiness(30);
	}
	//Override to String
	@Override
	public String toString() {
		return String.format("Dolphin\n%s\n", super.toString());
	}
}