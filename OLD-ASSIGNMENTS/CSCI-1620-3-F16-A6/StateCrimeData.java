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

public class StateCrimeData {
	private String stateName;
	private ArrayList<CityCrimeData> crimeByCity;
	
	//Constructor for StateCrimeData
	public StateCrimeData(){
		crimeByCity = new ArrayList<CityCrimeData>();
	}
	
	/**
     * readCrimeData - Takes name of CSV and reads the file
     *
     * @param
     *	String crimeFile  The name of file to be read. 
     */
	public void readCrimeData(String crimeFile) throws FileNotFoundException {
		try {
			File cityCrimeFile = new File(crimeFile + ".csv");
			if(cityCrimeFile.exists()) {
				Scanner crimeInfo = new Scanner(cityCrimeFile);
				stateName = crimeInfo.nextLine();
				while(crimeInfo.hasNextLine()) {
					StringTokenizer line = new StringTokenizer(crimeInfo.nextLine(), ",");
					String cityName = line.nextToken();
					int pop = Integer.parseInt(line.nextToken());
					int vio = Integer.parseInt(line.nextToken());
					int mur = Integer.parseInt(line.nextToken());
					int rob = Integer.parseInt(line.nextToken());
					int aslt = Integer.parseInt(line.nextToken());
					int prop = Integer.parseInt(line.nextToken());
					int bur = Integer.parseInt(line.nextToken());
					int lar = Integer.parseInt(line.nextToken());
					int veh = Integer.parseInt(line.nextToken());
					int ars = Integer.parseInt(line.nextToken());
					CityCrimeData toAdd = new CityCrimeData(cityName,pop,vio,mur,rob,aslt,prop,bur,lar,veh,ars);
					crimeByCity.add(toAdd);
				}
			}
			else {
				throw new FileNotFoundException();
			}
		}
		catch(FileNotFoundException FNFE) {
			System.out.println("Error reading crime data");
			System.exit(1);
		}
	}
	
	/**
	 * processCrimeData - Method for processing the data from the file.
	 *
	 * returns statistics
	 */
	public StateCrimeStats processCrimeData() {
		int totalPop = 0;
		int totalVio = 0;
		int totalNonVeh = 0;
		double currentHighestRate = -22;
		double currentCityRate = 0;
		CityCrimeData highest = new CityCrimeData("not set",0,0,0,0,0,0,0,0,0,0);
		
		for(int i = 0; i < crimeByCity.size(); i++) {
			CityCrimeData currentCity = crimeByCity.get(i);
			totalPop += currentCity.population;
			totalVio += currentCity.violentCrimeCount;
			totalNonVeh += currentCity.burglaryCount + currentCity.robberyCount + currentCity.larcentyCount;
			currentCityRate = calculateCrimeRate(currentCity.propertyCount, currentCity.population);
			if (currentCityRate > currentHighestRate) {
				currentHighestRate = currentCityRate;
				highest = currentCity;
			}
		}
		StateCrimeStats toReturn = new StateCrimeStats(stateName, totalPop, totalVio, totalNonVeh, highest.cityName, currentHighestRate);
		return toReturn;
	}
	
	/**
     * calculateCrimeData - Calculates the crime data
     *
     * @param
     *	propertyCount -		int
     *	population -		int
     */
	private double calculateCrimeRate(int propertyCount, int population) {
		if(population > 0) {
			double crimeRate = ((double)propertyCount/(double)population) * 100000;
			return crimeRate;
		}
		else {
			return -1;
		}
	}
}