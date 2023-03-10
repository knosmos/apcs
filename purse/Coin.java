/**
A coin with a monetary value.
 */
public class Coin
{
    /**
    Constructs a coin.
    @param aValue the monetary value of the coin.
    @param aName the name of the coin
     */
    public Coin(double aValue, String aName)
    {
        value = aValue;
        name = aName;
    }

    /**
    Gets the coin value.
    @return the value
     */
    public double getValue()
    {
        return value;
    }

    /**
    Gets the coin name.
    @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
      Formats the coin into a string.
      @return the string representation of the coin
     */
    public String toString()
    {
        return String.format("(%s, $%.2f)", name, value);
    }

    /**
      Compares two coins for equality.
      @param otherObject the other coin
      @return true if the coins have the same value
     */
    public boolean equals(Object otherObject)
    {
        Coin other = (Coin)otherObject;
        return name.equals(other.name)
        && value == other.value;
    }

    private double value;
    private String name;
}