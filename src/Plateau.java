import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Plateau {
    static int iteration = 0;
    static ArrayList<String> badLetters = new ArrayList<>();
    static HashMap<String,String> goodPlace = new HashMap<>();

    public Plateau(){
        // Constructeur de la classe Plateau
        String type = setType();
        int nb_letters = setNbLetters();

        if (type.equals("JcJ")){
            Humain joueur1 = new Humain();
            Humain joueur2 = new Humain();
            jouer(joueur1, joueur2, nb_letters);
        }
        else if (type.equals("JcI")){
            Scanner scanOrdre = new Scanner(System.in);
            String choix = "";
            while (!(choix.equals("O") || choix.equals("N"))){
                System.out.println("Voulez-vous faire deviner votre mot à la machine ? (O ou N): ");
                choix = scanOrdre.nextLine();
            }
            Humain joueur1 = new Humain();
            Robot joueur2 = new Robot();
            if (choix.equals("O")){
                jouer(joueur1, joueur2, nb_letters);
            }
            else if (choix.equals("N")){
                jouer(joueur2, joueur1, nb_letters);
            }
        }
        else{
            Robot joueur1 = new Robot();
            Robot joueur2 = new Robot();
            jouer(joueur1, joueur2, nb_letters);
        }
    }    

    //Setters
    public static int setNbLetters(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le nombre de lettres du mot à deviner : ");
        int nb_letters = scan.nextInt();
        while (nb_letters < 6 || nb_letters > 9){
            System.out.println("Le nombre de lettres doit être compris entre 6 et 9 (compris).");
            System.out.println("Entrez le nombre de lettres du mot à deviner : ");
            nb_letters = scan.nextInt();
        }
        return nb_letters;
    }
    public static String setType(){
        final Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le type de jeu (JcJ, JcI ou IcI) : ");
        String type = scan.nextLine();
        System.out.println("Type de jeu : " + type);
        while ( (!type.equals("JcJ")) && (!type.equals("JcI")) && (!type.equals("IcI")) ){
            System.out.println("Type de jeu invalide. Veuillez entrer JcJ, JcI ou IcI.");
            type = setType();
        }
        return type;
    }

    //Méthodes
    static void jouer(Joueur joueur1, Joueur joueur2, int nb_letters){
        int taille = nb_letters + 1;
        String motSecret = joueur1.definirMot(nb_letters);
        String motPropose = "";
        while (!motPropose.equals(motSecret) && iteration < 6){
            motPropose = joueur2.proposerMot(nb_letters, motSecret, iteration, badLetters, goodPlace);
            verifierMot(motPropose, motSecret, taille);
            iteration++;
        }
        if (!motPropose.equals(motSecret) && iteration == 6){
            System.out.println("Vous avez perdu !");
            System.out.println("Le mot secret était : " + motSecret);
        }
    }
    static void verifierMot(String motPropose, String motSecret, int taille){
        if (motPropose.charAt(0) != motSecret.charAt(0)){
            System.out.println("Le mot ne commence pas par la bonne lettre.");
            resultat("loose", motSecret);
        }
        else if (String.valueOf(motPropose).length() != taille){
            System.out.println("Le mot n'a pas la bonne longueur.");
            resultat("loose", motSecret);
        }
        else if (motPropose.equals(motSecret)){
            resultat("win", motSecret);
        }
        else if (!motPropose.equals(motSecret)){
            for (int i = 0; i < taille; i++){
                if (motPropose.charAt(i) == motSecret.charAt(i)){
                    System.out.println("La lettre " + motPropose.charAt(i) + " est à la bonne place.");
                }
                else if (motSecret.contains(String.valueOf(motPropose.charAt(i)))){
                    System.out.println("La lettre " + motPropose.charAt(i) + " est dans le mot mais pas à la bonne place.");
                }
                else {
                    System.out.println("La lettre " + motPropose.charAt(i) + " n'est pas dans le mot.");
                    badLetters.add(String.valueOf(motPropose.charAt(i)));
                }
            }
            System.out.println("Il vous reste " + (6 - (iteration + 1)) + " essais.");
        }
    }
    static void resultat(String result, String motSecret){
        if (result.equals("win")){
            System.out.println("Bravo, vous avez gagné !");
        }
        else if (result.equals("loose")){
            System.out.println("Dommage, vous avez perdu !");
            System.out.println("Le mot secret était : " + motSecret);
        }
    }  

    //Main
    public static void main(String[] args) {
        Plateau plateau = new Plateau();
    }
}