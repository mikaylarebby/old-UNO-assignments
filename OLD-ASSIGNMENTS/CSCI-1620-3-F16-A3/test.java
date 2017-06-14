import java.util.Scanner;

public class test {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		//System.out.println("Enter value desired:");
		//int valueX = in.nextInt();
		int[] data = new int[10];
		//data[0] = 1;
		//data[1] = 2;
		//data[2] = 3;
		//System.out.printf("Position is %d\n",linearSearchRecursive(data, value, 0));
		//System.out.println("Enter DNA desired:");
		//String value = in.next();
		//System.out.printf("Hash value is %d\n", stringHash(value));
		RabinKarpHashes(data,9,2);
		
	}
	private static int linearSearchRecursive(int[] data, int key, int pos) {
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
	//Hash the string
	public static int stringHash(String s){
		int totalHash = 0;
		int start = s.length();
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A') {
				totalHash += Math.pow(0*4, start);
			}
			if (s.charAt(i) == 'C') {
				totalHash += Math.pow(1*4, start);;
			}
			if (s.charAt(i) == 'G') {
				totalHash += Math.pow(2*4, start);;
			}
			if (s.charAt(i) == 'T') {
				totalHash += Math.pow(3*4, start);;
			}
			start = start - 1;
		}
		return totalHash;
	}
	//RK Hashes
	public static int RabinKarpHashes(int[] hashes, int pos, int length) {
		String strand = "ATCGATCGATCGA";
		String sub = "";
		if(pos < length) {
			return -1;
		}
		else {
			sub = strand.substring(pos - length,pos);

			if(sub.length() == length){
				hashes[pos] = stringHash(sub);
				System.out.println(hashes[pos] + " " + sub + " " + pos);
			}
			pos = pos - 1;
		}
		return RabinKarpHashes(hashes,pos,length);
		
	}
}