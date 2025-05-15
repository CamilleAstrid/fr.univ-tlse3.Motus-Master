import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SelectionDifficulte extends JOptionPane{

    public SelectionDifficulte(String type){
        ArrayList<String> options = new ArrayList<String>();
        options.add("Facile"); options.add("Normal"); options.add("Difficile");

        Object selection = JOptionPane.showInputDialog(
            this,
            "Choisissez votre difficulté",
            "Selection de la difficulté",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options.toArray(),
            "Normal"
            );
        setVisible(true);

        // Ajout du listener quand on clique sur OK dans la boite de dialogue
        if (selection != null) {  // Vérifie si l'utilisateur n'a pas cliqué sur "Annuler"
            String difficulte = String.valueOf(selection);
            new SelectionNumber(type, difficulte);
        }
        else
            new Menu();
    }
}
