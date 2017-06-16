// Name     : Mikayla Thomas
    // Class    : 1620
    // Program #    : 6
    // Due Date     : 11-29-2016
    //
    // Honor Pledge:  On my honor as a student of the University
//                of Nebraska at Omaha, I have neither given nor received
//                unauthorized help on this homework assignment.
//
// NAME: Mikayla Thomas
// NUID: 692
// EMAIL: mikaylathomas@unomaha.edu
import java.util.*;
import java.util.Formatter;
import java.util.StringTokenizer;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.SecurityException;
import java.util.FormatterClosedException;

public class StateCrimeStats implements Serializable {
	private String stateName;
	private int population;
	private int violentCrimes;
	private int nonVehicletheftCrimes;
	private String highestPropertyCrimeCity;
	private double highestPropertyCrimeRate;
	
	public StateCrimeStats(String sta, int pop, int vio, int thef, String propCity, double propRate) {
		stateName = sta;
		population = pop;
		violentCrimes = vio;
		nonVehicletheftCrimes = thef;
		highestPropertyCrimeCity = propCity;
		highestPropertyCrimeRate = propRate;
	}
	
	@Override
	public String toString() {
		String toPrint = String.format("State: %s\nPopulation: %d\nViolent Crimes: %d\nNon-Vehicle Theft Crimes: %d\nHighest Propety Crime Rate: %s - %f\n", stateName, population, violentCrimes, nonVehicletheftCrimes, highestPropertyCrimeCity, highestPropertyCrimeRate);
		/*try {
			Formatter output = new Formatter(stateName);
			output.format("%s", toPrint);
			output.close();
			ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(stateName + ".ser"));
		}
		catch(IOException IOE)
		{
			//System.err.println("Error reading crime data");
			System.exit(1);
		}*/

		return toPrint;
	}
	
}