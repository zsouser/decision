import java.util.List;
import java.util.ArrayList;

/**
 * Abstract class DecisionUserInterface - implements UserInterface
 * with the reusable code implemented and the actual Console/Graphical
 * IO delegated to the subclass
 * 
 * @author Zach Souser
 * @version 1.0
 */

public abstract class DecisionUserInterface implements UserInterface
{
    /**
     * Ask the user for an integer
     * 
     * @param   question    the question to be prompted to the user
     * @return  the integer received from the user
     */
    
    public abstract int askInt(String question);
    
    /**
     * Ask the user for a string
     * 
     * @param   question    the question to be prompted to the user
     * @return  the string received from the user
     */
    
    public abstract String askString(String question);
    
    /**
     * Tell the user something
     * 
     * @param   @message    the message to be told to the user
     */
    
    public abstract void tellUser(String message);
    
    /**
     * Get the choices from the user
     * 
     * @return  the choices submitted by the user
     */
    
    public ArrayList<Choice> getChoices() {
        ArrayList<Choice> choices = new ArrayList<Choice>();
        String answer;
        do {
            answer = askString("Enter a choice, or blank to terminate");
            if (!answer.isEmpty()) choices.add(new Choice(answer));
        } while (!answer.isEmpty());
        
        if (choices.isEmpty()) {
            tellUser("No choices, no decision!");
            System.exit(1);
        }
        
        return choices;
    }
    
    /**
     * Get the characteristics from the user
     * 
     * @return  the characteristics submitted by the user
     */
    
    public ArrayList<Characteristic> getCharacteristics() {
        String answer;
        ArrayList<Characteristic> characteristics = new ArrayList<Characteristic>();
        do {
            answer = askString("Enter a characteristic, or blank to terminate");
            if (!answer.isEmpty()) characteristics.add(new Characteristic(answer));
        } while (!answer.isEmpty());
        
        if (characteristics.isEmpty()) {
            tellUser("No characteristics, no decision!");
            System.exit(1);
        }
        
        return characteristics;
    }
    
    /**
     * Ask the user to rank the characteristics
     * 
     * @param   characteristics the characteristics to be ranked
     * @param   defaultValue the default value by which characteristics will be ranked
     */
    public void getCharacteristicRankings(ArrayList<Characteristic> characteristics, int defaultValue) {
        characteristics.get(0).setRank(defaultValue);
        for (int i = 1; i < characteristics.size(); i++) {
            int ranking = askInt("If " + characteristics.get(0) + " has an importance of " + 
                defaultValue + ", how important is " + characteristics.get(i));
            characteristics.get(i).setRank(ranking);
        }
    }
    
    /**
     * Ask the user to rank the choices relative to each other, weighted by characteristics
     * 
     * @param   choices the choices to be processed
     * @param   characteristics the characteristics to be processed
     * @param   defaultValue the default value of the ranking system
     */
    public double[][] getCrossRankings(ArrayList<Choice> choices, ArrayList<Characteristic> characteristics, int defaultValue) {
        double[][] crossRankings = new double[choices.size()][characteristics.size()];
        for (int i = 0; i < characteristics.size(); i++) {
            crossRankings[0][i] = defaultValue;
            int total = defaultValue;
            for (int j = 1; j < choices.size(); j++) {
                int rank = askInt("Considering " + characteristics.get(i) + " only, \nIf " + choices.get(0) + " has a value of " + defaultValue + ", what value would you assign to " + choices.get(j));
                total += rank;
                crossRankings[j][i] = (double)rank;
            }
            
            for (int j = 0; j < choices.size(); j++) {
                crossRankings[j][i] = crossRankings[j][i] / total;
            }
        }
        return crossRankings;
    }
    
    /**
     * Show the final results for the choice ranking
     * 
     * Takes the final scores stored by the choices and determines the winner
     * 
     * @param   choices the choices ranked by the decider
     */
    
    public void showResults(ArrayList<Choice> choices) {
        String results = "--------\n";
        Choice winner = choices.get(0);
        for (int i = 0; i < choices.size(); i++) {
            Choice c = choices.get(i);
            if (c.getFinalScore() >= winner.getFinalScore())
                winner = c;
            results += c + " - " + c.getFinalScore() + "\n";
        }
        tellUser("Preferred choice: " + winner + "\n" + results);
    }
}
