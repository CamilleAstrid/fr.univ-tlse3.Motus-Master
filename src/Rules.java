import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends Initialize{
        
    public Rules(String from){
        this.setTitle("Rules");
        
        //Ajout du texte explicatif
        String File = "../data/Rules.txt";
        String text = LoadData.Text(File);

        //Ajout bouton pour retourner au menu
        JButton retour = new JButton("Retour");

        //Creation des layouts

        JTextPane textPane = new JTextPane(){
            @Override
            public boolean getScrollableTracksViewportWidth() {
                return getUI().getPreferredSize(this).width <= getParent().getSize().width;
            }
        };
        textPane.setContentType("text/html");
        textPane.setText(text);
        textPane.setEditable(false);
        textPane.setBackground(new Color(0x101044));
        textPane.setForeground(new Color(0xFF33FF));
        textPane.setFont(new Font("Consolas", Font.BOLD, 16));
        textPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        

        //JTextArea textArea = new JTextArea(text);
        //textArea.setLineWrap(true); // Permet de faire un retour à la ligne automatique
        //textArea.setWrapStyleWord(true); // Permet de ne pas couper les mots
        //textArea.setMargin(new Insets(20,20,20,200)); // Ajout d'une marge autour du texte
        //textArea.setBackground(motusColor);
        //textArea.setForeground(Color.white);
        //textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        //textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(motusColor);
        rightPanel.add(retour, BorderLayout.NORTH);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scrollPane, rightPanel);
        splitPane.setDividerLocation((int)(getCurrentScreenSize().getWidth()*0.9));
        splitPane.setDividerSize(0); // Supprime la taille visible du séparateur
        splitPane.setEnabled(false); // Désactive le redimensionnement

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
        else {
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
