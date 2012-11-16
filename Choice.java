/**
 * An alternative item or course of action.
 * 
 * @author  Zach Souser
 * @version 1.0
 */
public class Choice {
    public static final int DEFAULT_SCORE = 0;
    private String name;
    private int finalScore;
    /**
     * Constructor that sets the choice name.
     * Default finalScore is 0;
     * @param theName the name of this choice
     */
    public Choice(String theName) {
        this.name = theName;
        this.finalScore = DEFAULT_SCORE;
    }
    /**
     * Set the final score
     * 
     * @param   newScore    the new score
     */
    public void setFinalScore(int newScore) {
        this.finalScore = newScore;
    }
    
    /** 
     * Get the name fo the choice
     *
     * @return  the name
     */
    
    public String getName() {
        return this.name;
    }
    
    /**
     * Get the final score
     * 
     * @return  the final score
     */
    
    public int getFinalScore() {
        return this.finalScore;
    }
    
    /**
     * toString prints out the name of the choice
     */
    public String toString() {
        return this.name;
    }
}