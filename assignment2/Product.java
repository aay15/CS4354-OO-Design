package assignment2;

import java.io.*;
import java.text.*;

/**
 * @author Andrew Rohn
 * @author Annie Yang
 * Represents a Product contained in the Video Store's Inventory
 * Product is an abstract class.
 */

abstract public class Product implements Comparable<Product>, Serializable {

    protected int sku;
    protected String title;
    protected int quantity;
    protected float price;

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
     * Displays all attributes of product
    */
    public void displayAllAttributes() {
        DecimalFormat priceForm = new DecimalFormat ("$#0.00");
        System.out.println();
        System.out.println("Sku: " + sku);
        System.out.println("Title: " + title);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: " + priceForm.format(price));
    }

    /**
    * Displays the product in one neatly formatted line.
    */
    public void displayLine() {
        DecimalFormat priceForm = new DecimalFormat ("$#0.00");
        System.out.printf("%-10s", sku);
        System.out.printf("%-8s", quantity);
        System.out.printf("%-10s", priceForm.format(price));
        System.out.printf("%-20s", title);
    }

    /**
    * Increase product quantity by variable amount.
    * @param n The number to increase quantity by.
    */
    public void increaseQuantityBy(int n) {
        quantity += n;
    }

    /**
    * Decrease product quantity by variable amount. 
    * Checks if sufficient amount of product in inventory.
    * @param n The number to decrease quantity by.
    * @return True if decrease succeeded. Fail otherwise.
    */
    public boolean decreaseQuantityBy(int n) {

        if(quantity - n >= 0) {
            quantity-=n;
            System.out.println("Removed " + n);
            return true;
        } else {
            System.out.print("Could not remove.");
            System.out.println("Only " + quantity + " in inventory.");
            return false;
        }

    }
    
    /**
    * Redefine Comparable interace compareTo(T o) method.
    * @param Product The object to be compared.
    * @return Result of comparison.
    */
    public int compareTo(Product product) {
        return sku - product.getSku();
    }

    public void processAndDisplaySale(int numSold, 
                                                float shippingCost) {
        float totalPrice = price * numSold;
        float totalShippingCredit = perItemShippingCredit() * numSold;
        float totalCommission = getCommissionRate() * totalPrice;
        float totalProfit = (totalPrice + totalShippingCredit)
                            - (totalCommission + shippingCost);

        System.out.println("Total price: " + totalPrice);
        System.out.println("Total shipping credit: " + totalShippingCredit);
        System.out.println("Total commission: " + totalCommission);
        System.out.println("Total profit: " + totalProfit);

    }
        
    abstract public float perItemShippingCredit();
    
    abstract public float getCommissionRate();
}

