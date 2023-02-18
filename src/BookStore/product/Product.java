package BookStore.product;

public class Product {
    private String name;
    private double price;
    private int id;

    /**
     * Creates a basic product object without any special characteristics
     *
     * @param name  the products name
     * @param price the price of the product
     * @param id    the products id number
     */
    public Product(String name, double price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    /**
     * Gets the product name
     *
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the product name
     *
     * @param name the product name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the product price
     *
     * @return the product price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product price
     *
     * @param price the product price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets the product id
     *
     * @return the product id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the product id
     *
     * @param id the product id
     */
    public void setId(int id) {
        this.id = id;
    }
}
