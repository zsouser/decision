import java.util.List;
import java.util.ArrayList;
import java.lang.Math.*;
/**
 * Decision support utility.
 */
public class Decider {
    public static void main(String[] args) {
        final int STANDARD = 10;
        ArrayList<Choice> choices;
        ArrayList<Characteristic> characteristics;
        double[][] crossRankings;
        UserInterface ui;
        
        //ui = new ConsoleUserInterface(); //
        ui = new GraphicalUserInterface();
        
        choices = ui.getChoices();
        characteristics = ui.getCharacteristics();
        
        ui.getCharacteristicRankings(characteristics, STANDARD);
        crossRankings = ui.getCrossRankings(choices, characteristics, STANDARD);
        
        calculateFinalScores(choices, characteristics, crossRankings);
        
        ui.showResults(choices);
    }
    /** Fill in the finalScore attribute for every choice. */
    private static void calculateFinalScores(List<Choice> choices,
                                             List<Characteristic> characs,
                                             double[][] crossRankings) {
        double[] scores = new double[choices.size()];   
        double max = 0.0;
        for (int i = 0; i < choices.size(); i++) {
            for (int j = 0; j < characs.size(); j++) {
                scores[i] += characs.get(j).getRank() * crossRankings[i][j];
                choices.get(i).setFinalScore((int)Math.round(crossRankings[i][j]*100));
            }
            if (scores[i] > max) max = scores[i];
        }
        
        for (int i = 0; i < scores.length; i++) {
            choices.get(i).setFinalScore((int)(Math.round(scores[i] / max *100)));
        }
    }
}