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
import java.util.Random;

public class Lion extends Animal {
	
	private boolean hasBall;
	//Constructor
	public Lion()
	{
		super();
		giveBall();
		
	}
	
	@Override
	public void eat(Food meal) {
		double hungerValue = 0;
		double happyValue = 0;
		
		if(meal instanceof Grass){
			hungerValue = meal.getNutrition() * 0.5;
			happyValue = -10;
		}
		if(meal instanceof Fish){
			hungerValue = meal.getNutrition() * 0.7;
			happyValue = 10;
		}
		if(meal instanceof Fruit){
			hungerValue = meal.getNutrition();
			happyValue = 20;
		}
		if(meal instanceof Meat){
			hungerValue = meal.getNutrition();
			happyValue = 20;
		}
		if(meal instanceof Seeds){
			hungerValue = meal.getNutrition() * 0.15;
			happyValue = -10;
		}
		
		int hungerV = (int)(hungerValue);
		int happyV = (int)(happyValue);
		modifyHunger(hungerV);
		modifyHappiness(happyV);
	}
	//Sleep Method
	@Override
	public int sleep() {
		modifyHunger(-20);
		modifyHappiness(-10);
		
		Random ran = new Random();
		int random = ran.nextInt((10) + 1);
		if(random <= 3) {
			hasBall = false;
		}
		if(!hasBall) {
			modifyHappiness(-20);
		}
		int total = getHappiness() + getHunger();
		return total;
	}
	//Clean Method
	@Override
	public void clean() {
		modifyHappiness(20);
	}
	//Give Ball
	public void giveBall() {
		hasBall = true;
	}
	//Override to String
	@Override
	public String toString() {
		String x = String.format("Lion\n%s\n", super.toString());
		if(hasBall){
			x += String.format("Has Ball\n");
		}
		else {
			x += String.format("Broke Ball\n");
		}
		return x;
	}
}