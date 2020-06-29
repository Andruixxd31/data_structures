import javax.swing.JFrame;
import java.awt.*;

public class Window extends JFrame {

    public Window() {
        super("Circles");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Circles circles = new Circles();
        this.add(circles);
        this.setVisible(true);
        this.setResizable(false);
        this.pack();
    }

    public static void main(String[] args) {
        Window window = new Window();
    }
}