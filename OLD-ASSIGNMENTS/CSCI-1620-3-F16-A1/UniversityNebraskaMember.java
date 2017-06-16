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

package NUMembers;
import java.util.Scanner;
public class UniversityNebraskaMember
{
	Scanner in = new Scanner(System.in);
	private String name;
	private int NUID;
	private String city;
	
	/**
     *
     * Constructor for UN Member.
     *
     */
	
	public UniversityNebraskaMember(String name, int NUID, String city) {
		
		name = setName(name);
		city = setCity(city);
		NUID = setNUID(NUID);
		
	}
	
	/**
     * Sets name for UN Member
     *
     * @param name 		The Name of the UN Member
     * @return			Returns the name
     *
     */
	
	public String setName(String n) {
		name = n;
		return name;
	}
	
	/**
     * Sets city for UN Member
     *
     * @param city 		The city of the UN Member
     * @return			Returns the city
     *
     */
	
	public String setCity(String c) {
		city = c;
		return city;
	}
	/**
     * Sets NUID for UN Member
     *
     * @param NUID 		The NUID of the UN Member
     * @return			Returns the NUID
     *
     */
	
	public int setNUID(int n) {
		if(9999999 > n){
			n = -1;
		}
		NUID = n;
		return NUID;
	}
	
	/**
     * Returns info of member, formatted
     *
     * @return		Returns a formatted string of information
     * 
     */
	@Override
	public String toString() {
		return String.format("Name: %s\nNUID: %d\nCampus Location: %s\n",name,NUID,city);
	}
	
	
}


