package src.sprites;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperPlayer {

    public int x, y;
    public int speed;
    public BufferedImage image;
    public String direction;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
}
