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

public class Ostrich extends Animal {
	
	private int eggs;
	
	//Constructor
	public Ostrich()
	{
		super();
		clean();
	}
	
	@Override
	public void eat(Food meal) {
		double hungerValue = 0;
		double happyValue = 0;
		
		if(meal instanceof Grass){
			hungerValue = meal.getNutrition() * 0.65;
			happyValue = 0;
		}
		if(meal instanceof Fish){
			hungerValue = meal.getNutrition() * 0.8;
			happyValue = 20;
		}
		if(meal instanceof Fruit){
			hungerValue = meal.getNutrition();
			happyValue = 20;
		}
		if(meal instanceof Meat){
			hungerValue = meal.getNutrition() * 0.3;
			happyValue = -15;
		}
		if(meal instanceof Seeds){
			hungerValue = meal.getNutrition();
			happyValue = 10;
		}
		
		int hungerV = (int)(hungerValue);
		int happyV = (int)(happyValue);
		modifyHunger(hungerV);
		modifyHappiness(happyV);
	}
	//Eggs
	public int getEggs() {
		return eggs;
	}
	public int modifyEggs(int egg) {
		int howMany = getEggs();
		howMany = howMany + egg;
		return howMany;
	}
	//Sleep Method
	@Override
	public int sleep() {
		modifyHunger(-10);
		modifyHappiness(-30);
		Random ran = new Random();
		int random = ran.nextInt((10) + 1);
		if(random <= 5) {
			eggs = eggs + 1;
		}
		if(eggs > 3) {
			modifyHappiness(-30);
		}
		int total = getHappiness() + getHunger();
		return total;
	}
	//Clean Method
	@Override
	public void clean() {
		modifyHappiness(10);
		modifyEggs((-1 * getEggs()));
	}
	
	//Override to String
	@Override
	public String toString() {
		return String.format("Ostrich\n%s\nEggs: %d\n", super.toString(), getEggs());
	}
}