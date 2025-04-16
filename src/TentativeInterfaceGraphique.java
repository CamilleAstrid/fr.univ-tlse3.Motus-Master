import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.FileSystem;

public class TentativeInterfaceGraphique {
    JFrame menu_fenetre = new JFrame("Motus Master");
    JFrame game_fenetre = new JFrame("Motus Master");
    JFrame result_fenetre = new JFrame("Motus Master");
    JFrame rules_fenetre = new JFrame("Motus Master");

    public TentativeInterfaceGraphique() {

        // Set the size of the JFrame to the screen size
        Dimension currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        menu_fenetre.setSize(currentScreenSize);
        game_fenetre.setSize(currentScreenSize);
        result_fenetre.setSize(currentScreenSize);
        rules_fenetre.setSize(currentScreenSize);

        // Set the default close operation
        menu_fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game_fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        result_fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rules_fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Set the visibility of the frames
        menu_fenetre.setVisible(true);
        game_fenetre.setVisible(false);
        result_fenetre.setVisible(false);
        rules_fenetre.setVisible(false);
    }

    public String chargerFichier(String nomFichier) {
		try{
			   BufferedReader buf = new BufferedReader(new FileReader(nomFichier));
			   String line = buf.readLine();
			   int indiceLigne = 0;
               String texte = "";
			   while(line != null){
				   System.out.println(indiceLigne+": "+line);
				   indiceLigne++;
			       line = buf.readLine();
                   texte += line+"\n";
			   }
			   buf.close();
               return texte;
			} 
			catch (IOException e){
			   e.printStackTrace();
                return null;
			}
	}

    // Methodes pour afficher les différentes fenêtres
    public void showMenu() {
        menu_fenetre.setVisible(true);
        game_fenetre.setVisible(false);
        result_fenetre.setVisible(false);
        rules_fenetre.setVisible(false);
    }
    public void showGame() {
        menu_fenetre.setVisible(false);
        game_fenetre.setVisible(true);
        result_fenetre.setVisible(false);
        rules_fenetre.setVisible(false);
    }
    public void showResult() {
        menu_fenetre.setVisible(false);
        game_fenetre.setVisible(false);
        result_fenetre.setVisible(true);
        rules_fenetre.setVisible(false);
    }
    public void showRules() {
        menu_fenetre.setVisible(false);
        game_fenetre.setVisible(false);
        result_fenetre.setVisible(false);
        rules_fenetre.setVisible(true);
    }

    // Methodes pour créer les différentes fenêtres
    public void createMenu(){
        // Create a JPanel for the menu
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1, 4));

        menu_fenetre.setLocationRelativeTo(null); // Center the window on the screen

        // Create buttons for the menu
        JButton startButton = new JButton("Start JcJ");
        JButton startSoloButton = new JButton("Start JcIA");
        JButton rulesButton = new JButton("Rules");
        JButton exitButton = new JButton("Exit");

        // Add action listeners to the buttons
        startButton.addActionListener(e -> {
            showGame();
        });
        rulesButton.addActionListener(e -> {
            showRules();
        });
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
        startSoloButton.addActionListener(e -> {
            showGame();
        });

        // Add buttons to the menu panel
        menuPanel.add(startButton);
        menuPanel.add(rulesButton);
        menuPanel.add(exitButton);
        menuPanel.add(startSoloButton);
        // Get the center location of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int)screenSize.getWidth()/ 2;
        int y = (int)screenSize.getHeight()/ 2;
        menuPanel.setLocation(x,y); // Center the window on the screen
        // Add the menu panel to the JFrame
        menu_fenetre.add(menuPanel);
        menu_fenetre.setVisible(true);
    }
    public void createRules(String rules_absolutePath){
        JPanel rulesPanel = new JPanel();
        rulesPanel.setLayout(new GridLayout(1, 1));
        String rules = chargerFichier(rules_absolutePath);
        JLabel rulesLabel = new JLabel(rules);
        rulesPanel.add(rulesLabel);

        // Get the center location of the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int)screenSize.getWidth()/ 2;
        int y = (int)screenSize.getHeight()/ 2;
        rulesPanel.setLocation(x, y); // Center the window on the screen
        rules_fenetre.add(rulesPanel);
        rules_fenetre.setVisible(true);

        //AJOUTER UNE BARRE DE DELFILEMENT
    }

    public static void main(String[] args) {
        FileSystem fs = FileSystems.getDefault();
        Path chemin = fs.getPath("fr.univ-tlse3.Motus-Master"+fs.getSeparator()+"data"+fs.getSeparator()+"Rules.txt");
        Path absolu = chemin.toAbsolutePath();
        System.out.println(absolu.toString());

        // Create an instance of the TentativeInterfaceGraphique class
        TentativeInterfaceGraphique interfaceGraphique = new TentativeInterfaceGraphique();

        // Create the menu and rules
        interfaceGraphique.createMenu();
        interfaceGraphique.createRules(absolu.toString());

        // Show the menu
        interfaceGraphique.showMenu();
        // Show the rules
        interfaceGraphique.showRules();
    }
}
