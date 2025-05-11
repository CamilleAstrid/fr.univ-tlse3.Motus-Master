import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class ResultsEndGame extends Initialize{
    
    public ResultsEndGame(String etat, String type){
        String filename;

        if (etat.equals("win")){
            this.setTitle("Victory");
            filename = "../data/win.png";
        }
        else{
            this.setTitle("Loose");
            filename = "../data/loose.png";
        }
        
        JButton Menu = new JButton("Menu");
        JButton Rejouer = new JButton("Rejouer");
        JButton Regles = new JButton("Règles");
        JButton Quitter = new JButton("Quitter");

        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        
        FlowLayout buttonLayout = new FlowLayout(FlowLayout.CENTER,15,15);
        JPanel buttonPanel = new JPanel(buttonLayout);
        buttonPanel.setBackground(new Color(0x0A0A2A));

        Image image = Toolkit.getDefaultToolkit().getImage(filename);
        ImageIcon icon = new ImageIcon(image);
        JLabel backgroundLabel = new JLabel(icon);
        
        buttonPanel.add(Menu); buttonPanel.add(Rejouer); buttonPanel.add(Regles); buttonPanel.add(Quitter);
        add(buttonPanel, BorderLayout.PAGE_END); add(backgroundLabel, BorderLayout.CENTER);

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
                    new SelectionNumber(type);
                else
                    new SelectionType();
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

        setVisible(true);
    }
}
