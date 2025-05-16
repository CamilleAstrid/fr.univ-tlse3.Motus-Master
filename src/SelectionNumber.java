import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SelectionNumber extends JOptionPane{

    public SelectionNumber(String type, String difficulte){
        ArrayList<String> options = new ArrayList<String>();
        options.add("6"); options.add("7"); options.add("8"); options.add("9");

        Object selection = JOptionPane.showInputDialog(
            this,
            "Combien de lettres ?",
            "Selection de la taille",
            JOptionPane.QUESTION_MESSAGE,
            null,
            options.toArray(),
            "6"
            );
        setVisible(true);

        // Ajout du listener quand on clique sur OK dans la boite de dialogue
        if (selection != null) {  // Vérifie si l'utilisateur n'a pas cliqué sur "Annuler"
            String selectedOption = String.valueOf(selection);
            int nb_letters = Integer.parseInt(selectedOption);
            new SelectionMot(type, nb_letters, difficulte);
        }
        else
            new Menu();
    }
}
