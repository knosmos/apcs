/*
Write a recursive definition of i * j (integer multiplication), where i > 0.
Define the multiplication process in terms of integer addition.
For example, 4 * 7 is equal to 7 added to itself 4 times.

Jieruei Chang
Java 11
4/18/23
*/

import java.io.*;
import java.util.StringTokenizer;

public class ijIntProd_JC {
	public static void main(String[] args) throws IOException {
		for (int i=1; i<15; i++) {
			for (int j=i; j<15; j++) {
				System.out.println(String.format("The integer %s times the integer %s is equal to %d.", i, j, rfn(i,j)));
			}
		}
	}

	public static int rfn(int i, int j) {
		if (j == 1) { // base case
			return i;
		}
		return i + rfn(i, j-1);
	}
}

/*
SAMPLE RUN.

The integer 1 times the integer 1 is equal to 1.
The integer 1 times the integer 2 is equal to 2.
The integer 1 times the integer 3 is equal to 3.
The integer 1 times the integer 4 is equal to 4.
The integer 1 times the integer 5 is equal to 5.
The integer 1 times the integer 6 is equal to 6.
The integer 1 times the integer 7 is equal to 7.
The integer 1 times the integer 8 is equal to 8.
The integer 1 times the integer 9 is equal to 9.
The integer 1 times the integer 10 is equal to 10.
The integer 1 times the integer 11 is equal to 11.
The integer 1 times the integer 12 is equal to 12.
The integer 1 times the integer 13 is equal to 13.
The integer 1 times the integer 14 is equal to 14.
The integer 2 times the integer 2 is equal to 4.
The integer 2 times the integer 3 is equal to 6.
The integer 2 times the integer 4 is equal to 8.
The integer 2 times the integer 5 is equal to 10.
The integer 2 times the integer 6 is equal to 12.
The integer 2 times the integer 7 is equal to 14.
The integer 2 times the integer 8 is equal to 16.
The integer 2 times the integer 9 is equal to 18.
The integer 2 times the integer 10 is equal to 20.
The integer 2 times the integer 11 is equal to 22.
The integer 2 times the integer 12 is equal to 24.
The integer 2 times the integer 13 is equal to 26.
The integer 2 times the integer 14 is equal to 28.
The integer 3 times the integer 3 is equal to 9.
The integer 3 times the integer 4 is equal to 12.
The integer 3 times the integer 5 is equal to 15.
The integer 3 times the integer 6 is equal to 18.
The integer 3 times the integer 7 is equal to 21.
The integer 3 times the integer 8 is equal to 24.
The integer 3 times the integer 9 is equal to 27.
The integer 3 times the integer 10 is equal to 30.
The integer 3 times the integer 11 is equal to 33.
The integer 3 times the integer 12 is equal to 36.
The integer 3 times the integer 13 is equal to 39.
The integer 3 times the integer 14 is equal to 42.
The integer 4 times the integer 4 is equal to 16.
The integer 4 times the integer 5 is equal to 20.
The integer 4 times the integer 6 is equal to 24.
The integer 4 times the integer 7 is equal to 28.
The integer 4 times the integer 8 is equal to 32.
The integer 4 times the integer 9 is equal to 36.
The integer 4 times the integer 10 is equal to 40.
The integer 4 times the integer 11 is equal to 44.
The integer 4 times the integer 12 is equal to 48.
The integer 4 times the integer 13 is equal to 52.
The integer 4 times the integer 14 is equal to 56.
The integer 5 times the integer 5 is equal to 25.
The integer 5 times the integer 6 is equal to 30.
The integer 5 times the integer 7 is equal to 35.
The integer 5 times the integer 8 is equal to 40.
The integer 5 times the integer 9 is equal to 45.
The integer 5 times the integer 10 is equal to 50.
The integer 5 times the integer 11 is equal to 55.
The integer 5 times the integer 12 is equal to 60.
The integer 5 times the integer 13 is equal to 65.
The integer 5 times the integer 14 is equal to 70.
The integer 6 times the integer 6 is equal to 36.
The integer 6 times the integer 7 is equal to 42.
The integer 6 times the integer 8 is equal to 48.
The integer 6 times the integer 9 is equal to 54.
The integer 6 times the integer 10 is equal to 60.
The integer 6 times the integer 11 is equal to 66.
The integer 6 times the integer 12 is equal to 72.
The integer 6 times the integer 13 is equal to 78.
The integer 6 times the integer 14 is equal to 84.
The integer 7 times the integer 7 is equal to 49.
The integer 7 times the integer 8 is equal to 56.
The integer 7 times the integer 9 is equal to 63.
The integer 7 times the integer 10 is equal to 70.
The integer 7 times the integer 11 is equal to 77.
The integer 7 times the integer 12 is equal to 84.
The integer 7 times the integer 13 is equal to 91.
The integer 7 times the integer 14 is equal to 98.
The integer 8 times the integer 8 is equal to 64.
The integer 8 times the integer 9 is equal to 72.
The integer 8 times the integer 10 is equal to 80.
The integer 8 times the integer 11 is equal to 88.
The integer 8 times the integer 12 is equal to 96.
The integer 8 times the integer 13 is equal to 104.
The integer 8 times the integer 14 is equal to 112.
The integer 9 times the integer 9 is equal to 81.
The integer 9 times the integer 10 is equal to 90.
The integer 9 times the integer 11 is equal to 99.
The integer 9 times the integer 12 is equal to 108.
The integer 9 times the integer 13 is equal to 117.
The integer 9 times the integer 14 is equal to 126.
The integer 10 times the integer 10 is equal to 100.
The integer 10 times the integer 11 is equal to 110.
The integer 10 times the integer 12 is equal to 120.
The integer 10 times the integer 13 is equal to 130.
The integer 10 times the integer 14 is equal to 140.
The integer 11 times the integer 11 is equal to 121.
The integer 11 times the integer 12 is equal to 132.
The integer 11 times the integer 13 is equal to 143.
The integer 11 times the integer 14 is equal to 154.
The integer 12 times the integer 12 is equal to 144.
The integer 12 times the integer 13 is equal to 156.
The integer 12 times the integer 14 is equal to 168.
The integer 13 times the integer 13 is equal to 169.
The integer 13 times the integer 14 is equal to 182.
The integer 14 times the integer 14 is equal to 196.
*/