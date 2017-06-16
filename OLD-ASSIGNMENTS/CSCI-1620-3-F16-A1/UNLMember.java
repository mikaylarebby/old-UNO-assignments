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
import NUMembers.*;
import java.util.Scanner;
public class UNLMember extends UniversityNebraskaMember
{
	private String myUNLID;
	
	public UNLMember(String name, int NUID, String myUNLID) {
		super(name,NUID,"Lincoln");
		myUNLID = setMyUNLID(myUNLID);
	}
	//Sets the UNL ID for the Student.
	
	public String setMyUNLID(String ID) {
		if(ID == null) {
			ID = "NOT SET";
		}
		myUNLID = ID;
		return myUNLID;
	}
	
	/**
     * Returns info of member, formatted
     *
     * @return		Returns a formatted string of information
     */
	@Override
	public String toString() {
		return String.format("%sMyUNLID: %s\n",super.toString(),myUNLID);
	}
}

