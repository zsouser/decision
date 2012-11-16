/**
 * A decision-influencing characteristic.
 * 
 * @author Zach Souser
 * @version 1.0
 */
public class Characteristic {
    private static final int DEFAULT_RANK = 1;
    private int rank;
    private String name;
    /**
     * Constructor that sets the name and default rank.
     * @param theName the name of this characteristic
     */
    public Characteristic(String theName) {
        this.name = theName;
    }
    /**
     * Set the rank of the characteristic
     * 
     * @param   newRank the new rank of the characteristic
     */
    public void setRank(int newRank) {
        this.rank = newRank;
    }
    
    /**
     * Get the name of the characteristic
     * 
     * @return  the name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Get the rank of the characteristic
     * 
     * @return  the name
     */
    public int getRank() {
        return this.rank;
    }
    
    /**
     * Return the name for printing
     * 
     * @return  the string representation of a characteristic
     */
    public String toString() {
        return this.name;
    }
}