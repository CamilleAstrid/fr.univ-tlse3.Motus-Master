import javax.swing.*;
import java.awt.*;

public class Initialize extends JFrame{

    public Initialize(){
        Dimension currentScreenSize = getCurrentScreenSize();
        this.setSize(currentScreenSize);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.getContentPane().setBackground(new Color(0x101044));
    }

    public Dimension getCurrentScreenSize(){
        Dimension currentScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        return currentScreenSize;
    }
}
