package main;
import Entity.Player;
import input.KeyboardListener;

import java.awt.*;
import javax.swing.*;

public class GameScreen extends JPanel implements Runnable {

    final int originalTileSize = 32;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    KeyboardListener key = new KeyboardListener();
    Thread gameThread;
    Player player = new Player(this, key);
    public GameScreen() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);

    }


    public void startGameThread () {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double fps = 60.0;
        double ns = 1_000_000_000 / fps;
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
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        player.paint(g2);
        g2.dispose();
    }
}
