package BookStore.product;

public class Movie extends Product {

    private String director;
    private int runTime;

    /**
     * Creates a specialized movie product with unique values director and the length of the movie
     *
     * @param name     the name of the movie
     * @param price    the price of the movie
     * @param id       the movies product id number
     * @param director the director of the movie
     * @param runTime  the length of the movie in minutes
     */
    public Movie(String name, double price, int id, String director, int runTime) {
        super(name, price, id);
        this.director = director;
        this.runTime = runTime;
    }

    /**
     * Gets the director of the movie
     *
     * @return the director of the movie
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the director of the movie
     *
     * @param director the name of the director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Gets the length of the movie
     *
     * @return the length of the movie in minutes
     */
    public int getRunTime() {
        return runTime;
    }

    /**
     * Sets the length of the movie
     *
     * @param runTime the length of the movie in minutes
     */
    public void setRunTime(int runTime) {
        this.runTime = runTime;
    }

    /**
     * Takes the movies information and represents it as a string
     *
     * @return the movies information as a string
     */
    public String toString() {
        return " --- $" + getPrice() + " " + getName() + " by " + director + ", runtime: " + runTime + " minutes";
    }
}
