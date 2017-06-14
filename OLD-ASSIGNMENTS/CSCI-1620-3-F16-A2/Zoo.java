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
import Zoo.Foods.Food;
import Zoo.Foods.Seeds;
import Zoo.Foods.Grass;
import Zoo.Foods.Fish;
import Zoo.Foods.Fruit;
import Zoo.Foods.Meat;
import Zoo.Animals.Animal;
import Zoo.Animals.Ostrich;
import Zoo.Animals.Lion;
import Zoo.Animals.Dolphin;
import Zoo.Animals.Elephant;
import java.util.Random;


public class Zoo {
	private Animal[] cages = new Animal[4];
	private Food[] foodCrates = new Food[5];
	private int keeperEnergy;
	private int score;
	public final int ELEPHANTLOCATION = 0;
	public final int DOLPHINLOCATION = 1;
	public final int OSTRICHLOCATION = 2;
	public final int LIONLOCATION = 3;
	public final int SEEDSCRATE = 0;
	public final int MEATCRATE = 1;
	public final int GRASSCRATE = 2;
	public final int FISHCRATE = 3;
	public final int FRUITCRATE = 4;
	
	//Zoo Constructor
	public Zoo() {
		keeperEnergy = 100;
		score = 0;
		Lion Craig = new Lion();
		cages[0] = new Elephant();
		cages[1] = new Dolphin();
		cages[2] = new Ostrich();
		cages[3] = Craig;
		foodCrates[0] = new Seeds();
		foodCrates[1] = new Meat();
		foodCrates[2] = new Grass();
		foodCrates[3] = new Fish();
		foodCrates[4] = new Fruit();
		
	}
	//Feed Animal
	public boolean feedAnimal(int cage, int crate){
		int cost = foodCrates[crate].getExhaustionCost();
		if(foodCrates[crate].getAmount() < 1 || keeperEnergy < cost) {
			return false;
		}
		else {
			keeperEnergy = keeperEnergy - cost;
			cages[cage].eat(foodCrates[crate]);
			foodCrates[crate].consume();
			return true;
		}
		
	}
	//Clean Cage
	public boolean cleanCage(int cage) {
		if(keeperEnergy < 30) {
			return false;
		}
		else {
			cages[cage].clean();
			keeperEnergy = keeperEnergy - 30;
			return true;
		}
		
	}
	//Swim
	public boolean swimWithDolphin() {
		Dolphin Sam = (Dolphin)cages[1];
		if(keeperEnergy < 40) {
			return false;
		}
		else {
			keeperEnergy = keeperEnergy - 40;
			Sam.swim();
			cages[1] = Sam;
			return true;
		}
	}
	//Give Ball
	public boolean giveLionBall() {
		Lion Craig = (Lion)cages[3];
		if(keeperEnergy < 20) {
			return false;
		}
		else {
			keeperEnergy = keeperEnergy - 20;
			Craig.giveBall();
			cages[3] = Craig;
			return true;
		}
	}
	//End Day
	public int endDay() {
		for(int i = 0; i < cages.length; i++) {
			score += cages[i].sleep();
		}
		int ran = (int)(Math.random() * 5);
		foodCrates[ran].recieveDelivery();
		keeperEnergy = 100;
		return score;
	}
	//To String
	public String toString() {
		String animals = new String();
		String foods = new String();
		String x = new String();
		for(int i = 0; i < cages.length; i++) {
			animals += String.format("%s\n", cages[i].toString());
		}
		for(int i = 0; i < foodCrates.length; i++) {
			foods += String.format("%s\n", foodCrates[i].toString());
		}
		x = String.format("\nANIMALS\n%sFOOD CRATES\n%sENERGY: %d\nSCORE: %d\n", animals, foods, keeperEnergy, score);
		return x;	
	}
	
}