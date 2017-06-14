// Name     : Mikayla Thomas
    // Class    : 1620
    // Program #    : 4
    // Due Date     : 11-3-2016
    //
    // Honor Pledge:  On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// NAME: Mikayla Thomas
// NUID: 692
// EMAIL: mikaylathomas@unomaha.edu

    // Partners: NONE

    // Assignment #4 is a scheduling program using array list

package Schedule.Exceptions;
import java.util.*;
//Strand Exception issues
public class InvalidDeadlineException extends RuntimeException {
	
	public InvalidDeadlineException(int deadline) {
		super("Non-positive number given for deadline: " + deadline);
	}
}