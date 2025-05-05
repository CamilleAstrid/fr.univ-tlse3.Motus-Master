import java.util.ArrayList;
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

    public String motSecretLisibleCSV(String motSecret){
        motSecretLisibleCSV = motSecret.toLowerCase();
        motSecretLisibleCSV = motSecretLisibleCSV.concat(",");
        return motSecretLisibleCSV;
    }

    @Override
    public String definirMot(int nb_letters) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le mot que vous souhaitez faire deviner: ");
        motSecret = scan.next();

        String File = "fr.univ-tlse3.Motus-Master/data/mots_" + nb_letters + "_lettres.csv";
        Load_data mots = new Load_data(File);
        mots.generate();

        motSecretLisibleCSV = motSecretLisibleCSV(motSecret);

        while (!mots.liste.contains(motSecretLisibleCSV)){
            System.out.println("Le mot n'est pas dans la liste. Il faut choisir un autre mot.");
            System.out.println("Entrez le mot que vous souhaitez faire deviner: ");
            motSecret = scan.next();
            motSecretLisibleCSV = motSecretLisibleCSV(motSecret);
        }
        return motSecretLisibleCSV;
    }

    @Override
    public String proposerMot(int taille, String motSecret, int iteration, ArrayList<String> badLetters) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le mot que vous proposez: ");
        motPropose = scan.next();
        return motPropose;
    }
}
