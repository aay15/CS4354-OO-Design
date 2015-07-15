package assignment2;

import java.util.*;
import java.io.*;

/**
 * @author Andrew Rohn
 * @author Annie Yang
 * Represents a VideoStore
 * Has an Inventory
 * Displays a gui menu and allows users to choose between options
 */
public class VideoStore {

    static Scanner sc = new Scanner(System.in);
<<<<<<< HEAD

    /**
    * The inventory object
    */
    private Inventory storeInventory = new Inventory();

    public static void main(String[] args) {
=======
    
    private Inventory storeInventory = new Inventory();

    public static void main(String[] args) {
        
        VideoStore store = new VideoStore();
>>>>>>> 4cde5cd9a6fe5b396facac8593297bcbb8ce50d8

        /**
        * Reads in the Serialized Inventory from input file
        * @throws file not found
        * @throws problem with file input
        * @throws class not found
        */
        try {
            FileInputStream fis = new FileInputStream("inventoryFile");
            ObjectInputStream ois = new ObjectInputStream(fis);

            store.storeInventory = (ArrayList<Movie>)ois.readObject();

        } catch (FileNotFoundException e) {
            //do nothing if not found
                //there will be no file prior to initial startup of program
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
        System.out.println(" Store Inventory Menu");
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
                System.out.println("Enter the product type.");
                System.out.println("Enter M for movie, B for Book, or T for Toy:");
                char type = sc.nextChar();
                storeInventory.createProduct(type);
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
<<<<<<< HEAD
    * Reads in Product information and creates Product object
    * @param char choice (M, B, or T)
    * @return void
=======
    * Reads in Movie information and creates movie object
    * @return the Movie object created
>>>>>>> 4cde5cd9a6fe5b396facac8593297bcbb8ce50d8
    */
    private void createProduct(char choice) {

        int sku, quantity;
        float price;
        String title;
        Product product;

        sku = requestSku();
        System.out.println("Enter the quantity:");
        quantity = sc.nextInt();
        System.out.println("Enter the price:");
        price = sc.nextFloat();
        System.out.println("Enter the title:");
        sc.nextLine();
        title = sc.nextLine();

        if (choice == 'M'){
            System.out.println("Enter the UPC");
            int isbn = sc.nextInt();
            product = new Movie(sku, quantity, price, title, other, type);
        }
        if (choice == 'B'){
            System.out.println("Enter the ISBN");
            int isbn = sc.nextInt();
            System.out.println("Enter the author");
            sc.nextLine();
            String author = sc.nextLine();
            product = new Book(sku, quantity, price, title, other, type);
        }
        if (choice == 'T'){
            System.out.println("Enter the ISBN");
            int isbn = sc.nextInt();
            System.out.println("Enter the weight");
            float weight = sc.nextFloat();
            product = new Toy(sku, quantity, price, title, other, type);
        }
        storeInventory.addProduct(sku, product);

    }

    /**
    * gets SKU from command line and returns SKU
    * @return int SKU
    */
    private int requestSku() {
        System.out.println("Enter the SKU:");
        return sc.nextInt();
    }

}

