import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Rules extends JFrame{
        
    public Rules(){
        this.setTitle("Rules");
        Dimension currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(currentScreenSize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(0x101044));

        //Ajout bouton pour retourner au menu
        JButton retour = new JButton("Retour");
        FlowLayout mainLayout = new FlowLayout(FlowLayout.RIGHT,15,15);
        this.setLayout(mainLayout);

        //Ajout du texte explicatif
        JTextPane textPane = new JTextPane();
        String text = LoadData.Rules();
        textPane.setText(text);


        add(retour);

        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                new Menu();
                dispose();
            }
        });











        this.setVisible(true);
    }
}
