/**
 * @see Main
 */
import java.util.Scanner;

public class Plateau{
    Case[][] grille;
    int nb_letters;

    Plateau(int nb_letters){
        grille = new Case [nb_letters][5];
        for (int i=0; i<nb_letters; i++){
            for (int j=0; j<5; j++){
                grille[i][j]= Case.VIDE;
            }
        }

    }

    public static void affichage(int nb_letters){
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
}


public class Plateau {

    void afficherGrille(){
        System.out.println("-------------");
        for (int i=0; i<3; i++){
            System.out.print("| ");
            for (int j=0; j<3; j++){
                System.out.print(grille[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    boolean jouerCoup(int idLigne, int idColonne, int idJoueur){
        if (idLigne>=0 && idLigne<3
        && idColonne>=0 && idColonne<3
        && grille[idLigne][idColonne]==Case.VIDE){
            grille[idLigne][idColonne]=Case.values()[idJoueur];
            return true;
        }
        return false;
    }

    boolean estPleine(){
        for (int i=0; i<3; i++)
            for (int j=0; j<3; j++)
                if (grille[i][j]==Case.VIDE)
                    return false;
        return true;
    }

    Case estGagnant(){
        // Test des lignes
        for (int i=0; i<3; i++){
            if (grille[i][0]!=Case.VIDE
            && grille[i][0]==grille[i][1]
            && grille[i][0]==grille[i][2])
                return grille[i][0];
        }

        // Test des colonnes
        for (int j=0; j<3; j++){
            if (grille[0][j]!=Case.VIDE
            && grille[0][j]==grille[1][j]
            && grille[0][j]==grille[2][j])
                return grille[0][j];
        }

        // Test des diagonales
        if (grille[0][0]!=Case.VIDE
        && grille[0][0]==grille[1][1]
        && grille[0][0]==grille[2][2])
            return grille[0][0];
        
        if (grille[2][0]!=Case.VIDE
        && grille[2][0]==grille[1][1]
        && grille[2][0]==grille[0][2])
            return grille[2][0];
        
        return Case.VIDE;
    }

    public static void main(String[] args){
        Plateau plateauJeu = new Plateau();
        Scanner scan = new Scanner(System.in);
        int joueurActuel = 1;
    
        while(!plateauJeu.estPleine() && plateauJeu.estGagnant()==Case.VIDE){
            boolean aJoue = false;
            
            // Indique le joueurActuel
            System.out.println("A vous de jouer joueur "+ joueurActuel);
            System.out.println("Rappel : les cases sont numérotées de 0 à 2\n");

            while (!aJoue){
                // Choix de la ligne où jouer
                System.out.print("Sur quelle ligne voulez-vous jouer ? ");
                int idLigne = scan.nextInt();
                scan.nextLine();

                // Choix de la colonne où jouer
                System.out.print("Sur quelle colonne voulez-vous jouer ? ");
                int idColonne = scan.nextInt();
                scan.nextLine();
                
                // Vérifie que le coup est dans les bornes et sur une case non prise
                aJoue = plateauJeu.jouerCoup(idLigne, idColonne, joueurActuel);
                if (!aJoue)
                    System.out.println("Vous ne pouvez pas jouer ici, choisissez une autre case...");
            }

            // Affichage de la grille
            plateauJeu.afficherGrille();

            // Changement de joueur
            joueurActuel = (joueurActuel%2)+1;
        }
        scan.close();
        
        if (plateauJeu.estGagnant()==Case.VIDE)
            System.out.println("PARTIE NULLE !");
        else{
            System.out.println("Le joueur "+plateauJeu.estGagnant()+" a gagné !");
        }
    }

}