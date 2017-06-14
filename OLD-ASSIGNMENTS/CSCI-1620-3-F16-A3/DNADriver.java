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
import Recursion.DNA.DNA;
import Recursion.Exception.InvalidDNAStrandException;
import java.util.Scanner;

public class DNADriver {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String args[]) {
		DNA master;
		DNA canidate;
		boolean repeat = true;
		do {	
			try {
				System.out.println("Enter molecule string for master DNA strand: ");
				String strand = in.next();
				master = new DNA(strand);
				repeat = false;
			}
			catch(InvalidDNAStrandException IDSE) {
				System.out.printf("%s, try again.\n", IDSE);
				String strand = in.next();
				master = new DNA(strand);
			}
		}while(repeat);
		repeat = true;
		do {
			System.out.println("Enter molecule string for comparison or EXIT to quit: ");
			String check = in.next();
			if(check.toUpperCase().equals("EXIT")) {
				System.out.println(master.toString());
				repeat = false;
			}
			else {
				try {
					canidate = new DNA(check);
					master.checkMatch(canidate);
				}
				catch(InvalidDNAStrandException IDSE) {
					System.out.printf("\n%s, strand ignored.\n", IDSE);
				}
			}
		}while(repeat);
	}
}
