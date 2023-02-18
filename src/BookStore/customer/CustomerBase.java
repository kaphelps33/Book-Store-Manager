package BookStore.customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerBase {
    private static CustomerBase instance; // Stores the customer database instance
    private static int nextId = 1; // used to assign sequential id numbers to customers
    private final List<Customer> customers = new ArrayList<>(); // List used to store customers


    /**
     * Constructor that builds the customer database. This database is hidden from client code and can only be
     * accessed by the designated method
     */
    private CustomerBase() {
        Customer customerZero = new Customer("John Doe", 35.56, nextId, PaymentMethod.PAYPAL);
        incrementId();
        Customer customerOne = new Customer("John Appleseed", 147.90, nextId, PaymentMethod.VISA_CARD, true);
        incrementId();
        Customer customerTwo = new Customer("Jane Doe", 246.30, nextId, PaymentMethod.MASTER_CARD);
        incrementId();
        Customer customerThree = new Customer("Roger Dale", 394.50, nextId, PaymentMethod.CASH, false);

        customers.add(customerZero);
        customers.add(customerOne);
        customers.add(customerTwo);
        customers.add(customerThree);
    }

    /**
     * Increments the id by one
     */
    private static void incrementId() {
        nextId++;
    }

    /**
     * Creates a new instance of the user database as long as one does not exist already
     *
     * @return the instance of the user database
     */
    public static CustomerBase getInstance() {
        if (instance == null) {
            instance = new CustomerBase();
        }
        return instance;
    }

    /**
     * Creates a new customer who has a membership by default as a promotion
     *
     * @param name          the name of the customer
     * @param paymentMethod the preferred method of payment
     */
    public void addCustomer(String name, PaymentMethod paymentMethod) {
        customers.add(new Customer(name, 0.00, nextId, paymentMethod, false));
        incrementId();
    }

    /**
     * Prints out all the customers in the stores records
     */
    public void printCustomers() {
        for (Customer customer : customers) {
            System.out.printf("- [%d] %s%n", customer.getId(), customer);
        }
    }

    /**
     * Gets a copy of the list so that specific properties of the list can be use
     *
     * @return a copy of the customer database list
     */
    public List<Customer> getCustomers() {
        return List.copyOf(customers);
    }
}
