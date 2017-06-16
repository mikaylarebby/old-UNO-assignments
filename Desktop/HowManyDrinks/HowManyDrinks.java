import javax.swing.*;
import java.util.*;

public class HowManyDrinks {

	public static void main(String args[]) {
		


	}
	
	public static String calculateDrinks(int age, int weight, String gender, String drinkType, int drinkNum, int hours) {
		
		double ouncesConsumed = 0;
		double BAC = 0;
		
		
		if (drinkType == "Wine") {
			ouncesConsumed = (drinkNum * 5)*(0.12);
		}
		if (drinkType == "Beer") {
			ouncesConsumed = (drinkNum * 12)*(0.05);
		}
		if (drinkType == "The Hard Stuff") {
			ouncesConsumed = (drinkNum * 1)*(0.40);
		}
		if (gender == "Male") {
			BAC = ((ouncesConsumed * 5.14)/(weight * 0.73)) - (0.015 * hours);
		}
		if (gender == "Female") {
			BAC =  ((ouncesConsumed * 5.14)/(weight * 0.66)) - (0.015 * hours);
		}
		
		if(BAC < 0.08) {
			return "not drunk, your BAC is" + BAC;
		}
		else {
			return "drunk, your BAC is" + BAC;
		}
		
	}

}
