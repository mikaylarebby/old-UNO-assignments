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

package NUMembers.UNL.UNLTypes;
import NUMembers.UNL.UNLTypes.*;
import java.util.Scanner;
public class UNLStudent extends UNLMember
{
	private double GPA;
	private double balance;
	private int credits;
	
	public UNLStudent(String name, int NUID, String myUNLID, double balance, int credits, double GPA) {
		super(name,NUID,myUNLID);
		GPA = setGPA(GPA);
		balance = setBalance(balance);
		credits = setCredits(credits);
	}
	
	//Method to set GPA of student
	public double setGPA(double grade){
		if(grade < 0.0 || grade > 4.0) {
			grade = 0;
		}
		GPA = grade;
		return GPA;
	}
	
	//Method to set account balance of student
	public double setBalance(double due){
		if(due < 0.0) {
			due = 0;
		}
		balance = due;
		return balance;
	}
	
	//Method to set the credit hours earned by student
	public int setCredits(int hours) {
		if(hours < 0) {
			hours = 0;
		}
		credits = hours;
		return credits;
	}
	
	@Override
	public String toString() {
		return String.format("%sBalance: $%.2f\nCredits: %d\nGPA: %.2f",super.toString(),balance,credits,GPA);
	}
}