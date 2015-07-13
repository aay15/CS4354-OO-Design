package assignment2;

/**
 * @author Andrew Rohn
 * @author Annie Yang
 * Represents a Movie Product contained in the Video Store's Inventory
 */

public class Movie extends Product {

    private int upc;
    public final String CATEGORY = "Movie";

    public Movie(int sku, int quantity, float price, String title, int upc){
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
        this.title = title;
        this.upc = upc;
    }
    
    /**
     * Displays all attributes of product
    */
    public void displayAllAttributes() {
        super.displayAllAttributes();
        System.out.println("UPC: " + upc);
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
