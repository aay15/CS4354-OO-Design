package assignment2;

/**
 * @author Andrew Rohn
 * @author Annie Yang
 * Represents a Book contained in the Video Store's Inventory
 */
public class Book extends Product {

    private int isbn;
    private String author;
    public final String CATEGORY = "Book"; 
    public final float COMMISSION_RATE = .15f;

    public Book(int sku, int quantity, float price, String title, 
                int isbn, String author){
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }
    
    /**
     * Displays all attributes of product
    */
    public void displayAllAttributes() {
        super.displayAllAttributes();
        System.out.println("ISBN: " + isbn);
        System.out.println("Author: " + author);
    }

    /**
    * Displays the product in one neatly formatted line.
    */
    public void displayLine() {
        super.displayLine();
        System.out.printf("%-10s", CATEGORY);
        System.out.println();
    }

    public float perItemShippingCredit() {
        return 3.99f;
    }

    public float getCommissionRate() {
        return COMMISSION_RATE;
    }
}
