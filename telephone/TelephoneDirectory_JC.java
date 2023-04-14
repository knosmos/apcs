/*
Write a telephone lookup program, TelephoneDirectory_YI.java. Create a class Telephone with two
instance fields, number, and name. TelephoneDirectory ADT handles lookups by name and also reverse
lookups by phone number. Use a binary search for both lookups.

Jieruei Chang
Java 11
3/3/2023
*/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TelephoneDirectory_JC {
    public static ArrayList<Telephone> people;

    public static ArrayList<Integer> sortedByNum; // indices of people sorted by number
    public static ArrayList<Integer> sortedByName; // indices of people sorted by name

    public static void main(String[] args) {
        System.out.println("O(logn) Phone Book (c) 1997");
        System.out.println("===========================");

        // Load data
        people = new ArrayList<Telephone>();
        loadData("telephoneData.txt");

        // Initialize lookup lists
        // Instead of duplicating `people` twice we use this to save memory
        sortedByNum = new ArrayList<Integer>();
        sortedByName = new ArrayList<Integer>();
        for (int i=0; i<people.size(); i++) {
            sortedByNum.add(i);
            sortedByName.add(i);
        }

        // Sort lookup lists in accordance with custom comparator
        Comparator<Integer> numComparator = Comparator.comparing(c -> people.get(c).getNumber());
        sortedByNum.sort(numComparator);
        
        Comparator<Integer> nameComparator = Comparator.comparing(c -> people.get(c).getName());
        sortedByName.sort(nameComparator);

        System.out.printf("INITIALIZATION COMPLETE. %d RECORDS LOADED.\n", people.size());

        // Query input and handling
        boolean stopIterationLoop;
        Scanner sc = new Scanner(System.in);
        do {    
            System.out.print("ENTER MODE. 1 = LOOK UP NUMBER, 0 = REVERSE LOOK UP NAME: ");
            boolean mode = sc.nextInt() > 0;
            sc.nextLine();
            if (mode) {
                System.out.print("ENTER NAME FOR LOOKUP: ");
                String name = sc.nextLine();
                int result = binarySearch(name, true);
                if (result == -1) {
                    System.out.println("NO MATCHES FOUND.");
                }
                else {
                    System.out.println("MATCH FOUND: " + people.get(sortedByName.get(result)).getNumber());
                }
            }
            else {
                System.out.print("ENTER NUMBER FOR REVERSE LOOKUP: ");
                String num = sc.nextLine();
                int result = binarySearch(num, false);
                if (result == -1) {
                    System.out.println("NO MATCHES FOUND.");
                }
                else {
                    System.out.println("MATCH FOUND: " + people.get(sortedByNum.get(result)).getName());
                }
            }
            System.out.print("CONTINUE? (Y/n) ");
            stopIterationLoop = sc.nextLine().equals("n");
        } while (!stopIterationLoop);
        sc.close();
    }

    // Finds earliest index of item in people
    // mode false: search by number
    // mode true: search by name
    public static int binarySearch(String item, boolean mode) {
        ArrayList<Integer> searchList = mode ? sortedByName : sortedByNum;
        int lo = 0;
        int hi = searchList.size() + 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            String other = mode ?
                people.get(searchList.get(mid)).getName() :
                people.get(searchList.get(mid)).getNumber(); // set sorting criteria
            // set upper bound
            if (item.compareTo(other) <= 0) {
                hi = mid;
            }
            // set lower bound
            else {
                lo = mid + 1;
            }
        }
        // check if person was found
        Telephone person = people.get(searchList.get(lo));
        if (!item.equals(
            mode ?
                person.getName() :
                people.get(searchList.get(lo)).getNumber()
        )) {
            return -1; // no matches
        }
        return lo;
    }

    // Load data and generate Telephone Arraylist
    public static void loadData(String filename) {
        File file;
        Scanner sc;
        try {
            file = new File(filename);
            sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] data = line.split(", ");
                String name = data[1] + " " + data[0]; // change from "Last, First" to "First Last"
                String number = data[2];
                people.add(new Telephone(name, number));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}

/*
SAMPLE RUN.

O(logn) Phone Book (c) 1997
===========================
INITIALIZATION COMPLETE. 113 RECORDS LOADED.
ENTER MODE. 1 = LOOK UP NUMBER, 0 = REVERSE LOOK UP NAME: 1
ENTER NAME FOR LOOKUP: Graciela Elia
MATCH FOUND: 217-382-1047
CONTINUE? (Y/n) y
ENTER MODE. 1 = LOOK UP NUMBER, 0 = REVERSE LOOK UP NAME: 1
ENTER NAME FOR LOOKUP: Anna Eaton
MATCH FOUND: 742-649-3025
CONTINUE? (Y/n)  
ENTER MODE. 1 = LOOK UP NUMBER, 0 = REVERSE LOOK UP NAME: 1
ENTER NAME FOR LOOKUP: Jieruei Chang
NO MATCHES FOUND.
CONTINUE? (Y/n) 
ENTER MODE. 1 = LOOK UP NUMBER, 0 = REVERSE LOOK UP NAME: 0
ENTER NUMBER FOR REVERSE LOOKUP: 289-756-3486
MATCH FOUND: Sudeiman Khalid
CONTINUE? (Y/n) 
ENTER MODE. 1 = LOOK UP NUMBER, 0 = REVERSE LOOK UP NAME: 0
ENTER NUMBER FOR REVERSE LOOKUP: 820-451-0945         
MATCH FOUND: Mehmen Khalid
CONTINUE? (Y/n) y
ENTER MODE. 1 = LOOK UP NUMBER, 0 = REVERSE LOOK UP NAME: 0
ENTER NUMBER FOR REVERSE LOOKUP: 123-456-7890
NO MATCHES FOUND.
CONTINUE? (Y/n) n
*/