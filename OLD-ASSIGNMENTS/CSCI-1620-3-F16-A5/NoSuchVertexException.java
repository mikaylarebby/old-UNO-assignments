// Name     : Mikayla Thomas
    // Class    : 1620
    // Program #    : 5
    // Due Date     : 11-17-2016
    //
    // Honor Pledge:  On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// NAME: Mikayla Thomas
// NUID: 692
// EMAIL: mikaylathomas@unomaha.edu

    // Partners: NONE

    // Assignment #5 is a program that uses linked lists
import java.util.*;

public class NoSuchVertexException extends RuntimeException {
	
	public NoSuchVertexException(int vert) {
		super("Vertex does not exist: " + vert);
	}
}