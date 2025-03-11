import java.util.Scanner;

public class Robot implements Joueur{
    @Override
    public String definirMot() {
        int taille_mot;
   
        Scanner taille = new Scanner(System.in);
        System.out.println("Entrez la taille du mot que vous souhaitez deviner: ");
        taille_mot = taille.nextInt();
        taille.close();
        String File = "fr.univ-tlse3.motus_project/data/mots_" + taille_mot + "_lettres";

        Load_data mots = new Load_data(File);
        mots.generate();
        return mots.motSecret;
    }

    @Override
    public String proposerMot(int taille, String motSecret) {
        String File = "fr.univ-tlse3.motus_project/data/mots_" + taille + "_lettres";
        Load_data mots = new Load_data(File);
        mots.generate();

        int index = (int)(Math.random() * mots.nbLigne);
        String motPropose = mots.liste.get(index);

        while (motPropose.charAt(0) != motSecret.charAt(0)){
            if (motPropose.charAt(0) > motSecret.charAt(0)){
                index = (int)index/2;
                motPropose = mots.liste.get(index);
            }
            else {
                index = (int)index + (mots.nbLigne - index)/2;
                motPropose = mots.liste.get(index);
            }
        }
        mots.liste.remove(index);
        return motPropose;
    }
}
