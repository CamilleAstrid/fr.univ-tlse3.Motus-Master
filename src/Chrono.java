
// Code inspiré, source : https://fr.jeffprod.com/blog/2015/un-chronometre-en-java/


public class Chrono {
    private long tempsDepart=0;
    private long tempsFin=0;
    private long pauseDepart=0;
    private long pauseFin=0;
    private long duree=0;

    //Methodes sur le temps
    public void start(){
        tempsDepart=System.currentTimeMillis();
        tempsFin=0;
        pauseDepart=0;
        pauseFin=0;
        duree=0;
    }
    public void pause(){
        if(tempsDepart==0) {return;}
        pauseDepart=System.currentTimeMillis();
    }
    public void resume(){
        if(tempsDepart==0) {return;}
        if(pauseDepart==0) {return;}
        pauseFin=System.currentTimeMillis();
        tempsDepart=tempsDepart+pauseFin-pauseDepart;
        tempsFin=0;
        pauseDepart=0;
        pauseFin=0;
        duree=0;
    }
    public void stop(){
        if(tempsDepart==0) {return;}
        tempsFin=System.currentTimeMillis();
        duree=(tempsFin-tempsDepart) - (pauseFin-pauseDepart);
        tempsDepart=0;
        tempsFin=0;
        pauseDepart=0;
        pauseFin=0;
    }        

    //Getters
    public long getDureeSec(){
        return duree/1000;
    }
    public int getDureeMin(){
        long sec = getDureeSec();
        int res = (int) sec/60;
        return res;
    }
    public String getDureeTxt(){
        long tempsS = getDureeSec();
        int m = (int) ((tempsS % 3600) / 60);
        int s = (int) (tempsS % 60);
        String textMin="";

        if(m>0){
            textMin += m+" min ";
        }
        if(s>0){
            textMin += s+" s";
        }
        if(m<=0 && s<=0){
            textMin ="0 s";
        }

        return textMin;
    }
}