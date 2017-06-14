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
import java.util.StringTokenizer;
import java.util.*;
import java.util.Formatter;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.SecurityException;
import java.util.FormatterClosedException;

public class CrimeDataDriver {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter state name: ");
		String stateName = in.next();
		File state = new File(stateName+".ser");
		if(state.exists()) {
			System.out.println("Loading existing data...");
			
			try {
				FileInputStream inputFileStream = new FileInputStream(stateName + ".ser");
				ObjectInputStream objectInputStream = new ObjectInputStream(inputFileStream);
				StateCrimeStats deserializedState = (StateCrimeStats)objectInputStream.readObject();
				objectInputStream.close();
				inputFileStream.close();
				System.out.printf("%s", deserializedState.toString());
			}
			catch(IOException IOE)
			{
				System.err.println("Error reading crime data");
				System.exit(1);
			}
			catch(ClassNotFoundException CNFE)
			{
				 System.err.println("Unable to create object.");
				 System.exit(1);

			}
		}
		else {
			try {
				System.out.println("Processing new data...");
				StateCrimeData stateCrime = new StateCrimeData();
				stateCrime.readCrimeData(stateName);
				StateCrimeStats toSave = stateCrime.processCrimeData();
				System.out.printf("%s", stateCrime.processCrimeData().toString());
				ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(stateName + ".ser"));
				output.writeObject(toSave);
				System.out.printf("\n%s's stats saved\n", stateName);
			}
			catch(IOException IOE)
			{
				System.err.println("Error writing to file.");
				System.exit(1);

			}
			


		}
	}
}