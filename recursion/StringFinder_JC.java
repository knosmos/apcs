/*
Write a program, StringFinder_YI.java that implements a recursive search of a
sorted list of strings. Your program should include a recursive method that
determines whether or not a given String is present within a sorted array (or,
if you choose, an ArrayList) by searching successively smaller segments of the
list. Include a test driver that prompts the user for strings to be searched.
The user should enter one string per line, with an empty line indicating the end
of the series.

After the sorted list of strings has been entered, the program should prompt
the user for a search string. The program should then print a message stating
whether or not the search string was found in the list, the total number of
strings in the list, and the number of comparisons made while looking for the
search string.

Jieruei Chang
Java 11
4/18/23
*/

import java.util.*;

public class StringFinder_JC {
    public static ArrayList<String> list = new ArrayList<String>();
    public static int comparisons = 0;
    public static String search = "";

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a list of strings, one per line, and an empty line to end.");
        String input = sc.nextLine();
        while (!input.equals("")) {
            list.add(input);
            input = sc.nextLine();
        }

        Collections.sort(list);
        System.out.println("The sorted list of strings is: " + list + ".");
        System.out.println("Enter a string to search for.");
        search = sc.nextLine();

        if (rfn(0, list.size()-1)) {
            System.out.println("The string was found.");
        } else {
            System.out.println("The string was not found.");
        }

        System.out.println("The total number of strings in the list is " + list.size() + ".");
        System.out.println("The number of comparisons made while looking for the search string is " + comparisons + ".");
	}

    // recursive binary search
	public static boolean rfn(int i, int j) {
        comparisons++;
        if (i == j) { // base case
            System.out.println();
            return list.get(i).equals(search);
        }
        // divide and conquer
        int mid = (i + j) / 2;
        System.out.println("left: " + i + " | mid: " + mid + " | right: " + j);
        if (list.get(mid).compareTo(search) >= 0) {
            return rfn(i, mid);
        }
        return rfn(mid + 1, j);
	}
}

/*
SAMPLE RUN.

Enter a list of strings, one per line, and an empty line to end.
abc
def
ghi
jkl
mno
pqr
stu
vwx
yza
bcd

The sorted list of strings is: [abc, bcd, def, ghi, jkl, mno, pqr, stu, vwx, yza].
Enter a string to search for.
mno
left: 0 | mid: 4 | right: 9
left: 5 | mid: 7 | right: 9
left: 5 | mid: 6 | right: 7
left: 5 | mid: 5 | right: 6

The string was found.
The total number of strings in the list is 10.
The number of comparisons made while looking for the search string is 5.

Enter a list of strings, one per line, and an empty line to end.
abc
def
ghi
jkl
mno
pqr
stu
vwx
yza
bcd

The sorted list of strings is: [abc, bcd, def, ghi, jkl, mno, pqr, stu, vwx, yza].
Enter a string to search for.
xkcd
left: 0 | mid: 4 | right: 9
left: 5 | mid: 7 | right: 9
left: 8 | mid: 8 | right: 9

The string was not found.
The total number of strings in the list is 10.
The number of comparisons made while looking for the search string is 4.
*/