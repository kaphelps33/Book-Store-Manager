package BookStore;

import BookStore.customer.Customer;
import BookStore.customer.CustomerBase;
import BookStore.inventory.Inventory;
import BookStore.inventory.ShoppingCart;

import java.util.Scanner;

public class BookStoreConsole {
    private final Scanner input; // Scanner used to get input
    private final Inventory inventory; // an instance of the stores inventory
    private final CustomerBase customerBase; // an instance of the stores customer database

    public BookStoreConsole() {
        this.input = new Scanner(System.in);
        this.inventory = Inventory.getInstance();
        this.customerBase = CustomerBase.getInstance();
    }

    /**
     * The main menu options that will be shown on startup
     */
    private void mainMenu() {
        System.out.println("-------- THE BOOK EMPORIUM --------");
        System.out.println("- [1] Purchase a product          -");
        System.out.println("- [2] Customer info               -");
        System.out.println("- [3] Check inventory             -");
        System.out.println("- [0] Exit                        -");
        System.out.print("- [>] Selection: ");
    }

    /**
     * Prints a message to the user that their input is not correct
     */
    private void errorMessage() {
        System.out.println("Invalid input! Please try again\n");
    }

    /**
     * Creates the application. This is what the user accesses on startup
     */
    public void start() {
        while (true) {
            mainMenu(); // Print the main menu options
            int selection = getInput();

            if (selection == 0) { // Exit option
                System.out.println("- Exiting...Goodbye");
                System.exit(0);
            } else if (selection == 1) { // Purchase option
                purchaseMenu();
                break;
            } else if (selection == 2) { // Customer info option
                customerInfoPage();
                break;
            } else if (selection == 3) { // Check inventory option
                inventoryPage();
                break;
            } else { // If input does not correspond with an option
                errorMessage();
            }
        }
    }

    /**
     * Gets the input of the user using the scanner object. Takes the input as a string and attempts to parse it to an
     * integer. If this fails then the user has entered a letter or another non-numeric value. Since this would crash
     * the program, the exception is caught and handled appropriately.
     *
     * @return the integer that the user selected
     */
    private int getInput() {
        int selection;
        while (true) {
            try {
                selection = Integer.parseInt(input.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number! Please try again");
            }
        }
        return selection;
    }

    /**
     * The menu used to initiate a purchase. A new shopping cart is created when the method is called so that users do
     * not end up with duplicate carts.
     */
    private void purchaseMenu() {
        ShoppingCart shoppingCart = new ShoppingCart();
        while (true) {
            System.out.println("-------- PURCHASE --------\n");

            inventory.printInventory(); // Displays all the purchasable products

            if (shoppingCart.getSize() <= 0) { // Prevents cart abandonment
                System.out.println("- [0] Cancel ");
            }

            System.out.print("- [>] Selection: ");

            int selection = getInput();

            if (selection == 0) { // If the user exits from here they are directed back to the main menu
                start();
                break;
            } else {
                try { // Tries to add a product to the cart based on if the selection matches a product in the id
                    shoppingCart.addProduct(inventory.getProducts().get(selection - 1));
                    inventory.removeProduct(selection - 1);
                    checkoutMenu(shoppingCart);
                } catch (IndexOutOfBoundsException e) { // If the user enters a number beyond the index, give an error
                    errorMessage();
                }
            }
        }
    }

    /**
     * After a customer has finished their purchase, they are given their cart and their total
     *
     * @param shoppingCart the users cart
     */
    private void checkoutMenu(ShoppingCart shoppingCart) {
        while (true) {
            System.out.println("\n-------- CHECKOUT --------\n");
            System.out.printf("- Total: $%.2f%n", shoppingCart.getTotal());

            shoppingCart.printCart(); // prints out the items in the cart

            if (inventory.getProducts().size() > 0) { // prevents a user from seeing an empty product page
                System.out.println("\n- [1] Purchase More Products");
            }
            System.out.println("- [0] Complete Your Purchase");
            System.out.print("- [>] Selection: ");

            int selection = getInput();

            if (selection == 0) { // if the user exits, redirect back to the product page
                customerMenu(shoppingCart);
                break;
            } else if (selection == 1) { // if the user confirms, send them to log in
                purchaseMenu();
                break;
            } else { // if the user enters an invalid number, alert them
                errorMessage();
            }
        }
    }

    /**
     * After a user has confirmed that they are done shopping they are sent to the menu of customers so that they can
     * log into their account
     *
     * @param shoppingCart the users shopping cart
     */
    private void customerMenu(ShoppingCart shoppingCart) {
        while (true) {
            System.out.println("-------- CUSTOMER --------");
            customerBase.printCustomers(); // prints out the customer database
            System.out.print("\n- [>] Selection: ");

            int selection = getInput();

            // if the users selection corresponds to a customer id, then it is a valid selection
            if (selection == customerBase.getCustomers().get(selection - 1).getId()) {
                // create a dummy customer abject that represents the users actual customer object
                Customer customer = customerBase.getCustomers().get(selection - 1);
                // take the user to the payment page
                payment(customer, shoppingCart);
                break;
            } else {
                // if the user enters an invalid value, alert them
                errorMessage();
            }

        }
    }

    /**
     * The final menu of the purchase option where a user pays for the items in their cart
     *
     * @param customer     the customer that the user represents
     * @param shoppingCart the users shopping cart
     */
    private void payment(Customer customer, ShoppingCart shoppingCart) {
        while (true) {

            // if a customer is a member then they receive a discount which must be shown
            if (customer.isMember()) {
                System.out.printf("- Welcome %s!%n- Your total is $%.2f (10%% members discount applied)",
                        customer.getName(), (shoppingCart.getTotal() + shoppingCart.getTotal() * 0.10));
            } else {
                System.out.printf("- Welcome %s!%n- Your total is $%.2f%n", customer.getName(), shoppingCart.getTotal());
            }
            // shows the payment the customer has on file
            System.out.printf("- Here is the payment method on file: %s%n", customer.getPaymentMethod().toString());
            System.out.println("- [0] Cancel");
            System.out.println("- [1] Complete Purchase");
            System.out.print("- [>] Selection: ");

            int selection = getInput();

            if (selection == 0) { // if the customer chooses to exit then they are brought back to the selection menu
                customerPage(customer);
                break;
            } else if (selection == 1) {
                // if a customer completes a purchase then they are thanked and brought back to the main page
                customer.setTotal(shoppingCart.getTotal());
                System.out.println("- Thank you! Have a great day!");
                start();
                break;
            } else {
                // if a customer gives an incorrect value they are alerted
                errorMessage();
            }
        }
    }

    /**
     * Displays all the stores customers both members and non-members and all of their relevant information
     */
    private void customerInfoPage() {
        while (true) {
            System.out.println("-------- CUSTOMERS --------");
            customerBase.printCustomers(); // prints out the customer database
            System.out.println("- [0] Exit");
            System.out.print("- [>] Selection: ");

            int selection = getInput();

            if (selection == 0) { // if the customer exits from here they are taken back to the main menu
                start();
                break;
            } else {
                try {
                    customerPage(customerBase.getCustomers().get(selection - 1));
                } catch (
                        IndexOutOfBoundsException e) { // if the user enters a number that is wrong, catch the exception
                    errorMessage();
                }
            }
        }
    }

    /**
     * Prints an individual customers info based on which customer the user selected
     *
     * @param customer the customer that the user selected
     */
    private void customerPage(Customer customer) {
        while (true) {
            System.out.println("-------- CUSTOMER INFO --------");

            System.out.printf("- Name: %s%n", customer.getName()); // prints the name
            System.out.printf("- Payment Method: %s%n", customer.getPaymentMethod().toString()); // prints the payment method on file

            if (customer.isMember() && customer.isFeeDue()) { // if the fee is due the customer is prompted to pay it
                System.out.printf("- Fee Due: $%.2f%n", customer.getFeeAmount());
                System.out.println("- [1] Pay Fee");
            } else if (customer.isMember()) { // if the fee is not due the customer is notified as well
                System.out.println("- Fee Due: None!");
            } else {
                System.out.println("- [1] Sign up for a membership");
            }

            System.out.println("- [0] Exit");
            System.out.print("- [>] Selection: ");
            int selection = getInput();

            if (customer.isMember() && selection == 1) { // if the customer decides to pay the fee then they are taken to the fee pay menu
                payFee(customer);
            } else if (selection == 1) {
                customer.setMember(true);
                System.out.println("- Thank you for signing up! Your first month is on us!");
                customerInfoPage();
                break;
            } else if (selection == 0) { // if the customer exits they are taken back to the information page
                customerInfoPage();
                break;
            } else { // if the customer enters a bad value they are alerted
                errorMessage();
            }
        }

    }


    /**
     * If the user decides to pay their fee they are given their payment method on file and are asked to confirm that
     * they would like to pay the fee
     *
     * @param customer the customer that the user has selected
     */
    private void payFee(Customer customer) {
        while (true) {
            System.out.printf("- Here is the payment method on file: %s%n", customer.getPaymentMethod().toString());
            System.out.println("- [0] Cancel");
            System.out.println("- [1] Complete Purchase");
            System.out.print("- [>] Selection: ");

            int selection = getInput();

            if (selection == 0) { // if the user exits take them back to the customer selection page
                customerPage(customer);
                break;
            } else if (selection == 1) { // if the user pays thank them, and take them back to the main menu
                System.out.println("- Fee Paid! Thank you!");
                customer.setFeeDue(false);
                start();
                break;
            }
        }
    }

    /**
     * Simply displays the stores inventory
     */
    private void inventoryPage() {
        while (true) {
            System.out.println("-------- INVENTORY --------");
            inventory.printInventory();
            System.out.println("- [0] Exit");
            System.out.print("- [>] Selection: ");

            int selection = getInput();

            if (selection == 0) {
                start();
                break;
            } else {
                errorMessage();
            }
        }
    }
}
