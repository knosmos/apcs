/*
Create a class HugeInteger which uses a 40-element array of digits to store integers as large as
40 digit long. Provide methods parse, toString, add and subtract to manipulate objects of HugeInteger.
For comparing HugeInteger objects, provide the following methods:
isEqualTo, isGreaterThan, isLessThan, isGreaterThanOrEqualTo and isLessThanOrEqualTo
Also provide a predicate method isZero.

Jieruei Chang
12/15/22
Java 11
*/

public class HugeInteger_JC {
    public final static int MAXLEN = 40;

    /* INSTANCE FIELDS */
    private int sign;
    private int[] digits = new int[MAXLEN];

    /* CONSTRUCTOR */
    public HugeInteger_JC(String digitString) {
        parse(digitString);
    }

    /* Overloaded constructor used in internal adding and subtracting methods to create "empty" HugeIntegers */
    public HugeInteger_JC() {
        sign = 1;
    }

    /* Overloaded constructor used to clone objects */
    public HugeInteger_JC(HugeInteger_JC source) {
        parse(source.toString());
    }

    /* Parse string into digitArray */
    public void parse(String digitString) {
        // Get sign of HugeInteger (1 or -1)
        if (digitString.charAt(0) == '-') {
            sign = -1;
            digitString = digitString.substring(1); // remove the - character from the digitString
        }
        else {
            sign = 1;
        }
        
        // Convert each character in digitString to an integer and store it in digits array
        for (int i = 0; i<digitString.length(); i++) {
            // we need to start at index MAXLEN - length of string
            // the uninitialized values default to 0
            digits[MAXLEN - digitString.length() + i] = Character.getNumericValue(
                digitString.charAt(i)
            );
        }
    }

    /* output string representation of HugeInteger */
    public String toString() {
        StringBuilder digitStringBuilder = new StringBuilder();
        // add sign
        if (sign == -1) {
            digitStringBuilder.append("-");
        }
        // add digits
        int firstNonzeroIndex = MAXLEN - 1;
        for (int i=0; i<MAXLEN; i++) {
            if (digits[i] != 0) {
                firstNonzeroIndex = i;
                break;
            }
        }
        for (int i=firstNonzeroIndex; i<MAXLEN; i++) {
            digitStringBuilder.append(digits[i]);
        }
        return digitStringBuilder.toString();
    }

    /* ARITHMETIC  */
    /* adds two HugeIntegers together and returns the result */
    public HugeInteger_JC add(HugeInteger_JC other) {
        /* Handle edge cases */
        // Both numbers negative
        if (this.isNegative() && other.isNegative()) {
            // returns the opposite of the sum of the absolute values
            HugeInteger_JC num1 = new HugeInteger_JC(this);
            HugeInteger_JC num2 = new HugeInteger_JC(other);
            num1.flipSign();
            num2.flipSign();

            HugeInteger_JC sum = num1.add(num2);
            sum.flipSign();
            return sum;
        }

        // First number negative
        else if (this.isNegative()) {
            // return other - |this|
            HugeInteger_JC num1 = new HugeInteger_JC(this);
            num1.flipSign();
            return other.subtract(num1);
        }

        // Second number negative
        else if (other.isNegative()) {
            // return this - |other|
            HugeInteger_JC num2 = new HugeInteger_JC(other);
            num2.flipSign();
            return this.subtract(num2);
        }
        
        /* Adding time! */
        // Initialize result HugeInteger
        HugeInteger_JC result = new HugeInteger_JC();
        int carry = 0;
        
        // iterate backwards through digitlist
        for (int i=MAXLEN-1; i>0; i--) {
            // modulo 10 goes to result, integer division by 10 goes to carry
            int digitSum = carry + this.getDigit(i) + other.getDigit(i);
            result.setDigit(i, digitSum % 10);
            carry = digitSum / 10;
        }
        return result;
    }

    /* subtracts `other` from the current HugeInteger and returns the result */
    public HugeInteger_JC subtract(HugeInteger_JC other) {
        /* Handle edge cases */
        // both numbers negative
        if (this.isNegative() && other.isNegative()) {
            // Return opposite of difference of absolute values of numbers
            HugeInteger_JC num1 = new HugeInteger_JC(this);
            HugeInteger_JC num2 = new HugeInteger_JC(other);
            num1.flipSign();
            num2.flipSign();
            HugeInteger_JC result = num1.subtract(num2);
            result.flipSign();
            return result;
        }

        // first number negative
        if (this.isNegative()) {
            // Return opposite of sum of absolute values of numbers
            HugeInteger_JC num1 = new HugeInteger_JC(this);
            num1.flipSign();
            HugeInteger_JC result = num1.add(other);
            result.flipSign();
            return result;
        }
        
        // second number negative
        if (other.isNegative()) {
            // Return sum of absolute value of numbers
            HugeInteger_JC num2 = new HugeInteger_JC(other);
            num2.flipSign();
            return this.add(num2);
        }
        
        // first number < second number
        if (other.isGreaterThan(this)) {
            // Return negative of second-first
            HugeInteger_JC result = other.subtract(this);
            result.flipSign();
            return result;
        }

        /* Subtracting time! */
        // Initialize result HugeInteger
        HugeInteger_JC result = new HugeInteger_JC();
        int carry = 0;

        // iterate backwards through digitlist
        for (int i=MAXLEN-1; i>0; i--) {
            // modulo 10 goes to result, integer division by 10 goes to carry
            int digitDiff = this.getDigit(i) - other.getDigit(i) - carry;
            if (digitDiff < 0) {
                carry = 1;
                digitDiff += 10;
            }
            else {
                carry = 0;
            }
            result.setDigit(i, digitDiff);
        }
        return result;
    }

    /* COMPARISON METHODS */
    /* Test if a HugeInteger is equal to another HugeInteger */
    public boolean isEqualTo(HugeInteger_JC other) {
        // Handle negative numbers
        if (this.isNegative() != other.isNegative() && !this.isZero()) {
            return false;
        }
        // Run through each digit and test for equality
        for (int i=0; i<MAXLEN; i++) {
            if (this.getDigit(i) != other.getDigit(i)) {
                return false;
            }
        }
        return true;
    }

    /* Tests if a HugeInteger is greater than another HugeInteger */
    public boolean isGreaterThan(HugeInteger_JC other) {
        // Handle negative numbers
        if (this.isZero() && other.isZero()) {
            return false;
        }
        else if (this.isNegative() && !other.isNegative()) {
            return false;
        }
        else if (!this.isNegative() && other.isNegative()) {
            return true;
        }
        // Run through each digit and test for which is greater
        else if (this.isNegative() && other.isNegative()) {
            for (int i=0; i<MAXLEN; i++) {
                if (this.getDigit(i) > other.getDigit(i)) {
                    return false;
                }
                else if (this.getDigit(i) < other.getDigit(i)) {
                    return true;
                }
            }
            return false;
        }
        for (int i=0; i<MAXLEN; i++) {
            if (this.getDigit(i) > other.getDigit(i)) {
                return true;
            }
            else if (this.getDigit(i) < other.getDigit(i)) {
                return false;
            }
        }
        return false;
    }

    /* Test if a HugeInteger is less than another */
    public boolean isLessThan(HugeInteger_JC other) {
        return other.isGreaterThan(this);
    }

    /* Test if a HugeInteger >= another */
    public boolean isGreaterThanOrEqualTo(HugeInteger_JC other) {
        return this.isGreaterThan(other) || this.isEqualTo(other);
    }

    /* Test if a HugeInteger <= another */
    public boolean isLessThanOrEqualTo(HugeInteger_JC other) {
        return this.isLessThan(other) || this.isEqualTo(other);
    }

    /* Test if a HugeInteger is zero */
    public boolean isZero() {
        for (int i=MAXLEN-1; i>0; i--) {
            if (this.getDigit(i) != 0) {
                return false;
            }
        }
        return true;
    }

    /* ACCESSOR & MUTATOR METHODS */
    /* tests if a HugeInteger is negative */
    public boolean isNegative() {
        return sign == -1;
    }

    /* flips sign of HugeInteger from + to - and vice versa */
    public void flipSign() {
        sign *= -1;
    }

    /* get value at digit */
    public int getDigit(int digit) {
        // digit is the index in the digits array
        return digits[digit];
    }

    /* set value at digit */
    public void setDigit(int digit, int val) {
        digits[digit] = val;
    }
}
