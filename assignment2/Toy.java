package assignment2;

/**
 * @author Andrew Rohn
 * @author Annie Yang
 * Represents a Toy Product contained in the Video Store's Inventory
 */
public class Toy extends Product {

    private float weight;
    public static final String CATEGORY = "Toy";
    public static final float COMMISSION_RATE = .15f;

    public Toy(int sku, int quantity, float price, String title, 
                float weight){
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
        this.title = title;
        this.weight = weight;
    }
    
    /**
     * Displays all attributes of product
    */
    public void displayAllAttributes() {
        super.displayAllAttributes();
        System.out.println("Weight: " + weight);
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
        float pounds = (float)Math.ceil(weight / 16);
        return .5f * pounds + 4.49f;
    }

    public float getCommissionRate() {
        return COMMISSION_RATE;
    }
}
