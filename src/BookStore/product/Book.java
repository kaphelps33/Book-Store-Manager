package BookStore.product;

public class Book extends Product {
    private String author;
    private int pageCount;

    /**
     * Creates a specialized book product with unique values author and page count
     *
     * @param name      the name of the book
     * @param price     the price of the book
     * @param id        the books product id
     * @param author    the author of the book
     * @param pageCount the number of pages the book has
     */
    public Book(String name, double price, int id, String author, int pageCount) {
        super(name, price, id);
        this.author = author;
        this.pageCount = pageCount;
    }

    /**
     * Gets the name of the books author
     *
     * @return the name of the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the name of the books author
     *
     * @param author the name of the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets the number of pages in the book
     *
     * @return the number of pages in the book
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Sets the number of pages in the book
     *
     * @param pageCount the number of pages in the book
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    /**
     * Takes the information of a book object and reformats it to a string
     *
     * @return the information of a book as a String
     */
    public String toString() {
        return " --- $" + getPrice() + " " + getName() + " by " + author + ", pages: " + pageCount;
    }
}
