import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Toolkit;

public class InterfaceMotus {
    JFrame fenetre = new JFrame("Motus Master");
    
    public InterfaceMotus() {
        Dimension currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        fenetre.setSize(currentScreenSize);
        fenetre.setUndecorated(false);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);
    }

    public static void main(String[] args) {
        InterfaceMotus affichage = new InterfaceMotus();
    }

}
