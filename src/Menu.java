import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class Menu extends JFrame{
    
    public Menu(){
        this.setTitle("Menu");
        Dimension currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(currentScreenSize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x0A0A2A));

        JButton JcJ = new JButton("JcJ");
        JButton JcI = new JButton("JcI");
        JButton IcI = new JButton("IcI");
        JButton Regles = new JButton("Règles");
        JButton Quitter = new JButton("Quitter");

        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);
        FlowLayout buttonStartLayout = new FlowLayout(FlowLayout.CENTER,15,15);
        JPanel buttonStartPanel= new JPanel(buttonStartLayout);
        buttonStartPanel.setBackground(new Color(0x0A0A2A));
        FlowLayout buttonLayout = new FlowLayout(FlowLayout.CENTER,15,15);
        JPanel buttonPanel = new JPanel(buttonLayout);
        buttonPanel.setBackground(new Color(0x0A0A2A));
        JPanel backgroundPanel = new JPanel();
        
        Image image = Toolkit.getDefaultToolkit().getImage("fr.univ-tlse3.Motus-Master/data/motus.png");
        ImageIcon icon = new ImageIcon(image);
        JLabel backgroundLabel = new JLabel(icon);


        buttonStartPanel.add(JcJ); buttonStartPanel.add(JcI); buttonStartPanel.add(IcI);
        buttonPanel.add(Regles); buttonPanel.add(Quitter);
        this.add(backgroundLabel, BorderLayout.CENTER);
        this.add(buttonStartPanel, BorderLayout.PAGE_START);
        this.add(buttonPanel, BorderLayout.PAGE_END);

        //Listeners
        JcJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                
            }
        });
        JcI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                
            }
        });
        IcI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                
            }
        });
        Regles.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                new Rules();
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
