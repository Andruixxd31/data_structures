import javax.swing.*;
import java.awt.*;

public class Circles extends JPanel {

    private static final long serialVersionUID = 1L;

    // * ----------------- Atributes -----------------
    private int x1, y1;
    private int length;
    private int level;

    // * ----------------- Constructor -----------------
    public Circles() {
        super();
        this.setPreferredSize(new Dimension(720, 700));
        this.setBackground(Color.WHITE);

        // *Starting values
        this.level = 3;
        this.x1 = 50;
        this.y1 = 10;
        this.length = 600;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.paintCircle(g, this.level, this.x1, this.y1, this.length);
    }

    public void paintCircle(Graphics g, int level, int x1, int y1, int length) {
        // X1 will change
        // The dif on the new x1s will be +- the position of the center
        if (this.level == 0) { // Base case
            g.setColor(Color.BLACK);
            g.drawOval(x1, y1, length, length);
            return;
        }
        --this.level;
        paintCircle(g, this.level, x1, y1, length - 50);
    }

}