package assignment2;

public class Book extends Product {

    private int isbn;
    public final String CATEGORY = "Book";

    public Book(int sku, int quantity, float price, String title, int isbn){
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
        this.title = title;
        this.isbn = isbn;
    }
    
    /**
     * Displays all attributes of product
    */
    public void displayAllAttributes() {
        super.displayAllAttributes();
        System.out.println("ISBN: " + isbn);
    }

    /**
    * Displays the product in one neatly formatted line.
    */
    public void displayLine() {
        super.displayLine();
        System.out.printf("%-10s", CATEGORY);
        System.out.println();
    }
}
