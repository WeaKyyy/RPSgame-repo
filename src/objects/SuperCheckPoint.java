package src.objects;

import src.main.GameScreen;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperCheckPoint {

    public BufferedImage image;
    public boolean collision = false;
    public int x, y;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public void paint(Graphics2D g2, GameScreen gs) {

        g2.drawImage(image, x, y, gs.tileSize, gs.tileSize, null);
    }
}
