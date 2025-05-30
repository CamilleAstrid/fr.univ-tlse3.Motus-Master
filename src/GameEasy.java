import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;

public class GameEasy extends Initialize {
    static String difficulte;
    static int essai;
    static int tentative;
    static ArrayList<String> badLetters;
    static HashMap<String, String> goodPlace;
    static HashMap<String,String> niceTry;

    public GameEasy(String type, int nb_letters, String motSecret, char firstLetter) {
        // Initialisation des paramètres
        essai = 10; tentative = 0; difficulte = "Facile";
        badLetters = new ArrayList<>(); goodPlace = new HashMap<>(); niceTry = new HashMap<>();
        Robot IA = new Robot();

        // Initialisation de la fenêtre
        this.setTitle("Motus-Master");
        this.setBackground(motusColor);
        this.setForeground(Color.WHITE);
        
        // Création haut de la fenêtre
        GridLayout topPanelLayout = new GridLayout(3,1,20,20);
        JPanel topPanel = new JPanel(topPanelLayout);
        topPanel.setBackground(motusColor);
        topPanel.setBorder(null);

        // Ajout du logo
        Image image = Toolkit.getDefaultToolkit().getImage("../data/motus.png");
        Image scaledImage = image.getScaledInstance(-1, 200, image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);
        JLabel backgroundLabel = new JLabel(icon);
        backgroundLabel.setBounds(0, 0, getWidth(), getHeight());
        topPanel.add(backgroundLabel, CENTER_ALIGNMENT);

        // Ajout de la grille de jeu
        JPanel gridPanel = new JPanel(new GridLayout(essai, nb_letters));
        ArrayList<CaseLabel> cases = new ArrayList<>();

        for (int i = 0; i < essai * nb_letters; i++) {
            String letter;
            if (i%nb_letters == 0){
                letter = String.valueOf(firstLetter).toUpperCase() ;
            }
            else{
                letter = " ";
            }
            CaseLabel textArea = new CaseLabel(letter);
            textArea.setEtat("none");
            textArea.setPreferredSize(new Dimension(50, 50));  // Taille des cases
            textArea.setBackground(Color.blue); // Couleur de fond des cases
            textArea.setForeground(Color.white);
            textArea.setFont(new Font("Arial", Font.BOLD, 20)); // Format de police des cases
            textArea.setBorder(BorderFactory.createLineBorder(Color.black, 2)); // Ajouter des bordures cyan néon visibles à la case
            gridPanel.add(textArea); // Ajouter la case à la grille
            cases.add(textArea);
        }
        topPanel.add(gridPanel);

        // Ajout de la zone de texte et du bouton "valider"
        FlowLayout proposePanelLayout = new FlowLayout(FlowLayout.CENTER);
        JPanel proposePanel = new JPanel(proposePanelLayout);
        proposePanel.setBackground(motusColor);

        JComboBox<String> selectionMotPropose;
        LoadData liste = new LoadData(nb_letters);
        liste.generate();
        Object propositions[] = liste.liste.toArray();
        for (int i=0; i<liste.liste.size(); i++){
            propositions[i] = propositions[i].toString().substring(0,nb_letters);
        }
        selectionMotPropose = new JComboBox(propositions);

        proposePanel.add(selectionMotPropose);

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
        bottomPanel.setBackground(motusColor);

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

        // Ajout du listener pour le bouton "valider"
        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent clic) {
                String motPropose = "";
                if (type.equals("N") || type.equals("JcJ")){
                    motPropose = String.valueOf(selectionMotPropose.getSelectedItem());
                }
                else{
                    motPropose = IA.proposerMot(nb_letters, motSecret, tentative, badLetters, goodPlace, niceTry);
                    String sub = motPropose.substring(0, nb_letters);
                    motPropose = sub;
                }
                    
                ArrayList<String> check = verifierMot(motSecret, motPropose, nb_letters, type);

                if (tentative!=essai-1){
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
                    new ResultsEndGame("loose", type, motSecret, tentative, difficulte);
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
            new ResultsEndGame("win", type, motSecret, tentative, difficulte);
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
}
