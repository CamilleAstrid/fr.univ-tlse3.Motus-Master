import java.util.ArrayList;

public class Robot implements Joueur {
    String motPropose;
    String motSecret;
    ArrayList<String> liste = new ArrayList<>();

    // Constructeur
    public Robot() {
        // Constructeur de la classe Robot
        this.motPropose = motPropose;
        this.motSecret = motSecret;
        this.liste = liste;
    }

    // Méthodes
    @Override
    public String definirMot(int nb_letters) {
        String File = "fr.univ-tlse3.Motus-Master/data/mots_" + nb_letters + "_lettres.csv";
        Load_data mots = new Load_data(File);
        mots.generate();
        motSecret = mots.motSecret;
        return motSecret;
    }

    @Override
    public String proposerMot(int taille, String motSecret, int iteration, ArrayList<String> badLetters) {
        String File = "fr.univ-tlse3.Motus-Master/data/mots_" + taille + "_lettres.csv";
        Load_data mots = new Load_data(File);
        mots.generate();
        
        if (iteration == 0) {
            for (String mot : mots.liste) {
                if (mot.charAt(0) == motSecret.charAt(0)) {
                    liste.add(mot);
                }
                if (mot.charAt(0) > motSecret.charAt(0)) {
                    break;
                }
            }
            motPropose = liste.get(0);
        } else {
            for (String mot : mots.liste) {
                String motTemp = mot;
                for (String badLetter : badLetters) {
                    if (motTemp.contains(badLetter)) {
                        mots.liste.remove(motTemp);
                        break;
                    }
                }
            }
            motPropose = liste.get(0);
        }
        
        return motPropose;
    }
}  

