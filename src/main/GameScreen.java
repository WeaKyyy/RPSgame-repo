package src.main;
import src.assets.CollisionChecker;
import src.managers.CheckPointManager;
import src.managers.TileManager;
import src.objects.CheckPoint;
import src.sprite.Opponent;
import src.sprite.Player;
import src.input.KeyboardListener;
import src.input.MyMouseListener;

import java.awt.*;
import javax.swing.*;

public class GameScreen extends JPanel implements Runnable {

    final int originalTileSize = 32;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    KeyboardListener key = new KeyboardListener();
    MyMouseListener mouse = new MyMouseListener();
    private final double FPS = 60.0;
    Thread gameThread;
    public TileManager tileM = new TileManager(this);
    Player player = new Player(this, key);
    Opponent opponent = new Opponent(this);
    CheckPointManager checkPointM = new CheckPointManager(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);

    public GameScreen() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.addMouseListener(mouse);
        this.setFocusable(true);

    }

    @Override
    public void addNotify () {

        super.addNotify();
        gameThread = new Thread(this);
        gameThread.start();
    }

//    public void startGameThread () {
//
//        gameThread = new Thread(this);
//        gameThread.start();
//    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double ns = 1_000_000_000 / FPS;
        double delta = 0;
        long frames = 0;
        long timer = 0;

        while (gameThread != null) {

            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / ns;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                frames++;
            }
            if (timer >= 1_000_000_000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                timer = 0;
            }
        }
    }

    public void update() {

        player.update();
        opponent.move();

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileM.paint(g2);
        checkPointM.paint(g2);
        player.paint(g2);
        opponent.paint(g2);
        g2.dispose();
    }
}
