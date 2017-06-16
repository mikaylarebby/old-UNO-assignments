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

package Schedule.Task;
import Schedule.Exceptions.*;
import java.util.*;
public class Task implements Comparable<Task> {
	private static int maxDeadline;
	private int deadline;
	private int value;
	/**
     * Constructor for Task
     *
     * @param deadline	The deadline for the task
     * 		  val	The value for the task
     * 		  
     */
	public Task(int deadLine, int val) {
		deadline = this.setDeadline(deadLine);
		value = this.setValue(val);
		
	}
	/**
     * getDeadline
     *
     * returns deadline
     * 		  
     */
	
	public int getDeadline() {
		return deadline;
	}
	/**
     * getValue
     *
     * returns value
     * 		  
     */
	
	public int getValue() {
		return value;
	}
	/**
     * getMaxDeadline
     *
     * returns maxDeadline
     * 		  
     */
	
	public int getMaxDeadline() {
		return maxDeadline;
	}
	/**
     * setDeadline-
     * sets the deadline with desired int
     *
     *@param
     *	deadline	the new int for deadline
     *
     *	returns new deadline	  
     */
	
	public int setDeadline(int deadline) {
		//If negative, throw exception
		if(deadline < 0) {
			throw new InvalidDeadlineException(deadline);
		}
		//If greater than maxDeadline, set new maxDeadline
		else if(deadline > maxDeadline){
			maxDeadline = deadline;
		}
		return deadline;
	}
	/**
     * setValue-
     * sets the value with desired int
     *
     *@param
     *	value	the new int for value
     *
     *	returns new value	  
     */
	public int setValue(int value) {
		if(value < 0) {
			throw new InvalidValueException(value);
		}
		return value;
	}

	@Override
	public int compareTo(Task t) {
		int compareValue = t.getValue();
		int thisVal = this.getValue();
		
		return thisVal - compareValue;
	}
	
	@Override
	public String toString() {
		return String.format("Deadline: %d Value: %d\n", getDeadline(), getValue());
	}
	
	
	
}