import java.util.ArrayList;

public interface Joueur {

    public String definirMot(int nb_letters);
    public String proposerMot(int taille, String motSecret, int iteration, ArrayList<String> badLetters);
}