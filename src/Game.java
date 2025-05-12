import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Game extends Initialize {
    static int essai;
    static int tentative;
    static ArrayList<String> badLetters;
    static HashMap<String, String> goodPlace;
    static HashMap<String,String> niceTry;

    public Game(String type, int nb_letters, String motSecret, char firstLetter) {
        // Initialisation des paramètres
        essai = 6; tentative = 0;
        badLetters = new ArrayList<>(); goodPlace = new HashMap<>(); niceTry = new HashMap<>();
        Robot IA = new Robot();

        // Initialisation de la fenêtre
        this.setTitle("Motus-Master");
        this.setBackground(new Color(0x101044));
        this.setForeground(Color.WHITE);
        
        // Création haut de la fenêtre
        GridLayout topPanelLayout = new GridLayout(3,1,20,20);
        JPanel topPanel = new JPanel(topPanelLayout);
        topPanel.setBackground(new Color(0x101044));
        topPanel.setBorder(null);


        // Ajout du logo
        Image image = Toolkit.getDefaultToolkit().getImage("../data/motus.png");
        Image scaledImage = image.getScaledInstance(200, 200, image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(icon);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        topPanel.add(backgroundLabel, CENTER_ALIGNMENT);

        // Ajout de la grille de jeu
        JPanel panelWithGrid = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel gridPanel = new JPanel(new GridLayout(6, nb_letters));
        panelWithGrid.setBackground(new Color(0x101044));
        ArrayList<CaseLabel> cases = new ArrayList<>();

        for (int i = 0; i < essai * nb_letters; i++) {
            String letter;
            if (i%nb_letters == 0){
                letter = String.valueOf(firstLetter) ;
            }
            else{
                letter = " ";
            }
            CaseLabel textArea = new CaseLabel(letter);
            textArea.setEtat("none");
            textArea.setPreferredSize(new Dimension(50, 50));  // Taille des cases
            textArea.setBackground(Color.white); // Couleur de fond des cases
            textArea.setFont(new Font("Arial", Font.PLAIN, 20)); // Format de police des cases
            textArea.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2)); // Ajouter des bordures cyan néon visibles à la case
            gridPanel.add(textArea); // Ajouter la case à la grille
            cases.add(textArea);
        }
        panelWithGrid.add(gridPanel);
        topPanel.add(panelWithGrid);

        // Ajout de la zone de texte et du bouton "valider"
        FlowLayout proposePanelLayout = new FlowLayout(FlowLayout.CENTER);
        JPanel proposePanel = new JPanel(proposePanelLayout);
        proposePanel.setBackground(new Color(0x101044));

        String affichage = motSecret.replace(",", "");
        JTextField textField = new JTextField(affichage);
        textField.setBackground(Color.white);
        textField.setFont(new Font("Arial", Font.PLAIN, 20));
        textField.setEditable(false);
        textField.setForeground(Color.black);
        if (type.equals("N") || type.equals("JcJ")){
            textField.setEditable(true);
            textField.setText("Proposer un mot de " + nb_letters + " lettres");
        }
        proposePanel.add(textField);

        JButton validateButton = new JButton("Suivant");
        if (type.equals("N") || type.equals("JcJ")){
            validateButton.setText("Valider");
        }
        validateButton.setBackground(new Color(255, 100, 0));
        validateButton.setForeground(Color.black);
        validateButton.setFont(new Font("Arial", Font.PLAIN, 20));
        validateButton.setFocusPainted(false);
        validateButton.setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
        proposePanel.add(validateButton);

        topPanel.add(proposePanel);

        // Création bas de la fenêtre
        FlowLayout bottomPanelLayout = new FlowLayout(FlowLayout.CENTER);
        JPanel bottomPanel = new JPanel(bottomPanelLayout);
        bottomPanel.setBackground(new Color(0x101044));

        JButton rulesButton = new JButton("Règles du jeu");
        JButton menuButton = new JButton("Menu principal");
        JButton quitButton = new JButton("Quitter le jeu");
        bottomPanel.add(rulesButton);
        bottomPanel.add(menuButton);
        bottomPanel.add(quitButton);


        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topPanel, bottomPanel);
        splitPane.setDividerLocation((int)(getCurrentScreenSize().getHeight()*0.9));
        splitPane.setDividerSize(0); // Supprime la taille visible du séparateur
        splitPane.setEnabled(false); // Désactive le redimensionnement

        getContentPane().add(splitPane);

        // Ajout des listeners pour les boutons
        rulesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                new Rules("Game");
            }
        });
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                new Menu();
                dispose();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                System.exit(0);
            }
        });

        // Ajout du listener pour la zone de texte
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (type.equals("N")|| type.equals("JcJ"))
                    textField.setText(null);
            }
        });
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent entree){
                validateButton.doClick();
            }
        });
        
        // Ajout du listener pour le bouton "valider"
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                String motPropose = "";
                if (type.equals("N") || type.equals("JcJ")){
                    motPropose = textField.getText();
                }
                else{
                    motPropose = IA.proposerMot(nb_letters, motSecret, tentative, badLetters, goodPlace, niceTry);
                    String sub = motPropose.substring(0, nb_letters);
                    motPropose = sub;
                }
                    
                ArrayList<String> check = verifierMot(motSecret, motPropose, nb_letters, type);

                if (check.isEmpty())
                    textField.setText("Proposer un mot de " + nb_letters + " lettres");
                else if (tentative!=essai){
                    tentative++;
                    for (int position = 0; position<nb_letters; position++ ){
                        int index = (tentative - 1) * nb_letters + position; // tentative-1 car tentative déjà incrémentée
                        CaseLabel currentCase = cases.get(index);
                        String letterUp = String.valueOf(motPropose.charAt(position)).toUpperCase();
                        String letterDown = String.valueOf(motPropose.charAt(position)).toLowerCase();
                        String positionString = String.valueOf(position);
                        currentCase.setText(letterUp);
                        switch (check.get(position)) {
                            case "good":
                                currentCase.setEtat("good");
                                goodPlace.put(positionString,letterDown);
                                break;
                            case "nearly":
                                currentCase.setEtat("nearly");
                                niceTry.put(positionString,letterDown);
                                break;
                            case "nope":
                                currentCase.setEtat("nope");
                                badLetters.add(letterDown);
                                break;
                        }
                    }
                }
                else{
                    new ResultsEndGame("loose", type);
                }
            }
        });
        
        this.setVisible(true);
    }

    public ArrayList<String> verifierMot(String motSecret, String motPropose, int nb_letters, String type){
        ArrayList<String> res = new ArrayList<>();
        char firstLetter = motSecret.charAt(0);
        LoadData mots = new LoadData(nb_letters);
        motPropose = mots.motSecretLisibleCSV(motPropose);
        int taille = nb_letters + 1;
        if (motPropose.charAt(0)!=firstLetter){
            JOptionPane.showMessageDialog(
                this,
                "Le mot doit commencer par la lettre " + firstLetter,
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
            return res;
        }
        else if (motPropose.length()!=taille){
            JOptionPane.showMessageDialog(
                this,
                "Le mot doit contenir " + nb_letters + " lettres.",
                "Erreur",
                JOptionPane.ERROR_MESSAGE);
            return res;
        }
        else if (motPropose.equals(motSecret)){
            new ResultsEndGame("win", type);
            dispose();
            return res;
        }
        else{
            for (int i = 0; i < taille; i++){
                if (motPropose.charAt(i) == motSecret.charAt(i)){
                    res.add("good");
                }
                else if (motSecret.contains(String.valueOf(motPropose.charAt(i)))){
                    res.add("nearly");
                }
                else {
                    res.add("nope");
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        new Game("IcI", 6, "police", "p".charAt(0));
    }
}
