import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultsEndGame extends Initialize{
    
    public ResultsEndGame(String etat, String type, String motSecret, int tentative){
        String filename;
        String text="";

        if (etat.equals("win")){
            this.setTitle("Victory");
            filename = "../data/win.png";
            if (tentative==0)
                text = "Faisons un bref récap de tes stats\n"
                +"sur cette game.\n\n\n"
                +"Le mot secret était : "+motSecret.substring(0, motSecret.length()-1)+"\n\n\n"
                +"Tu l'as eu first try !\n\n\n"
                +"Mouais, si tu veux mon avis..."
                +"Arrête la triche et recommence !"
                ;
            else
                text = "GG, WP !\n"
                +"C'était une sacré belle partie...\n\n\n"
                +"Faisons un bref récap de tes stats sur cette game :\n\n\n"
                +"Le mot secret était : "+motSecret.substring(0, motSecret.length()-1)+"\n\n\n"
                +"Okay tu l'as trouvé mais \n"
                +"dans le cas où t'as juste gamble\n"
                +"je te le donne pour ta culture !\n\n\n"
                +"T'as essayé "+String.valueOf(tentative+1)+" fois...\n"
                +"Si tu veux mon avis, c'est "+String.valueOf(tentative)+" de trop !\n\n\n"
                +"Allez recommence mon grand !"
                ;
        }
        else{
            this.setTitle("Lose");
            filename = "../data/lose.png";
            text = "Oh le boulet !\n"
                +"C'était une sacré longue partie...\n\n\n"
                +"Faisons un bref récap de tes stats sur cette game :\n\n\n"
                +"Et dire que t'as pas réussi à le trouver...\n"
                +"t'es même pas bon à gamble.\n\n"
                +"Le mot secret était : "+motSecret.substring(0, motSecret.length()-1)+"\n\n\n"
                +"Allez c'est cadeau,\n"
                +"je te le donne pour ta culture !\n\n\n"
                +"T'as essayé "+String.valueOf(tentative+1)+" fois...\n"
                +"Si tu veux mon avis, c'est "+String.valueOf(tentative)+" de trop !\n\n\n"
                +"Allez recommence mon grand, tu peux que faire mieux !"
                ;
        }
        
        JButton Menu = new JButton("Menu");
        JButton Rejouer = new JButton("Rejouer");
        JButton Regles = new JButton("Règles");
        JButton Quitter = new JButton("Quitter");

        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        
        FlowLayout buttonLayout = new FlowLayout(FlowLayout.CENTER,15,15);
        JPanel buttonPanel = new JPanel(buttonLayout);
        buttonPanel.setBackground(motusColor);

        // Ajout du logo
        Image image = Toolkit.getDefaultToolkit().getImage(filename);
        ImageIcon icon = new ImageIcon(image);
        JLabel backgroundLabel = new JLabel(icon);
        
        // Ajout texte a cote du logo
        JTextPane textMenu = new JTextPane();
        textMenu.setBackground(motusColor);
        textMenu.setForeground(new Color(0xFF33FF));
        textMenu.setFont(new Font("Arial", Font.BOLD, 30));
        textMenu.setEditable(false);
        textMenu.setText(text);

        StyledDocument doc = textMenu.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);


        // Regroupe logo et texte
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.X_AXIS));
        imagePanel.setBackground(motusColor);
        imagePanel.add(backgroundLabel);
        imagePanel.add(Box.createRigidArea(new Dimension(20, 0))); // espace
        imagePanel.add(textMenu);

        buttonPanel.add(Menu); buttonPanel.add(Rejouer); buttonPanel.add(Regles); buttonPanel.add(Quitter);
        add(buttonPanel, BorderLayout.PAGE_END); add(imagePanel, BorderLayout.CENTER);

        Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic){
                new Menu();
                dispose();
            }
        });
        Rejouer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic){
                if (type.equals("JcJ") || type.equals("IcI"))
                    new SelectionDifficulte(type);
                else
                    new SelectionType();
                dispose();
            }
        });
        Regles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                new Rules("Result");
            }
        });
        Quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                System.exit(0);
            }
        });

        setVisible(true);
    }
}
