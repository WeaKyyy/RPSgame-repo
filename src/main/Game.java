package src.main;
import javax.swing.JFrame;
import java.awt.*;
import java.lang.Runnable;

public class Game extends JFrame implements Runnable {

    private GameScreen gameScreen;
    private Thread gameThread;
    private boolean running = false;

    public Game() {

        setSize(800, 600); // set the size of the width and the height of frame
        setTitle("Hand Master"); // title of the frame

        setDefaultCloseOperation(EXIT_ON_CLOSE); // when click close button it will terminate the program as well
        setResizable(false); // set resizing the frame to false
        setLocationRelativeTo(null);
        setVisible(true); // show the frame on the screen
        // pack(); // adjust to the components exist here
        setLayout(null);

        gameScreen = new GameScreen();
        add(gameScreen);

    }

    public void start() {

        gameThread = new Thread(this);
        gameThread.start();
        running = true;
    }

    public static void main(String[] args) {

        Game game = new Game(); // creates a frame
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double FPS = 60.0;
        double ns = 1_000_000_000 / FPS;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (true) {
            long currentTime = System.currentTimeMillis();
            delta += (currentTime - lastTime) / ns;
            lastTime = currentTime;

            while (delta >= 1) {
                update();
                delta--;
            }
            if (running) {
                repaint();
                frames++;

                if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    System.out.println("FPS: " + frames);
                    frames = 0;
                }
            }
        }
    }

    public void update() {
    }
}
