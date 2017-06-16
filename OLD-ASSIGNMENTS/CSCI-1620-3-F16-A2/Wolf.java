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
import Zoo.Animals.Animal;
import Zoo.Foods.*;
import java.util.Random;

public class Wolf extends Animal {
	
	private boolean fullMoon;
	//Constructor
	public Wolf()
	{
		super();
		
	}
	
	@Override
	public void eat(Food meal) {
		double hungerValue = 0;
		double happyValue = 0;
		
		if(meal instanceof Grass){
			hungerValue = meal.getNutrition() * 0.6;
			happyValue = -10;
		}
		if(meal instanceof Fish){
			hungerValue = meal.getNutrition();
			happyValue = 15;
		}
		if(meal instanceof Fruit){
			hungerValue = meal.getNutrition() * 0.8;
			happyValue = 10;
		}
		if(meal instanceof Meat){
			hungerValue = meal.getNutrition();
			happyValue = 25;
		}
		if(meal instanceof Seeds){
			hungerValue = meal.getNutrition() * 0.10;
			happyValue = -20;
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
		int random = ran.nextInt((30) + 1);
		if(random == 10) {
			fullMoon = true;
		}
		if(fullMoon) {
			modifyHappiness(50);
		}
		int total = getHappiness() + getHunger();
		return total;
	}
	//Clean Method
	@Override
	public void clean() {
		modifyHappiness(20);
	}
	//Override to String
	@Override
	public String toString() {
		String x = String.format("Wolf\n%s\n", super.toString());
		if(fullMoon){
			x += String.format("It's a Full Moon!\n");
		}
		else {
			x += String.format("Not a Full Moon\n");
		}
		return x;
	}
}