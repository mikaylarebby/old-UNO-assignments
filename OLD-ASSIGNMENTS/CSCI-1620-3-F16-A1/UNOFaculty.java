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
public class UNOFaculty extends UNOMember
{
	private String department;
	private String title;
	private double salary;
	
	public UNOFaculty(String name, int NUID, String netID, String department, String title, double salary) {
		super(name,NUID,netID);
		department = setDepartment(department);
		title = setTitle(title);
		salary = setSalary(salary);
	}
	//Set department for Faculty member
	public String setDepartment(String d){
		if(d == null){
			d = "NOT SET";
		}
		department = d;
		return department;
	}
	//Set title for Faculty member
	public String setTitle(String t){
		if(t == null){
			t = "NOT SET";
		}
		title = t;
		return title;
	}
	//Set Salary for faculty member
	public double setSalary(double s){
		if(s < 23660){
			s = -1;
		}
		salary = s;
		return salary;
	}
	
	@Override
	public String toString() {
		return String.format("%sDepartment: %s\nTitle: %s\nSalary: $%.2f",super.toString(),department,title,salary);
	}
	
}