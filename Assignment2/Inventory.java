package assignment2;

import java.util.ArrayList;

/**
 * @author Andrew Rohn
 * @author Annie Yang
 * Represents a VideoStore Inventory
 * Contains a movieList composed of Movie objects
 */
public class Inventory{
    /**
    * The movieList object, made up of movie objects 
    */
    ArrayList<Movie> movieList = new ArrayList<Movie>();

    /**
    * adds Movie object to movieList
    * @param Movie object
    * @return n.a.
    */
    public void addMovie(Movie movie) {

        boolean matchFound = false;
        
        for(Movie currMovie : movieList){
            if(currMovie.getSku() == movie.getSku()){
                matchFound = true;
                currMovie.increaseQuantityBy(movie.getQuantity());
                break;
            }
        }

        if(!matchFound) {
            movieList.add(movie);
        }
    }
    /**
    * removes movie by SKU
    * @param int SKU
    * @return n.a.
    */
    public void removeMovieBySku(int sku) {
       
        boolean skuFound = false;

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
        
        if(!skuFound) {
            System.out.println("No movie found with this sku.");
        } 
    }
    /**
    * Finds SKU and calls member function to displays the movie by SKU
    * @param int SKU
    * @return n.a.
    */
    public void displayMovieBySku(int sku) {
        
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
    public void displayInventory() {
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
}
