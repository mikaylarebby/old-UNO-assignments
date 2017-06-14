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

import Schedule.Exceptions.InvalidDeadlineException;
import Schedule.Exceptions.InvalidValueException;
import Schedule.SchedulerTool.Scheduler;
import Schedule.Task.Task;
import java.util.*;
import java.util.StringTokenizer;

//Driver for Scheduler
public class SchedulerDriver {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		Scheduler S = new Scheduler();
		System.out.println("Input Tasks: DEADLINE VALUE\nType DONE to schedule");
		boolean repeat = true;
		int x = 0;
		do {
			try{
				String token = in.nextLine();
				if(token.toUpperCase().equals("DONE")) {
					repeat = false;
				}
				else {
					StringTokenizer tokens = new StringTokenizer(token);
					String deadline = tokens.nextToken();
					String value = tokens.nextToken();
					int deadlineInt = Integer.parseInt(deadline);
					int valueInt = Integer.parseInt(value);
					S.addTask(new Task(deadlineInt, valueInt));
					x++;
				}
				
			}
			catch(NumberFormatException NFE){
				System.out.printf("Invalid Task\n");
			}
			catch(NoSuchElementException NSEE){
				System.out.printf("Invalid Task\n");
			}
			catch(MissingFormatArgumentException MFAE){
				System.out.printf("Invalid Task\n");
			}
			catch(InvalidDeadlineException IDE){
				System.out.printf("\n%s\n", IDE);
			}
			catch(InvalidValueException IVE){
				System.out.printf("\n%s\n", IVE);
			}
		}while(repeat);
		
		if(x < 1) {
			System.out.println("No tasks given.");
		}
		else {
			S.printInputTasks();
			S.scheduleTasks();
			S.printOutputTasks();
			System.out.printf("Maximum Value of Tasks is %d\n", S.calculateValue());
		}
	}
}