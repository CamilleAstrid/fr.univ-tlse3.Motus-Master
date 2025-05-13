import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends Initialize{
    
    public Menu(){
        this.setTitle("Menu");
        BorderLayout mainLayout = new BorderLayout();
        this.setLayout(mainLayout);

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
     
        Image image = Toolkit.getDefaultToolkit().getImage("../data/motus.png");
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
                new SelectionNumber("JcJ");
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
                new SelectionNumber("IcI");
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
