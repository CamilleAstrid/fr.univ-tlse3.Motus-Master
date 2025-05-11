import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Humain implements Joueur {
    String motPropose = "";
    String motSecret = "";
    String motSecretLisibleCSV = "";

    public Humain(){
        this.motPropose = motPropose;
        this.motSecret = motSecret;
        this.motSecretLisibleCSV = motSecretLisibleCSV;
    }

    @Override
    public String definirMot(int nb_letters) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le mot que vous souhaitez faire deviner: ");
        motSecret = scan.next();

        LoadData mots = new LoadData(nb_letters);
        mots.generate();

        motSecretLisibleCSV = mots.motSecretLisibleCSV(motSecret);

        while (!mots.liste.contains(motSecretLisibleCSV)){
            System.out.println("Ce mot n'est pas référencé. Il faut choisir un autre mot.\nEntrez le mot que vous souhaitez faire deviner: ");
            motSecret = scan.next();
            motSecretLisibleCSV = mots.motSecretLisibleCSV(motSecret);
        }
        System.out.println("Le mot secret commence par la lettre : " + motSecret.charAt(0));
        return motSecretLisibleCSV;
    }

    @Override
    public String proposerMot(int taille, String motSecret, int iteration, ArrayList<String> badLetters, HashMap<String,String> goodPlace) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le mot que vous proposez: ");
        motPropose = scan.next();
        LoadData mots = new LoadData(taille);
        motPropose = mots.motSecretLisibleCSV(motPropose);
        return motPropose;
    }
}
