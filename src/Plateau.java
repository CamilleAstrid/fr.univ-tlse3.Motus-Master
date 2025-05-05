import java.util.Scanner;

public class Plateau {
    static int iteration = 0;

    public Plateau(){
        // Constructeur de la classe Plateau
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
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le type de jeu (JcJ, JcI ou IcI) : ");
        String type = scan.nextLine();
        while (!(type != "JcJ" || type != "JcI" || type != "IcI")){
            System.out.println("Type de jeu invalide. Veuillez entrer JcJ, JcI ou IcI.");
            type = setType();
        }
        return type;
    }

    //Méthodes
    static void jouer(Joueur joueur1, Joueur joueur2, int nb_letters){
        String motSecret = joueur1.definirMot(nb_letters);
        String motPropose = "";
        while (!motPropose.equals(motSecret) || iteration < 6){
            motPropose = joueur2.proposerMot(nb_letters, motSecret, 0, null);
            verifierMot(motPropose, motSecret, nb_letters);
            iteration++;
        }
        if (motPropose.equals(motSecret)){
            System.out.println("Bravo, vous avez gagné !");
        }
        else if (iteration == 6){
            System.out.println("Vous avez perdu !");
            System.out.println("Le mot secret était : " + motSecret);
        }
    }

    static void verifierMot(String motPropose, String motSecret, int taille){
        if (motPropose.charAt(0) != motSecret.charAt(0)){
            System.out.println("Le mot ne commence pas par la bonne lettre.");
            resultat("loose");
        }
        else if (motPropose.length() != taille){
            System.out.println("Le mot n'a pas la bonne longueur.");
            resultat("loose");
        }
        else if (motPropose.equals(motSecret)){
            resultat("win");
        }
        else if (!motPropose.equals(motSecret)){
            for (int i = 0; i < taille; i++){
                if (motPropose.charAt(i) == motSecret.charAt(i)){
                    System.out.println("La lettre " + motPropose.charAt(i) + " est à la bonne place.");
                    //Ajouter interface graphique pour afficher la lettre en carré rouge
                }
                else if (motSecret.contains(String.valueOf(motPropose.charAt(i)))){
                    System.out.println("La lettre " + motPropose.charAt(i) + " est dans le mot mais pas à la bonne place.");
                    //Ajouter interface graphique pour afficher la lettre en rond jaune
                }
                else {
                    System.out.println("La lettre " + motPropose.charAt(i) + " n'est pas dans le mot.");
                }
            }
            System.out.println("Il vous reste " + (6 - iteration) + " essais.");
        }
    }

    static void resultat(String result){
        if (result == "win"){
            System.out.println("Bravo, vous avez gagné !");
        }
        else if (result == "loose"){
            System.out.println("Dommage, vous avez perdu !");
        }
    }

    //Main
    public static void main(String[] args) {
        String type = setType();
        String typeString = String.valueOf(type);
        int nb_letters;

        if (typeString == "JcJ"){
            nb_letters = setNbLetters();
            Humain joueur1 = new Humain();
            Humain joueur2 = new Humain();
            jouer(joueur1, joueur2, nb_letters);
        }
        else if (typeString == "JcI"){
            Scanner scanOrdre = new Scanner(System.in);
            String choix = "";
            while (!(choix != "O" || choix != "N")){
                System.out.println("Voulez-vous faire deviner votre mot à la machine ? (O ou N): ");
                choix = scanOrdre.nextLine();
            }
            nb_letters = setNbLetters();
            Humain joueur1 = new Humain();
            Robot joueur2 = new Robot();
            if (choix == "O"){
                jouer(joueur1, joueur2, nb_letters);
            }
            else if (choix == "N"){
                jouer(joueur2, joueur1, nb_letters);
            }
        }
        else{
            nb_letters = setNbLetters();
            Robot joueur1 = new Robot();
            Robot joueur2 = new Robot();
            jouer(joueur1, joueur2, nb_letters);
        }
    }

}
