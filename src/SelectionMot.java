import javax.swing.JOptionPane;

public class SelectionMot extends JOptionPane{

    public SelectionMot(String type, int nb_letters){

        String selection = JOptionPane.showInputDialog(
            this,
            "Quel est le mot à deviner ?",
            "Selection du mot",
            JOptionPane.QUESTION_MESSAGE
            );
        setVisible(true);

        // Ajout du listener quand on clique sur OK dans la boite de dialogue
        if (selection.length() != nb_letters) {
            JOptionPane.showMessageDialog(
                this,
                "Le mot doit contenir " + nb_letters + " lettres.",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
            
            new SelectionMot(type, nb_letters); // Relance la sélection du mot
        }
        else if (selection != null) {  // Vérifie si l'utilisateur n'a pas cliqué sur "Annuler"
            String motSecret = String.valueOf(selection);
            LoadData mots = new LoadData(nb_letters);
            mots.generate();
            String motSecretLisibleCSV = mots.motSecretLisibleCSV(motSecret);

        while (!mots.liste.contains(motSecretLisibleCSV)){
            new SelectionMot(type, nb_letters); // Relance la sélection du mot
        }
        char firstLetter = motSecret.charAt(0);

        new Game(type, nb_letters, motSecretLisibleCSV, firstLetter);
        }
    }
}
