/* Assorted FRQ responses */
// Unit 5

public class PasswordGenerator {
    String prefix;
    int length;
    static int count = 0;

    public PasswordGenerator(String prefix, int length) {
        this.prefix = prefix;
        this.length = length;
    }
    public PasswordGenerator(int length) {
        this.prefix = "A";
        this.length = length;
    }
    
    public int pwCount() {
        return count;
    }
    public String pwGen() {
        String pw = prefix + ".";
        for (int i = 0; i < length; i++) {
            pw += (int)(Math.random() * 10);
        }
        count++;
        return pw;
    }
}

// Unit 6
for (String word : words) {
    if (word.substring(word.length() - 3).equals("ing")) {
        System.out.println(word);
    }
}

public double computeBonusThreshold() {
    double sum = 0;
    int maxSold = itemsSold[0];
    int minSold = itemsSold[0];
    for (int i = 0; i < itemsSold.length; i++) {
        sum += itemsSold[i];
        if (itemsSold[i] > maxSold) {
            maxSold = itemsSold[i];
        }
        if (itemsSold[i] < minSold) {
            minSold = itemsSold[i];
        }
    }
    sum -= maxSold;
    sum -= minSold;
    return sum / (itemsSold.length - 2);
}

public void computeWages(double fixedWage, double perItemWage) {
    for (int i = 0; i < wages.length; i++) {
        wages[i] = fixedWage + perItemWage * itemsSold[i];
        if (itemsSold[i] > computeBonusThreshold()) {
            wages[i] *= 1.1;
        }
    }
}

// Unit 8
public Plot getHighestYield(String c) {
    Plot highest = null;
    for (Plot[] row : plots) {
        for (Plot p : row) {
            if (p.getCropType().equals(c)) {
                if (highest == null || p.getCropYield() > highest.getCropYield()) {
                    highest = p;
                }
            }
        }
    }
    return highest;
}

public boolean sameCrop(int col) {
    String crop = plots[0][col].getCropType();
    for (int i = 1; i < plots.length; i++) {
        if (!plots[i][col].getCropType().equals(crop)) {
            return false;
        }
    }
    return true;
}

// Unit 9

public class PictureBook extends Book {
    private String illustrator;
    public PictureBook(String title, String author, String illustrator) {
        super(title, author);
        this.illustrator = illustrator;
    }
    public void printBookInfo() {
        super.printBookInfo();
        System.out.print(" and illustrated by " + illustrator);
    }
}

book1 = new Book("Frankenstein", "Mary Shelley");
book2 = new PictureBook("The Wonderful Wizard of Oz", "L. Frank Baum", "W.W. Denslow");

public class BookListing {
    private Book book;
    private double price;
    public BookListing(Book book, double price) {
        this.book = book;
        this.price = price;
    }
    public void printDescription() {
        book.printBookInfo();
        System.out.print(", $" + price);
    }
}