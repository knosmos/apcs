/*
Testing driver for HugeInteger class.
Jieruei Chang
12/15/22
Java 11
*/

public class HugeIntegerTester_JC {
    public static void main(String[] args) {
        // Test Addition
        System.out.println("Addition: Normal");
        HugeInteger_JC h1 = new HugeInteger_JC("242");
        HugeInteger_JC h2 = new HugeInteger_JC("64");
        System.out.println(String.format("Initial values: %s, %s", h1, h2));
        System.out.println(String.format("%s + %s = %s\n", h1, h2, h1.add(h2)));

        System.out.println("Addition: Both Negative");
        HugeInteger_JC h3 = new HugeInteger_JC("-150");
        HugeInteger_JC h4 = new HugeInteger_JC("-60");
        System.out.println(String.format("Initial values: %s, %s", h3, h4));
        System.out.println(String.format("%s + %s = %s\n", h3, h4, h3.add(h4)));

        System.out.println("Addition: First Negative");
        HugeInteger_JC h5 = new HugeInteger_JC("-253");
        HugeInteger_JC h6 = new HugeInteger_JC("42");
        System.out.println(String.format("Initial values: %s, %s", h5, h6));
        System.out.println(String.format("%s + %s = %s\n", h5, h6, h5.add(h6)));

        System.out.println("Addition: Second Negative");
        HugeInteger_JC h7 = new HugeInteger_JC("253");
        HugeInteger_JC h8 = new HugeInteger_JC("-42");
        System.out.println(String.format("Initial values: %s, %s", h7, h8));
        System.out.println(String.format("%s + %s = %s\n", h7, h8, h7.add(h8)));

        System.out.println("-------------\n");

        // Test Subtraction
        System.out.println("Subtraction: Normal");
        HugeInteger_JC h9 = new HugeInteger_JC("10000");
        HugeInteger_JC h10 = new HugeInteger_JC("1");
        System.out.println(String.format("Initial values: %s, %s", h9, h10));
        System.out.println(String.format("%s - %s = %s\n", h9, h10, h9.subtract(h10)));

        System.out.println("Subtraction: First Negative");
        HugeInteger_JC h11 = new HugeInteger_JC("-10");
        HugeInteger_JC h12 = new HugeInteger_JC("100");
        System.out.println(String.format("Initial values: %s, %s", h11, h12));
        System.out.println(String.format("%s - %s = %s\n", h11, h12, h11.subtract(h12)));

        System.out.println("Subtraction: Second Negative");
        HugeInteger_JC h13 = new HugeInteger_JC("159");
        HugeInteger_JC h14 = new HugeInteger_JC("-32");
        System.out.println(String.format("Initial values: %s, %s", h13, h14));
        System.out.println(String.format("%s - %s = %s\n", h13, h14, h13.subtract(h14)));

        System.out.println("Subtraction: Both Negative");
        HugeInteger_JC h15 = new HugeInteger_JC("-10000");
        HugeInteger_JC h16 = new HugeInteger_JC("-1");
        System.out.println(String.format("Initial values: %s, %s", h15, h16));
        System.out.println(String.format("%s - %s = %s\n", h15, h16, h15.subtract(h16)));

        System.out.println("Subtraction: First < Second");
        HugeInteger_JC h17 = new HugeInteger_JC("10");
        HugeInteger_JC h18 = new HugeInteger_JC("1500");
        System.out.println(String.format("Initial values: %s, %s", h17, h18));
        System.out.println(String.format("%s - %s = %s\n", h17, h18, h17.subtract(h18)));

        System.out.println("-------------\n");

        // Test isGreaterThan
        System.out.println("Greater Than: Normal");
        HugeInteger_JC h19 = new HugeInteger_JC("150");
        HugeInteger_JC h20 = new HugeInteger_JC("5000");
        System.out.println(String.format("Initial values: %s, %s", h19, h20));
        if (h19.isGreaterThan(h20)) {
            System.out.println(h19 + " is greater\n");
        }
        else if (h20.isGreaterThan(h19)) {
            System.out.println(h20 + " is greater\n");
        }

        System.out.println("Greater Than: One Number Negative");
        HugeInteger_JC h21 = new HugeInteger_JC("150");
        HugeInteger_JC h22 = new HugeInteger_JC("-5000");
        System.out.println(String.format("Initial values: %s, %s", h21, h22));
        if (h21.isGreaterThan(h22)) {
            System.out.println(h21 + " is greater\n");
        }
        else if (h22.isGreaterThan(h21)) {
            System.out.println(h22 + " is greater\n");
        }

        System.out.println("-------------\n");

        // Test isLessThan
        // Only one test case because isLessThan just returns the opposite of isGreaterThan
        System.out.println("Less Than: Normal");
        HugeInteger_JC h23 = new HugeInteger_JC("150");
        HugeInteger_JC h24 = new HugeInteger_JC("5000");
        System.out.println(String.format("Initial values: %s, %s", h23, h24));
        if (h23.isLessThan(h24)) {
            System.out.println(h23 + " is lesser\n");
        }
        else if (h24.isLessThan(h23)) {
            System.out.println(h24 + " is lesser\n");
        }
        
        System.out.println("-------------\n");

        // Test isGreaterThanOrEqualTo
        System.out.println("Greater Than Or Equal: Second Greater");
        HugeInteger_JC h25 = new HugeInteger_JC("150");
        HugeInteger_JC h26 = new HugeInteger_JC("5000");
        System.out.println(String.format("Initial values: %s, %s", h25, h26));
        if (h25.isGreaterThanOrEqualTo(h26)) {
            System.out.println(h26 + " >= " + h25 + "\n");
        }
        else if (h26.isGreaterThanOrEqualTo(h25)) {
            System.out.println(h25 + " >= " + h25 + "\n");
        }

        System.out.println("Greater Than Or Equal: Equal");
        HugeInteger_JC h27 = new HugeInteger_JC("512");
        HugeInteger_JC h28 = new HugeInteger_JC("512");
        System.out.println(String.format("Initial values: %s, %s", h27, h28));
        if (h27.isGreaterThanOrEqualTo(h28)) {
            System.out.println(h27 + " >= " + h28 + "\n");
        }
        else if (h28.isGreaterThanOrEqualTo(h27)) {
            System.out.println(h28 + " >= " + h27 + "\n");
        }

        System.out.println("-------------\n");

        // Test isLessThanOrEqualTo
        System.out.println("Less Than Or Equal: First Smaller");
        HugeInteger_JC h29 = new HugeInteger_JC("150");
        HugeInteger_JC h30 = new HugeInteger_JC("5000");
        System.out.println(String.format("Initial values: %s, %s", h29, h30));
        if (h29.isLessThan(h30)) {
            System.out.println(h29 + " is lesser\n");
        }
        else if (h30.isLessThan(h29)) {
            System.out.println(h30 + " is lesser\n");
        }

        System.out.println("-------------\n");

        // Test isZero
        System.out.println("Is Zero: Is Zero");
        HugeInteger_JC h31 = new HugeInteger_JC("-0");
        System.out.println("Initial values: " + h31);
        System.out.println(String.format("%s %s equal to zero\n", h31, h31.isZero() ? "is": "is not"));

        System.out.println("Is Zero: Not Zero");
        HugeInteger_JC h32 = new HugeInteger_JC("256");
        System.out.println("Initial values: " + h32);
        System.out.println(String.format("%s %s equal to zero\n", h32, h32.isZero() ? "is": "is not"));

        System.out.println("-------------\n");

        // Test isEqualTo
        System.out.println("Is Equal To: Is Equal");
        HugeInteger_JC h33 = new HugeInteger_JC("1402");
        HugeInteger_JC h34 = new HugeInteger_JC("1402");
        System.out.println("Initial values: " + h33 + ", " + h34);
        System.out.println(String.format("%s and %s %s equal\n", h33, h34, h33.isEqualTo(h34) ? "are": "are not"));

        System.out.println("Is Equal To: Not Equal");
        HugeInteger_JC h35 = new HugeInteger_JC("1402");
        HugeInteger_JC h36 = new HugeInteger_JC("142");
        System.out.println("Initial values: " + h35 + ", " + h36);
        System.out.println(String.format("%s and %s %s equal\n", h35, h36, h35.isEqualTo(h36) ? "are": "are not"));
    }
}

/*
OUTPUT

Addition: Normal
Initial values: 242, 64
242 + 64 = 306

Addition: Both Negative
Initial values: -150, -60
-150 + -60 = -210

Addition: First Negative
Initial values: -253, 42
-253 + 42 = -211

Addition: Second Negative
Initial values: 253, -42
253 + -42 = 211

-------------

Subtraction: Normal
Initial values: 10000, 1
10000 - 1 = 9999

Subtraction: First Negative
Initial values: -10, 100
-10 - 100 = -110

Subtraction: Second Negative
Initial values: 159, -32
159 - -32 = 191

Subtraction: Both Negative
Initial values: -10000, -1
-10000 - -1 = -9999

Subtraction: First < Second
Initial values: 10, 1500
10 - 1500 = -1490

-------------

Greater Than: Normal
Initial values: 150, 5000
5000 is greater

Greater Than: One Number Negative
Initial values: 150, -5000
150 is greater

-------------

Less Than: Normal
Initial values: 150, 5000
150 is lesser

-------------

Greater Than Or Equal: Second Greater
Initial values: 150, 5000
150 >= 150

Greater Than Or Equal: Equal
Initial values: 512, 512
512 >= 512

-------------

Less Than Or Equal: First Smaller
Initial values: 150, 5000
150 is lesser

-------------

Is Zero: Is Zero
Initial values: -0
-0 is equal to zero

Is Zero: Not Zero
Initial values: 256
256 is not equal to zero

-------------

Is Equal To: Is Equal
Initial values: 1402, 1402
1402 and 1402 are equal

Is Equal To: Not Equal
Initial values: 1402, 142
1402 and 142 are not equal
*/