package BookStore.inventory;

import BookStore.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<Product> products; // The list of all products in the cart
    private double total; // The total price of all the products in the cart

    /**
     * Creates a new shopping cart object
     */
    public ShoppingCart() {
        this.products = new ArrayList<>();
    }

    /**
     * Adds a product to the shopping cart and increases its total based on that price
     *
     * @param product the product to add
     */
    public void addProduct(Product product) {
        products.add(product);
        setTotal(product.getPrice());
    }

    /**
     * Removes a product from the shopping cart
     *
     * @param product the product to remove
     */
    public void removeProduct(Product product) {
        products.add(product);
    }

    /**
     * Gets the total price of products in the cart
     *
     * @return the total price
     */
    public double getTotal() {
        return total;
    }

    /**
     * Sets the total price of objects in the cart
     *
     * @param total the price
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Gets the entire shopping cart
     *
     * @return the List of the shopping cart
     */
    public List<Product> getCart() {
        return products;
    }

    /**
     * Gets the size of the shopping cart object
     *
     * @return the size of the shopping cart
     */
    public int getSize() {
        return products.size();
    }

    /**
     * Prints out the entire shopping cart
     */
    public void printCart() {
        for (Product product : products) {
            System.out.printf("- [%d] %s%n", product.getId(), product);
        }
    }
}
