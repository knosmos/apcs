/*
A simple class to store Telephone numbers and associated names.

Jieruei Chang
Java 11
3/3/2023
*/

public class Telephone {
    String name;
    String number;
    public Telephone(String name, String number) {
        this.name = name;
        this.number = number;
    }
    public String getName() {
        return this.name;
    }
    public String getNumber() {
        return this.number;
    }
    public String toString() {
        return String.format("%s | %s", this.name, this.number);
    }
}