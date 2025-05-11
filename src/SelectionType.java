import javax.swing.JOptionPane;

public class SelectionType extends JOptionPane{

    public SelectionType(){
        String type = ""; // Valeur par défaut        

        Object selection = JOptionPane.showConfirmDialog(
            this,
            "Voulez-vous faire deviner votre mot à la machine ?",
            "Selection du type de jeu",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null
            );
        setVisible(true);

        // Ajout du listener quand on clique sur OK dans la boite de dialogue
        if (selection.equals(JOptionPane.YES_OPTION)) {
            // Si l'utilisateur a cliqué sur "Oui"
                type = "O";
        }
        else if (selection.equals(JOptionPane.NO_OPTION)){
            // Si l'utilisateur a cliqué sur "Non"
                type = "N";
        }
        else
            new Menu();
        new SelectionNumber(type);
    }
}