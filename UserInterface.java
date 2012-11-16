import java.util.List;
import java.util.ArrayList;
/**
 * User interface for decision support application.
 */
public interface UserInterface {
  ArrayList<Choice> getChoices();
  ArrayList<Characteristic> getCharacteristics();
  void getCharacteristicRankings(ArrayList<Characteristic> alc,
                                 int defaultValue);
  double[][] getCrossRankings(
            ArrayList<Choice> choices,
            ArrayList<Characteristic> characteristics,
            int defaultValue);
  void showResults(ArrayList<Choice> choices);
}