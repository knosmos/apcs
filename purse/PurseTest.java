/*
Modify the Purse Links to an external site.class to be implemented with ArrayList<Coin> and to use a
for-each loop, and implement the missing methods.

Finally, write a driver, PurseTest.java to demonstrate the behavior of the for-each loop performance.
Whenever there is a change on the Purse object, you should have a before and after.
The test or driver class, PurseTest should demonstrate the performance of all the methods implemented in the Purse ADT.

Jieruei Chang
Java 11
2/10/2023
*/

import java.util.ArrayList;

public class PurseTest
{
    public static void main(String[] args)
    {
        // Initialize
        Purse purse = new Purse();
        System.out.println(purse); // Show empty purse

        // Add coins to purse
        System.out.println("Adding single coin to purse");
        purse.add(new Coin(0.50, "half dollar"));
        System.out.println("Purse is now: " + purse);

        System.out.println("Adding coins to purse");
        ArrayList<Coin> coinsToAdd = new ArrayList<Coin>();
        coinsToAdd.add(new Coin(0.25, "quarter"));
        coinsToAdd.add(new Coin(0.25, "quarter"));
        coinsToAdd.add(new Coin(0.25, "quarter"));
        coinsToAdd.add(new Coin(0.10, "dime"));
        coinsToAdd.add(new Coin(0.10, "dime"));
        coinsToAdd.add(new Coin(0.05, "nickel"));
        purse.addCoin(coinsToAdd);
        System.out.println(purse); // This also shows the getTotal method

        // Show count method
        System.out.println("Number of coins: " + purse.count());
        System.out.println("Number of quarters: " + purse.count(new Coin(0.25, "quarter")));
        System.out.println("Number of dimes: " + purse.count(new Coin(0.10, "dime")));

        // Show find method
        System.out.println("Is there a quarter? " + purse.find(new Coin(0.25, "quarter")));
        System.out.println("Is there a penny? " + purse.find(new Coin(0.01, "penny")));

        // Show getMaximum method
        System.out.println("Maximum coin: " + purse.getMaximum());

        // Show remove methods
        System.out.println("Removing all quarters from " + purse);
        purse.deleteCoin(new Coin(0.25, "quarter"));
        System.out.println("Purse is now " + purse);
        System.out.println("Removing one dime from " + purse);
        purse.deleteSingleCoin(new Coin(0.10, "dime"));
        System.out.println("Purse is now " + purse);
    }
}

/*
SAMPLE RUN

Purse {coins = [], total = $0.00}
Adding single coin to purse
Purse is now: Purse {coins = [(half dollar, $0.50)], total = $0.50}
Adding coins to purse
Purse {coins = [(half dollar, $0.50), (quarter, $0.25), (quarter, $0.25), (quarter, $0.25), (dime, $0.10), (dime, $0.10), (nickel, $0.05)], total = $1.50}
Number of coins: 7
Number of quarters: 3
Number of dimes: 2
Is there a quarter? true
Is there a penny? false
Maximum coin: (half dollar, $0.50)
Removing all quarters from Purse {coins = [(half dollar, $0.50), (quarter, $0.25), (quarter, $0.25), (quarter, $0.25), (dime, $0.10), (dime, $0.10), (nickel, $0.05)], total = $1.50}
Purse is now Purse {coins = [(half dollar, $0.50), (dime, $0.10), (dime, $0.10), (nickel, $0.05)], total = $0.75}
Removing one dime from Purse {coins = [(half dollar, $0.50), (dime, $0.10), (dime, $0.10), (nickel, $0.05)], total = $0.75}
Purse is now Purse {coins = [(half dollar, $0.50), (dime, $0.10), (nickel, $0.05)], total = $0.65}

The tester is deterministic but you wanted this to run multiple times so here is the same output:

Purse {coins = [], total = $0.00}
Adding single coin to purse
Purse is now: Purse {coins = [(half dollar, $0.50)], total = $0.50}
Adding coins to purse
Purse {coins = [(half dollar, $0.50), (quarter, $0.25), (quarter, $0.25), (quarter, $0.25), (dime, $0.10), (dime, $0.10), (nickel, $0.05)], total = $1.50}
Number of coins: 7
Number of quarters: 3
Number of dimes: 2
Is there a quarter? true
Is there a penny? false
Maximum coin: (half dollar, $0.50)
Removing all quarters from Purse {coins = [(half dollar, $0.50), (quarter, $0.25), (quarter, $0.25), (quarter, $0.25), (dime, $0.10), (dime, $0.10), (nickel, $0.05)], total = $1.50}
Purse is now Purse {coins = [(half dollar, $0.50), (dime, $0.10), (dime, $0.10), (nickel, $0.05)], total = $0.75}
Removing one dime from Purse {coins = [(half dollar, $0.50), (dime, $0.10), (dime, $0.10), (nickel, $0.05)], total = $0.75}
Purse is now Purse {coins = [(half dollar, $0.50), (dime, $0.10), (nickel, $0.05)], total = $0.65}
*/