package video-store;

import java.io.*;
import java.text.*;

/**
 * @author Andrew Rohn
 * @author Annie Yang
 * Represents a movie contained in the Video Store's Inventory
 * Movie is Serializable
 * 
 */
public class Movie extends Product implements Serializable {
    private int sku;
    private String title;
    private int quantity;
    private float price;

    public Movie(int sku, int quantity, float price, String title) {
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
        this.title = title;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

   public int getQuantity() {
        return quantity;
    }
    
    /**
     * Searches for the SKU and displays the movie 
     * @param void
     * @return void
    */
    public void displayMovie() {
        DecimalFormat priceForm = new DecimalFormat ("$#0.00");
        System.out.println();
        System.out.println("Sku: " + this.sku);
        System.out.println("Title: " + this.title);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Price: " + priceForm.format(this.price));
    }
    /**
    * displays the movie line by line
    * @param n.a.
    * @return n.a.
    */
    public void displayLine() {
        DecimalFormat priceForm = new DecimalFormat ("$#0.00");    
        System.out.printf("%-10s", this.sku);
        System.out.printf("%-8s", this.quantity);
        System.out.printf("%-10s", priceForm.format(this.price));
        System.out.printf("%-20s", this.title);
        System.out.println();
    }
    /**
    * increases quanity of movie
    * @param n.a.
    * @return n.a.
    */
    public void increaseQuantityBy(int n) {
        quantity += n;
    }
    /**
    * decreases quanity of movie
    * @param n.a.
    * @return n.a.
    */
    public void removeMovie() {
        quantity--;
    }
}
