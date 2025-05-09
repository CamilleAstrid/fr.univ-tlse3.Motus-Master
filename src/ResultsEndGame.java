import java.awt.*;
import javax.swing.*;

public class ResultsEndGame extends Initialize{
    
    public ResultsEndGame(String etat){
        Image image;
        JButton Menu = new JButton("Menu");
        JButton Rejouer = new JButton("Rejouer");
        JButton Regles = new JButton("Règles");
        JButton Quitter = new JButton("Quitter");

        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        
        FlowLayout buttonLayout = new FlowLayout(FlowLayout.CENTER,15,15);
        JPanel buttonPanel = new JPanel(buttonLayout);
        buttonPanel.setBackground(new Color(0x0A0A2A));

        if (etat.equals("win")){
            this.setTitle("Victory");
            image = Toolkit.getDefaultToolkit().getImage("../data/win.png");
        }
        else{
            this.setTitle("Loose");
            image = Toolkit.getDefaultToolkit().getImage("../data/loose.png");
        }
        ImageIcon icon = new ImageIcon(image);
        JLabel backgroundLabel = new JLabel(icon);
        
        buttonPanel.add(Menu); buttonPanel.add(Rejouer); buttonPanel.add(Regles); buttonPanel.add(Quitter);
        this.add(backgroundLabel, BorderLayout.CENTER);
    }
}
