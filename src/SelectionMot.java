import javax.swing.JOptionPane;

public class SelectionMot extends JOptionPane{

    public SelectionMot(String type, int nb_letters, String difficulte){
        String motSecret = "";
        LoadData mots = new LoadData(nb_letters);
        mots.generate();

        if (type.equals("O") || type.equals("JcJ")){
            String selection = JOptionPane.showInputDialog(
                this,
                "Quel est le mot à deviner ?",
                "Selection du mot",
                JOptionPane.QUESTION_MESSAGE
                );
            setVisible(true);

            // Ajout du listener quand on clique sur OK dans la boite de dialogue
            if (selection==null){
                new Menu();
                return; //  Permet de gerer une erreur
                // Exception in thread "AWT-EventQueue-0" java.lang.StringIndexOutOfBoundsException: Index 0 out of bounds for length 0
                // Erreur provoquée par les dernières lignes du constructeur dans le cas ou l'on fait "annuler".
            }
            else if (selection.length() != nb_letters) {
                JOptionPane.showMessageDialog(
                    this,
                    "Le mot doit contenir " + nb_letters + " lettres.",
                    "Erreur",
                    JOptionPane.ERROR_MESSAGE);
                
                new SelectionMot(type, nb_letters, difficulte); // Relance la sélection du mot
            }
            else {  // Vérifie si l'utilisateur n'a pas cliqué sur "Annuler"
                motSecret = String.valueOf(selection);
                String motSecretLisibleCSV = mots.motSecretLisibleCSV(motSecret);

                while (!mots.liste.contains(motSecretLisibleCSV)){
                    new SelectionMot(type, nb_letters, difficulte); // Relance la sélection du mot
                }
                motSecret = motSecretLisibleCSV;
            }
        }
        else{
            motSecret = mots.motSecret;
        }

        char firstLetter = motSecret.charAt(0);

        if (difficulte.equals("Normal")){
            new Game(type, nb_letters, motSecret, firstLetter);
        }
        else if (difficulte.equals("Facile")){
            new GameEasy(type, nb_letters, motSecret, firstLetter);
        }
        else{
            new GameHard(type, nb_letters, motSecret, firstLetter);
        }
    }
}
