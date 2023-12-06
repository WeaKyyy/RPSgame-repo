package src.main;
import src.assets.CollisionChecker;
import src.managers.CheckPointManager;
import src.managers.TileManager;
import src.objects.SuperCheckPoint;
import src.sprites.Player;
import src.inputs.KeyboardListener;
import src.inputs.MyMouseListener;

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

    KeyboardListener key = new KeyboardListener(this);
    MyMouseListener mouse = new MyMouseListener();
    private final double FPS = 60.0;
    Thread gameThread;
    public TileManager tileM = new TileManager(this);
    public Player player = new Player(this, key);
    public CheckPointManager checkPointM = new CheckPointManager(this);
    public SuperCheckPoint[] scp = new SuperCheckPoint[7];
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public UserInterface ui = new UserInterface(this);

    public int gameState;
    public final int TITLE = 0;
    public final int LOGIN = 1;
    public final int PLAY = 2;
    public final int RPS = 3;
    public final int PAUSE = 4;
    public final int MENU = 5;

    public GameScreen() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.addMouseListener(mouse);
        this.setFocusable(true);
    }

    public void setupCheckPoint() {

        checkPointM.setCheckPoint();
        gameState = PLAY;
    }

    @Override
    public void addNotify() {

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

        if (gameState == LOGIN) {
            // starts with login
        }
        if (gameState == TITLE) {
            // nothing for now
        }
        if (gameState == MENU) {

        }
        if (gameState == PLAY) {
            player.update();
            Toolkit.getDefaultToolkit().sync();
        }
        if (gameState == RPS) {
            //hand.playRPS();
        }
        if (gameState == PAUSE) {
            // nothing
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (gameState == TITLE) {
            // nothing for now
        }
        else if (gameState == LOGIN) {
            ui.paint(g2);
        }
        else if (gameState == RPS) {
            ui.paint(g2);
        }
        else if (gameState == MENU) {
            ui.paint(g2);
        }
        else {
            tileM.paint(g2);
            for (int i = 0; i < scp.length; i++) {
                if (scp[i] != null) {
                    scp[i].paint(g2, this);
                }
            }
            player.paint(g2);
        }
    }
}
