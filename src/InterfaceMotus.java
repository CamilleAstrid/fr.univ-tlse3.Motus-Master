import javax.swing.*;

import java.awt.*;

public class InterfaceMotus {
    JFrame fenetre = new JFrame("Motus Master");
    
    public InterfaceMotus() {
        Dimension currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        fenetre.setSize(currentScreenSize);
        fenetre.setUndecorated(false);
        fenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fenetre.setVisible(true);
    }

    public void AffichageGrille(int nb_letters, boolean terminal) {
        if (terminal) {
            System.out.println("--".repeat(nb_letters));
            for (int i = 0; i < 5; i++) {
                System.out.print("| ");
                for (int j = 0; j < nb_letters; j++) {
                    System.out.print(Plateau.grille[j][i] + " | ");
                }
                System.out.println();
                System.out.println("--".repeat(nb_letters));
            }
        } else {
            // Affichage sur interface graphique
            JPanel panel = new JPanel();
            GridLayout gridLayout = new GridLayout(5, nb_letters);
            panel.setLayout(gridLayout);
            for (int i = 0; i < nb_letters*5; i++) {
                JLabel label = new JLabel(Case.VIDE.getSymbole());
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add(label);
            }
            //ajoute les bordures de la grille avec setBorder
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            fenetre.add(panel);
            fenetre.setVisible(true);
        }
    }

    public static void main(String[] args) {
        // Exemple d'utilisation
        InterfaceMotus interfaceMotus = new InterfaceMotus();
        interfaceMotus.AffichageGrille(5, false);
    }

}
