/**
 * @see Main
 */
import java.util.Scanner;

public class Plateau{
    static Case[][] grille;
    static int nb_letters;

    Plateau(int nb_letters){
        grille = new Case [nb_letters][5];
        for (int i=0; i<nb_letters; i++){
            for (int j=0; j<5; j++){
                grille[i][j]= Case.VIDE;
            }
        }
    }

    public static int setNbLetters(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Entrez le nombre de lettres du mot à deviner : ");
        int nb_letters = scan.nextInt();
        return nb_letters;
    }

    public static Plateau creation(int nb_letters){
        Plateau plateau = new Plateau(nb_letters);
        return plateau;
    }

    public static void affichage(int nb_letters, boolean terminal){
        if (terminal){
            System.out.println("--".repeat(nb_letters));
            for (int i=0; i<5; i++){
                System.out.print("| ");
                for (int j=0; j<nb_letters; j++){
                    System.out.print(grille[j][i]+" | ");
                }
                System.out.println();
                System.out.println("--".repeat(nb_letters));
            }
        }
        else{
            //Affichage sur interface graphique
            InterfaceMotus affichage = new InterfaceMotus();
        }
        
    }

    public static void main(String[] args) {
        boolean terminal;

        Scanner scan = new Scanner(System.in);
        System.out.println("Voulez-vous jouer en mode terminal ou en mode graphique ? (T/G)");
        String mode = scan.next();
        if (mode.equals("T"))
            terminal = true;
        else
            terminal = false;
        
        //Choix du mode de jeu : PVP ou PVE
        System.out.println("Voulez-vous jouer en mode solo ou en mode deux joueurs ? (S/M)");
        String mode_jeu = scan.next();

        //Choix du mode de jeu : Proposer ou deviner un mot
        if (mode_jeu.equals("S")){
            System.out.println("Voulez-vous proposer un mot ou deviner un mot ? (P/D)");
            String mode_solo = scan.next();
            if (mode_solo.equals("P")){
                nb_letters = setNbLetters();
                creation(nb_letters);
                Humain player = new Humain();
                player.definirMot(nb_letters);
            }
            else{
                nb_letters = setNbLetters();
                creation(nb_letters);
                Robot IA = new Robot();
                IA.definirMot(nb_letters);
            }
        }
        else{
            Humain player1 = new Humain();
            Humain player2 = new Humain();
            System.out.println("Joueur 1 : renseignez votre mot à faire deviner à Joueur 2.");
            nb_letters = setNbLetters();
            creation(nb_letters);
            player1.definirMot(nb_letters);
        }



        
        affichage(nb_letters, terminal);
        scan.close();
    }
}
