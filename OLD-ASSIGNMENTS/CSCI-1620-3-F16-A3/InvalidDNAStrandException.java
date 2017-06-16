// Name     : Mikayla Thomas
    // Class    : 1620
    // Program #    : 3
    // Due Date     : 10-20-16
    //
    // Honor Pledge:  On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// NAME: Mikayla Thomas
// NUID: 692
// EMAIL: mikaylathomas@unomaha.edu
    
    // Partners: NONE
    
    // Assignment #3 is a program that compares strands of DNA using recursion
package Recursion.Exception;	
import java.util.*;
//Strand Exception issues
public class InvalidDNAStrandException extends RuntimeException {
	
	public InvalidDNAStrandException() {
		super("Strand too long");
	}
	
	public InvalidDNAStrandException(char molecule) {
		super("Invalid molecule: " + molecule);
	}
}
