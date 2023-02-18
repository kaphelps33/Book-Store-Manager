package BookStore.product;

public class CD extends Product {
    private String artist;
    private int songCount;

    /**
     * Creates a specialized CD product with unique values artist and song count
     *
     * @param name      the name of the CD
     * @param price     the price of the CD
     * @param id        the CD product id number
     * @param artist    the recording artist of the CD
     * @param songCount the number of songs on the CD
     */
    public CD(String name, double price, int id, String artist, int songCount) {
        super(name, price, id);
        this.artist = artist;
        this.songCount = songCount;
    }

    /**
     * Gets the name of the artist on the CD
     *
     * @return the artists name
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the name of the artist
     *
     * @param artist the name of the artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Gets the number of songs on the CD
     *
     * @return the number of songs
     */
    public int getSongCount() {
        return songCount;
    }

    /**
     * Sets the number of songs on the CD
     *
     * @param songCount the number of songs
     */
    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    /**
     * Takes the CD information and formats it to a string
     *
     * @return the information of the CD as a string
     */
    public String toString() {
        return " --- $" + getPrice() + " " + getName() + " by " + artist + ", songs: " + songCount;
    }
}
