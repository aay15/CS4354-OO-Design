package assignment2;

import java.util.ArrayList;

/**
 * @author Andrew Rohn
 * @author Annie Yang
 * Represents a VideoStore Inventory
 * Contains a movieList composed of Movie objects
 */
public class Inventory implements Serializable{
    /**
    * The movieList object, made up of movie objects
    */
    private ArrayList<Product> productList = new ArrayList<Product>();
    /**
    * adds Movie object to movieList
    * @param Movie object
    * @return n.a.
    */
    public void addProduct(int sku, Product product) {

        int productIndex = getIndexBySKU(sku);

        if (productIndex!=-1) {
            System.out.println("non-unique SKU");
        }
        else {
            productList.add(product);
        }
    }

    /**
    * removes movie by SKU
    * @param int SKU
    * @return n.a.
    */
    public void removeProductBySku(int sku) {

        int productIndex = getindexBySKU(sku);

        for(Movie currMovie : movieList) {
            if(currMovie.getSku() == sku) {
                skuFound = true;
                currMovie.removeMovie();

                if(currMovie.getQuantity() <= 0) {
                    movieList.remove(currMovie);
                }
                System.out.println ("Removed movie with sku: " + sku);
            }
        }

        if(productIndex == -1) {
            System.out.println("No movie found with this sku.");
        }
    }
    /**
    * Finds SKU and calls member function to displays the movie by SKU
    * @param int SKU
    * @return n.a.
    */
    public void displayProductBySku(int sku) {

        boolean skuFound = false;

        for(Movie currMovie : movieList) {
            if(currMovie.getSku() == sku) {
                skuFound = true;
                currMovie.displayMovie();
                break;
            }
        }

        if(!skuFound) {
            System.out.println("No movie found with this sku.");
        }
    }
    /**
    * Calls member function to displays the movie line by line
    * @param n.a.
    * @return n.a.
    */
    public void displayProduct() {
        System.out.println();
        System.out.printf("%-10s", "sku");
        System.out.printf("%-8s", "quant");
        System.out.printf("%-10s", "price");
        System.out.printf("%-20s", "title");
        System.out.println();
        System.out.println("---------------------------------------------");

        for (int i = 0; i < movieList.size(); i++)
            movieList.get(i).displayLine();
    }
    /**
    * Searches for the SKU in the list and returns the index if found
    * return -1 when not found
    *
    */
    private int getIndexBySKU (int SKUValue) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getSKU() == SKUValue()
                return i;
            }
            return -1;
        }
    }
}
