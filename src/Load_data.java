import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Load_data {
    String File;
    ArrayList<String> liste;
    int max;
    int nbLigne=0;
    String motSecret;

    Load_data(String File){
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
                liste.add(read);
                nbLigne++;
                read = buf.readLine();
            }
            buf.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        int index = (int)(Math.random() * nbLigne);
        motSecret = liste.get(index);
    }

}
