package BookStore.inventory;

import BookStore.product.Book;
import BookStore.product.CD;
import BookStore.product.Movie;
import BookStore.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private static Inventory instance;
    private static int nextId = 1;
    private final List<Product> products = new ArrayList<>();

    /**
     * Creates the inventory with a set of default products. Can not be accessed by the client
     */
    private Inventory() {
        Product theHobbit = new Book("The Hobbit", 11.91, nextId, "J.R.R. Tolkien", 300);
        incrementId();
        Product starWarsFour = new Movie("Star Wars: A New Hope", 12.99, nextId, "George Lucas", 121);
        incrementId();
        Product trilogy = new CD("Trilogy", 29.99, nextId, "The Weeknd", 30);
        incrementId();

        products.add(theHobbit);
        products.add(starWarsFour);
        products.add(trilogy);
    }

    /**
     * Increments the id by one
     */
    private static void incrementId() {
        nextId++;
    }

    /**
     * Creates a new instance of the inventory as long as one does not already exist
     *
     * @return instance of the inventory
     */
    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    /**
     * Gets the inventory list so that specific properties can be used
     *
     * @return the inventory list
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Adds a product to the product inventory
     *
     * @param product the product that one wishes to add
     */
    public void addProduct(Product product) {
        this.products.add(product);
    }

    /**
     * Removes a product from the products list
     *
     * @param index the index of the product one wishes to remove
     */
    public void removeProduct(int index) {
        Product product = this.products.remove(index);
    }

    /**
     * Prints all the products that are in the inventory
     */
    public void printInventory() {
        for (Product product : products) {
            System.out.printf("- [%d] %s%n", product.getId(), product);
        }
    }
}
