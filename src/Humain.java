import java.util.Scanner;


public class Humain implements Joueur{
    String motPropose;
    String motSecret;
    String motSecretLisibleCSV;

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
        }
        scan.close();
        return motSecret;
    }

    @Override
    public String proposerMot(int taille, String motSecret) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le mot que vous proposez: ");
        motPropose = scan.next();

        if (motPropose.charAt(0) != motSecret.charAt(0)){
            System.out.println("Le mot ne commence pas par la bonne lettre.");
            Results.main("loose");
        }
        else if (motPropose.length() != taille){
            System.out.println("Le mot n'a pas la bonne longueur.");
            Results.main("loose");
        }
        else {
            Plateau.affichage(taille, false);
        }

        scan.close();
        return motPropose;
    }
}
