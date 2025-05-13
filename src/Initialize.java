import javax.swing.*;
import java.awt.*;

public class Initialize extends JFrame{
    static Color motusColor = new Color(0x101044);

    public Initialize(){
        Dimension currentScreenSize = getCurrentScreenSize();
        this.setSize(currentScreenSize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.getContentPane().setBackground(motusColor);
    }

    public Dimension getCurrentScreenSize(){
        Dimension currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return currentScreenSize;
    }
}
