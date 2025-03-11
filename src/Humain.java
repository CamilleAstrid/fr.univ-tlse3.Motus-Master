import java.util.Scanner;


public class Humain implements Joueur{
    String motPropose;
    String motSecret;

    @Override
    public String definirMot() {
        int taille_mot;
   
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez la taille du mot que vous souhaitez faire deviner: ");
        taille_mot = scan.nextInt();
        System.out.println("Entrez le mot que vous souhaitez faire deviner: ");
        motSecret = scan.next();

        String File = "fr.univ-tlse3.motus_project/data/mots_" + taille_mot + "_lettres";
        Load_data mots = new Load_data(File);
        mots.generate();

        while (!mots.liste.contains(motSecret)){
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
            Plateau.affichage();
        }

        scan.close();
        return motPropose;
    }
}
