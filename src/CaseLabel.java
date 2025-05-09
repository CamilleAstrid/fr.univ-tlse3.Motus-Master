import javax.swing.*;
import java.awt.*;

public class CaseLabel extends JLabel {
    private String etat = "none"; // peut valoir "good", "nearly", "nope"

    public CaseLabel(String text) {
        super(text, SwingConstants.CENTER);
        setOpaque(true);
        setBackground(Color.WHITE);
        setFont(new Font("Arial", Font.PLAIN, 20));
        setBorder(BorderFactory.createLineBorder(Color.CYAN, 2));
    }

    public void setEtat(String etat) {
        this.etat = etat;
        repaint(); // redessine le composant après changement d'état
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (!etat.equals("none")) {
            Graphics2D g2 = (Graphics2D) g.create();
            if (etat.equals("good")) {
                g2.setColor(new Color(255, 0, 0, 128)); // rouge semi-transparent
                g2.fillRect(0, 0, getWidth(), getHeight());
            } else if (etat.equals("nearly")) {
                g2.setColor(new Color(255, 255, 0, 128)); // jaune semi-transparent
                int diameter = Math.min(getWidth(), getHeight()) / 2;
                int x = (getWidth() - diameter) / 2;
                int y = (getHeight() - diameter) / 2;
                g2.fillOval(x, y, diameter, diameter);
            }
        }
    }
}