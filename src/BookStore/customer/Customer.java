package BookStore.customer;

public class Customer {
    private final double feeAmount = 3.00;
    private String name;
    private double total;
    private int id;
    private PaymentMethod paymentMethod;
    private boolean feeDue;
    private boolean member;

    /**
     * Default constructor that builds a customer who is a member at the store
     *
     * @param name          customer name
     * @param total         total that the customer has spent
     * @param id            customers identification number
     * @param paymentMethod the customers filed payment method
     * @param feeDue        if a customer is a member and has or has not paid their fee
     */
    public Customer(String name, double total, int id, PaymentMethod paymentMethod, boolean feeDue) {
        this.name = name;
        this.total = total;
        this.id = id;
        this.paymentMethod = paymentMethod;
        this.feeDue = feeDue;
        member = true;
    }

    /**
     * Constructor that builds a customer who is not a member at the store
     *
     * @param name          customer name
     * @param total         total that the customer has spent
     * @param id            customers identification number
     * @param paymentMethod the customers filed payment method
     */
    public Customer(String name, double total, int id, PaymentMethod paymentMethod) {
        this.name = name;
        this.total = total;
        this.id = id;
        this.paymentMethod = paymentMethod;
        member = false;
    }

    /**
     * Gets customers name
     *
     * @return customers name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets customers name
     *
     * @param name customers name as a string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the total amount that a customer has spent
     *
     * @return the total amount spent
     */
    public double getTotal() {
        return total;
    }

    /**
     * Sets the total amount that a customer has spent
     *
     * @param total the total amount
     */
    public void setTotal(double total) {
        this.total += total;
    }

    /**
     * Gets the customers id number
     *
     * @return the customers id number
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the customers id number
     *
     * @param id the customers id number
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets if a customers fee is due
     *
     * @return boolean due or not due
     */
    public boolean isFeeDue() {
        return feeDue;
    }

    /**
     * Sets if the customers fee is due
     *
     * @param feeDue boolean due or not due
     */
    public void setFeeDue(boolean feeDue) {
        this.feeDue = feeDue;
    }

    /**
     * Gets the payment method that the customer has on file
     *
     * @return the customers payment method
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Sets the payment method that the customer has on file
     *
     * @param paymentMethod the new payment method
     */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Gets if the customer is a member or not
     *
     * @return boolean is a member or not a member
     */
    public boolean isMember() {
        return member;
    }

    /**
     * Sets if the customer is a member or not
     *
     * @param member boolean is a member or not a member
     */
    public void setMember(boolean member) {
        this.member = member;
    }

    /**
     * Gets the fee amount that needs to be paid
     *
     * @return the fee amount
     */
    public double getFeeAmount() {
        return feeAmount;
    }

    /**
     * Makes a neatly formatted string to display the customers information
     *
     * @return customer object as a String
     */
    public String toString() {
        if (!member) {
            return "- | " + name + " | total spent: $" + String.format("%.2f", total);
        } else {
            if (isFeeDue()) {
                return "- | " + name + " | total spent: $" + String.format("%.2f", total) + " | $" + feeAmount + " members fee due";
            } else {
                return "- | " + name + " | total spent: $" + String.format("%.2f", total);
            }
        }


    }
}
