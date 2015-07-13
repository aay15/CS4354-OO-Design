package assignment2;

import java.util.*;
import java.io.*;

/**
 * @author Andrew Rohn
 * @author Annie Yang
 * Represents a VideoStore 
 * Has an Inventory 
 * Displays a gui menu and allows users to choose between optios 
 */
public class VideoStore {
    
    static Scanner sc = new Scanner(System.in);
    
    /**
    * The inventory object
    */
    private Inventory storeInventory = new Inventory();

    public static void main(String[] args) {
        /**
        * The VideoStore object
        */
        VideoStore store = new VideoStore();

        /**
        * Reads in the Serialized Inventory from input file
        * @throws file not found
        * @throws problem with file input
        * @throws class not found
        */
        try {
            FileInputStream fis = new FileInputStream("inventoryFile");
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            store.storeInventory.movieList = (ArrayList<Movie>)ois.readObject(); 

        } catch (FileNotFoundException e) {
            //do nothing if not found...
            //System.out.println("Cannot find datafile.");
        } catch (IOException e) {
            System.out.println("Problem with file input.");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found on input from file.");
        } 
        
        store.enterChoice();

        /**
        * Writes the Serialized Inventory to output file
        * @throws file output problem
        */
        try {
            FileOutputStream fos = new FileOutputStream("inventoryFile");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(store.storeInventory.movieList);
            fos.close();
        } catch (IOException e) {
            System.out.println("Problem with file output");
            System.out.println("e: " + e);
            System.out.println("e.getMessage(): " + e.getMessage());
        }
    }

    static void displayMenu() {
        System.out.println();
        System.out.println("Video Store Inventory Menu");
        System.out.println("--------------------------");
        System.out.println("1. Add Movie");
        System.out.println("2. Remove Movie");
        System.out.println("3. Find Movie by SKU");
        System.out.println("4. Display inventory");
        System.out.println("5. Quit the Program");
        System.out.println();

    }
      
    private void enterChoice() {
        displayMenu();
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: //Add movie     
                storeInventory.addMovie(createNewMovie());
                enterChoice();
                break;

            case 2: //Remove movie
                storeInventory.removeMovieBySku(requestSku());
                enterChoice();
                break;

            case 3: //Display movie
                storeInventory.displayMovieBySku(requestSku());
                enterChoice();
                break;

            case 4: //Display inventory
                storeInventory.displayInventory();
                enterChoice();
                break;

            case 5: //Quit program
                System.out.println("Exit selected");
                break;

            default: 
                System.out.println("Incorrect choice.");
                enterChoice();
                break;
        }
    }
    /**
    * Reads in Movie information and creates movie object, returns movie object
    * @param n.a.
    * @return the Movie object created
    */
    private Movie createNewMovie() { 
        
        int sku, quantity;
        float price;
        String title;

        sku = requestSku();
        System.out.println("Enter the quantity:");
        quantity = sc.nextInt();
        System.out.println("Enter the price:");
        price = sc.nextFloat();
        System.out.println("Enter the title:"); 
        sc.nextLine();
        title = sc.nextLine();

        Movie movie = new Movie(sku, quantity, price, title);

        return movie;
    }
    /**
    * gets SKU from command line and returns SKU
    * @param n.a.
    * @return int SKU
    */
    private int requestSku() {
        System.out.println("Enter the SKU:");    
        return sc.nextInt();
    }

}
