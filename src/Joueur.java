import java.util.ArrayList;
import java.util.HashMap;

public interface Joueur {

    public String definirMot(int nb_letters);
    public String proposerMot(int taille, String motSecret, int iteration, ArrayList<String> badLetters, HashMap<String,String> goodPlace, HashMap<String,String> niceTry);
}