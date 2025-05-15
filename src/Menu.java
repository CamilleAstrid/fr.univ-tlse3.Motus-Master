import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Menu extends Initialize{
    
    public Menu(){
        // Initialisation de la fenetre
        this.setTitle("Menu");
        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        
        // Ajout des boutons
        JButton JcJ = new JButton("JcJ");
        JButton JcI = new JButton("JcI");
        JButton IcI = new JButton("IcI");
        JButton Regles = new JButton("Règles");
        JButton Quitter = new JButton("Quitter");

        FlowLayout buttonLayout = new FlowLayout(FlowLayout.CENTER,15,15);
        JPanel buttonStartPanel= new JPanel(buttonLayout);
        JPanel buttonPanel = new JPanel(buttonLayout);
        buttonStartPanel.setBackground(motusColor);
        buttonPanel.setBackground(motusColor);
     
        // Ajout du logo
        Image image = Toolkit.getDefaultToolkit().getImage("../data/motus.png");
        ImageIcon icon = new ImageIcon(image);

        // Ajout texte a cote du logo
        String File = "../data/Menu.txt";
        String text = LoadData.Text(File);

        JTextPane textMenu = new JTextPane();
        JLabel backgroundLabel = new JLabel(icon);
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


        buttonStartPanel.add(JcJ); buttonStartPanel.add(JcI); buttonStartPanel.add(IcI);
        buttonPanel.add(Regles); buttonPanel.add(Quitter);

        this.add(imagePanel, BorderLayout.CENTER);
        this.add(buttonStartPanel, BorderLayout.PAGE_START);
        this.add(buttonPanel, BorderLayout.PAGE_END);
        
        //Listeners
        JcJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                new SelectionDifficulte("JcJ");
                dispose();
            }
        });
        JcI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                new SelectionType();
                dispose();
            }
        });
        IcI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                new SelectionDifficulte("IcI");
                dispose();
            }
        });
        Regles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                new Rules("Menu");
                dispose();
            }
        });
        Quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                System.exit(0);
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Menu();
    }
}
