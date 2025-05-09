import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SelectionNumber extends JOptionPane{

    public SelectionNumber(String type){
        int nb_letters = 6; // Valeur par défaut        
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
            nb_letters = Integer.parseInt(selectedOption);
            if (type.equals("O") || type.equals("JcJ") || type.equals("IcI"))
                new SelectionMot(type, nb_letters);
            else{
                LoadData mots = new LoadData(nb_letters);
                mots.generate();
                String motSecret = mots.motSecret;
                char firstLetter = motSecret.charAt(0);
                new Game(type, nb_letters, motSecret, firstLetter);
            }
        }
    }
}
