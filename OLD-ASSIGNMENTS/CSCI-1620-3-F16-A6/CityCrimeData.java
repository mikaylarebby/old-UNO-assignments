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

public class CityCrimeData {
	public String cityName;
	public int population;
	public int violentCrimeCount;
	public int murderCount;
	public int robberyCount;
	public int assaultCount;
	public int propertyCount;
	public int burglaryCount;
	public int larcentyCount;
	public int vehicleTheftCount;
	public int arsonCount;
	
	//Constructor for CityCrimeData, sets all pased values. 
	public CityCrimeData(String name, int pop, int vio, int mur, int rob, int aslt, int pro, int bur, int lar, int veh, int ars) {
		cityName = name;
		population = pop;
		violentCrimeCount = vio;
		murderCount = mur;
		robberyCount = rob;
		assaultCount = aslt;
		propertyCount = pro;
		burglaryCount = bur;
		larcentyCount = lar;
		vehicleTheftCount = veh;
		arsonCount = ars;
	}
}