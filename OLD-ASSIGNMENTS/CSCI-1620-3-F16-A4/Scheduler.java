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

package Schedule.SchedulerTool;
import java.util.*;
import Schedule.Exceptions.*;
import Schedule.Task.*;

public class Scheduler {
	private ArrayList<Task> inputTasks;
	private Task[] outputTasks;
	
	public Scheduler() {
		inputTasks = new ArrayList<Task>();
	}
	/**
     * addTask- adds a task to the end of the list
     *
     * @param
     *	t	the task to be added  
     */
	public void addTask(Task t) {
		inputTasks.add(t);
	}
	/**
     * scheduleTasks - method to sort and place tasks
     * into the outputTasks array
     */
	public void scheduleTasks() {
		Collections.sort(inputTasks);
		//Max Deadline should be the same for all tasks. 
		int max = inputTasks.get(1).getMaxDeadline();
		outputTasks = new Task[max];
		Collections.sort(inputTasks);
		for(int i = 1; i < inputTasks.size(); i++) {
            Task temp = inputTasks.get(i);
			if(temp.getDeadline() > 0) {
				if(outputTasks[temp.getDeadline() - 1] == null) {
					outputTasks[temp.getDeadline() -1] = temp;
				}
				else {
					for(i = temp.getDeadline() - 1; i > 0; i--) {
						if(outputTasks[i] != null) {
							
						}
						else {
							outputTasks[i] = temp;
							break;
						}
					}
					//Test with deadline being one
					if(temp.getDeadline() == 1) {
						if(outputTasks[0] == null) {
							outputTasks[0] = temp;
							break;
						}
						else {
							break;
						}
					}
				}
			}
        }
		
	}
	/**
     * calculate value - calculates total value
     * of all output tasks
     *
     *	returns total value	  
     */
	public int calculateValue() {
		int totalVal = 0;
		for(int i = 0; i < outputTasks.length; i++) {
			if(outputTasks[i] != null){
				totalVal += outputTasks[i].getValue();
			}
		}
		return totalVal;
	}
	/**
     * printInputTasks - prints tasks input as well as the min and max
     * 
     */
	public void printInputTasks() {
		String output = "";
		for(int i = 0; i < inputTasks.size(); i++){
			if(inputTasks.get(i) != null) {
				output = output + String.format("%s", inputTasks.get(i).toString());
			}
		}
		Collections.sort(inputTasks);
		int size = inputTasks.size();
		Task max = inputTasks.get(0);
		Task min = inputTasks.get(size - 1);
		output = output + String.format("Task with Max value: %sTask with Min value: %s", max.toString(), min.toString());
		System.out.print(output);
		
	}
	/**
     * printOutputTasks - prints tasks output in the correct order
     */
	public void printOutputTasks() {
		Collections.sort(inputTasks);
		System.out.println("Scheduled tasks:");
		for(int i = 0; i < outputTasks.length; i++){
			if(outputTasks[i] != null) {
				System.out.printf("%s", outputTasks[i].toString());
			}
		}
	}
}