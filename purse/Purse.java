import java.util.ArrayList;

/**
    A purse holds a collection of coins.
*/
public class Purse
{
    private ArrayList<Coin> coins;
    /**
        Constructs an empty purse.
    */
    public Purse()
    {
        coins = new ArrayList<Coin>();
    }

    /**
        Add a coin to the purse.
        @param aCoin the coin to add
    */
    public void add(Coin aCoin)
    {
        coins.add(aCoin);
    }

    /**
        Get the total value of the coins in the purse.
        @return the sum of all coin values
    */
    public double getTotal()
    {
        double total = 0;
        for (Coin coin : coins)
        {
            total += coin.getValue();
        }
        return total;
    }

    /**
      Counts the number of coins in the purse
      @return the number of coins
    */
    public int count()
    {
        return coins.size();
    }

    /**
      Tests if the purse has a coin that matches
      a given coin.
      @param aCoin the coin to match
      @return true if there is a coin equal to aCoin
    */
    public boolean find(Coin aCoin)
    {
        return coins.contains(aCoin);
    }

    /**
      Counts the number of coins in the purse that match
      a given coin.
      @param aCoin the coin to match
      @return the number of coins equal to aCoin
    */
    public int count(Coin aCoin)
    {
        int count = 0;
        for (Coin coin : coins)
        {
            if (coin.equals(aCoin))
            {
                count++;
            }
        }
        return count;
    }

    /**
      Finds the coin with the largest value. 
      (Precondition: The purse is not empty)
      @return a coin with maximum value in this purse
    */
    public Coin getMaximum()
    {
        Coin maxCoin = coins.get(0);
        for (Coin coin : coins)
        {
            if (coin.getValue() > maxCoin.getValue())
            {
                maxCoin = coin;
            }
        }
        return maxCoin;
    }

    /**
      Adds coins in the purse - use for-each loop
      Comment on this implementation
      if any issues come up.
    */
    public void addCoin(ArrayList<Coin> aCoins)
    {
        for (Coin coin : aCoins)
        {
            coins.add(coin);
        }
    }

    /**
      Deletes coins in the purse - use for-each loop to find all "coins"
      Comment on this implementation if any issues come up.
      @return an object of Coin      
    */
    public Coin deleteCoin(Coin aCoin)
    {
        // I am assuming that we delete all copies of aCoin in the purse and return aCoin
        ArrayList<Coin> remaining = new ArrayList<Coin>(); // this is used to avoid ConcurrentModificationException
        for (Coin coin : coins)
        {
            if (!coin.equals(aCoin))
            {
                remaining.add(coin);
            }
        }
        coins = remaining;
        return aCoin;
    }

    /**
      Deletes the first instance of aCoin
      @return an object of Coin
    */
    public Coin deleteSingleCoin(Coin aCoin)
    {
        for (Coin coin : coins)
        {
            if (coin.equals(aCoin))
            {
                coins.remove(coin);
                return coin;
            }
        }
        return null;
    }

    /**
      Converts the purse to a string.
      @return a string describing the purse
    */
    public String toString()
    {
        return String.format("Purse {coins = %s, total = $%.2f}", coins, getTotal());
    }
}