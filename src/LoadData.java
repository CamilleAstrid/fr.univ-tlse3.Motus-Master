import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LoadData {
    String File;
    ArrayList<String> liste;
    int max;
    int nbLigne=0;
    String motSecret="motus";

    LoadData(String File){
        this.File = File;
        this.liste = new ArrayList<String>();
        this.max = nbLigne;
        this.motSecret = motSecret;
    }

    public void generate(){
        try{
            BufferedReader buf = new BufferedReader(new FileReader(File));
            String read = buf.readLine();
            while(read != null){
                this.liste.add(read);
                nbLigne++;
                read = buf.readLine();
            }
            buf.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        this.max = nbLigne;
        int index = (int)(Math.random() * nbLigne);
        this.motSecret = liste.get(index);
    }

    static public String Rules(){
        String File = "fr.univ-tlse3.Motus-Master/data/Rules.txt";
        StringBuilder rules = new StringBuilder();

        try{
            BufferedReader buf = new BufferedReader(new FileReader(File));
            String read = buf.readLine();
            while(read != null){
                rules.append(read);
                read = buf.readLine();
            }
            buf.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return rules.toString();
    }

}