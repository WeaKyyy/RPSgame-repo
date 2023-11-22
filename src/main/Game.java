package src.main;
import javax.swing.JFrame;
import java.lang.Runnable;

public class Game extends JFrame {

    public Game() {

        setSize(640, 640);
        setTitle("RPS Mayhem");

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {

        Game game = new Game();
    }
}
