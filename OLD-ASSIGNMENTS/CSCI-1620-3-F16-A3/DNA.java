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
package Recursion.DNA;
import Recursion.Exception.*;
public class DNA {
	
	private String strandString;
	private DNA bestMatch;
	private String substringMatch;
	
	/**
     * Constructor for DNA.
     *
     * @param strand	the string of DNA
     *
     */
	public DNA(String strand) {
		strandString = setStrand(strand);
		bestMatch = null;
		substringMatch = "";
		
	}
	
	/**
     * Gets value of strand
     *
     * @return	returns strandString
     *
     */
	public String getStrand() {
		return strandString;
	}
	
	/**
     * Sets new value for strand
     *
     * @param strand	the string of DNA
     *
     */
	public String setStrand(String strand) {
		strand = strand.toUpperCase();
		boolean set = true;
		if(strand.length() > 15) {
			throw new InvalidDNAStrandException();
		}
		for(int i = 0; i < strand.length(); i++){
			char check = strand.charAt(i);
			if((check == 'A') || (check == 'C') || (check == 'T') || (check == 'G')) {
				
			}
			else {
				throw new InvalidDNAStrandException(check);
			}
		}
		return strand;
	}
	/**
     * Searches through the array looking for the pos
     * (if it exists) of the desired hash
     *
     * @param data	the array of data
     * 		  key	the hash you are looking for
     * 		  pos	the position in the array
     *
     * returns position
     */
	private int linearSearchRecursive(int[] data, int key, int pos) {
		//Base Case
		if(pos == -1 || data[pos] == key) {
			return pos;
		}
		//General Case
		else {
			if(pos >= data.length - 1) {
				pos = -1;
			}
			else {
				pos ++;
			}
			return linearSearchRecursive(data, key, pos);
		}
	}
	/**
     * String Hash
     *
     * @param s   The string to be hashed
     *
     * returns hash value
     */
	//A = 0, C = 1, G = 2, T = 3 - Hash the string
	private int stringHash(String s){
		int totalHash = 0;
		int start = s.length();
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				totalHash += Math.pow(0*4, start);
			}
			if (s.charAt(i) == 'C') {
				totalHash += Math.pow(1*4, start);
			}
			if (s.charAt(i) == 'G') {
				totalHash += Math.pow(2*4, start);
			}
			if (s.charAt(i) == 'T') {
				totalHash += Math.pow(3*4, start);
			}
			start = start - 1;
		}
		return totalHash;
	}
	//charNumericValue
	/**
     * Char numeric value
     *
     * @param c	char to be hashed.
     *
     * returns numeric value.
     * (I found it easier to combine the stringHash method than use this)
     */
	private int charNumericValue(char c) {
		if (c == 'A') {
			return 0;
		}
		if (c == 'C') {
			return 1;
		}
		if (c == 'G') {
			return 2;
		}
		if (c == 'T') {
			return 3;
		}
		else {
			return -1;
		}
	}
	/**
     * RabinKarp Hashes
     *
     * @param hashes	array that will store the hashes
     * 		  pos		position
     * 		  length	the length of substring
     * 
     * returns hashes array
     */
	private int[] RabinKarpHashes(int[] hashes, int pos, int length) {
		String strand = this.getStrand();
		String sub = "";
		if(pos < length || length < 1) {
			return hashes;
		}
		else {
			sub = strand.substring(pos - length, pos);

			if(sub.length() == length){
				hashes[pos - 1] = stringHash(sub);
			}
			pos = pos - 1;
		}
		return RabinKarpHashes(hashes,pos,length);
	}
	/**
     * RabinKarp
     *
     * @param find	The string you are looking for
     *
     * returns position in array of the hash
     *
     */
	private int RabinKarp(String find) {
		String search = getStrand();
		if (find.length() > search.length()) {
			return -1;
		}
		else {
			int[] data = new int[strandString.length()];
			return linearSearchRecursive(RabinKarpHashes(data, data.length, find.length()), stringHash(find), 0);
		}
		
	}
	/**
     * Check match
     *
     * @param matchCanidate		DNA to be matched
     *
     * if it finds a better substring, will replace it. 
     *
     */
	public void checkMatch(DNA matchCanidate) {
		String matchStrand = matchCanidate.getStrand();
		if(matchStrand.length() < substringMatch.length()) {
	
		}
		else { 
			for(int i = matchStrand.length(); i > substringMatch.length(); i--) {
				matchStrand = matchStrand.substring(0,i);
				if (this.RabinKarp(matchStrand) > -1) {
					substringMatch = matchStrand;
					bestMatch = new DNA(matchCanidate.getStrand());
					break;
				}
			}
			
		}
		
	};
	/**
     * To String
     *
     * returns string to be output
     *
     */
	@Override
	public String toString() {
		String output = String.format("DNA Strand %s", getStrand());
		if(bestMatch == null) {
			output += String.format("\nNo match found\n");
		}
		else {
			output += String.format("\nBest Match Strand: %s\nMatching Substring: %s\n", bestMatch.getStrand(), substringMatch);
		}
		return output;
	}
	
}