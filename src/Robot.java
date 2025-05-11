import java.util.ArrayList;
import java.util.HashMap;

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
        LoadData mots = new LoadData(nb_letters);
        mots.generate();
        motSecret = mots.motSecret;
        System.out.println("Le mot secret commence par la lettre : " + motSecret.charAt(0));
        return motSecret;
    }

    @Override
    public String proposerMot(int taille, String motSecret, int iteration, ArrayList<String> badLetters, HashMap<String,String> goodPlace) {
        //initialisation de la liste
        if (iteration == 0) {
            LoadData mots = new LoadData(taille);
            mots.generate();

            for (String mot : mots.liste) {
                if (mot.charAt(0) == motSecret.charAt(0)) {
                    this.liste.add(mot);
                }
                else if (mot.charAt(0) > motSecret.charAt(0)) {
                    break;
                }
            }
            this.motPropose = this.liste.get(0);

        // Si le mot proposé n'est pas le bon, on enlève les mots qui contiennent des lettres interdites
        } else {
            ArrayList<String> listeTemp = new ArrayList<>(this.liste);
            for (String motTemp : this.liste) {
                for (String badLetter : badLetters) {
                    if (motTemp.contains(badLetter)) {
                        listeTemp.remove(motTemp);
                        break;
                    }
                }
                if (!goodPlace.isEmpty()){
                    for (int i=0; i<taille; i++){
                        String index = String.valueOf(i);
                        if (goodPlace.containsKey(index)){
                            if (String.valueOf(motTemp.charAt(i))!=goodPlace.get(index))
                            listeTemp.remove(motTemp);
                            break;
                        };
                    }
                }
            }
            this.liste = listeTemp;
            this.motPropose = this.liste.get(0);
        }
        
        return this.motPropose;
    }
}  

