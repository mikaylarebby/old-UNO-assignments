// Name	 	: Mikayla Thomas
	// Class 	: Your section of 1620
	// Program # 	: 1
	// Due Date  	: 9-13-2016
	//
	// Honor Pledge:  On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// NAME: Mikayla Thomas
// NUID: 692
// EMAIL: mikaylathomas@unomaha.edu
	
	// Partners:   List the full names, CIST 1620 section and e-mail address
	// of anyone you may have discussed the program with or worked on the program
	// with, including tutors. It is not necessary to list your instructor.
	// If none, list "NONE".  This section must be present.
	
	// Assignment #1 is a collection of sub and super classes.

package NUMembers.UNO.UNOTypes;
import NUMembers.UNO.UNOTypes.*;
import java.util.Scanner;
public class UNOStaff extends UNOMember
{
	private String position;
	private double wage;
	
	public UNOStaff(String name, int NUID, String netID, String position, double wage) {
		super(name,NUID,netID);
		position = setPosition(position);
		wage = setWage(wage);
	}
	
	//Set position of UNO Staff
	public String setPosition(String job){
		if(job == null){
			job = "NOT SET";
		}
		position = job;
		return position;
	}
	
	//Set wage of UNO Staff
	public double setWage(double money){
		if(money < 0) {
			money = -1;
		}
		wage = money;
		return wage;
	}
	
	@Override
	public String toString() {
		return String.format("%sPosition: %s\nWage: $%.2f",super.toString(),position,wage);
	}
	
	
}