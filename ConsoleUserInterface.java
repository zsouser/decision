import javax.swing.JOptionPane;
import java.lang.Integer;
import java.util.Scanner;
/**
 * Console user interface for decision support application.
 * 
 * @author  Zach Souser
 * @version 1.0
 */
public class ConsoleUserInterface extends DecisionUserInterface {
    /**
     * Implement the askString method with Scanner
     * 
     * @param   question    the question
     * @return  the answer
     */
    public String askString(String question) {
        System.out.println(question + "?");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
    /**
     * Implement askInt method
     * 
     * @param   question    the question
     * @return  the answer
     */
    public int askInt(String question) {
        try {
            return Integer.parseInt(askString(question));
        } catch (NumberFormatException e) {
            return askInt("Invalid Number: " + question);
        }
    }
    
    /**
     * Implemennt the tellUser method
     * 
     * @param   message the message to be relayed
     */
    public void tellUser(String message) {
        System.out.println(message);
    }

}