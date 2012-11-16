import javax.swing.*;

/**
 * Graphical UI for decision UI, using JOptionPane
 * 
 * @author Zach Souser
 * @version 1.0
 */
public class GraphicalUserInterface extends DecisionUserInterface
{
    JOptionPane pane;
    /**
     * Constructor for objects of class GraphicalUserInterface
     */
    public GraphicalUserInterface()
    {
        pane = new JOptionPane();
        pane.setSize(400,100);
    }

    /**
     * Ask the user a question
     * 
     * @param  question the question
     * @return the string submitted by the user 
     */
    public String askString(String question)
    {
       String response = pane.showInputDialog(pane, question);
       if (response == null) System.exit(1);
       return response;
    }
    
    
    /**
     * Ask the user for an integer
     * 
     * @param   question    the question
     * @return  the integer supplied by the user
     */
    
    public int askInt(String question) 
    {
        try {
            String answer = askString(question);
            if (answer.isEmpty()) return 0;
            return Integer.parseInt(answer);
        } catch (NumberFormatException e) {
            return askInt("Invalid Number: " + question);
        }
    }
    
     
    
    /**
     * Tell the user something
     * 
     * @param message The message to be passed to the user
     */
    
    public void tellUser(String message) {
        pane.showMessageDialog(pane, message);
    }
    
}
