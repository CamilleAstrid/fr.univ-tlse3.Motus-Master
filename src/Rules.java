import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends Initialize{
        
    public Rules(String from){
        this.setTitle("Rules");
        
        //Ajout du texte explicatif
        String text = LoadData.Rules();

        //Ajout bouton pour retourner au menu
        JButton retour = new JButton("Retour");

        //Creation des layouts
        JTextArea textArea = new JTextArea(text);
        textArea.setLineWrap(true); // Permet de faire un retour à la ligne automatique
        textArea.setWrapStyleWord(true); // Permet de ne pas couper les mots
        textArea.setMargin(new Insets(20,20,20,200)); // Ajout d'une marge autour du texte
        textArea.setBackground(new Color(0x101044));
        textArea.setForeground(Color.white);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(new Color(0x101044));
        rightPanel.add(retour, BorderLayout.NORTH);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, rightPanel);
        splitPane.setDividerLocation((int)(getCurrentScreenSize().getWidth()*0.9)); 

        getContentPane().add(splitPane);        

        if (from.equals("Menu")){
            retour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent clic) {
                    new Menu();
                    dispose();
                }
            });
        }
        else if (from.equals("Game")){
            retour.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent clic) {
                    dispose();
                }
            });
        }
        
        this.setVisible(true);
    }
}
