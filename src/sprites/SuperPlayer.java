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
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    public int spriteCounter = 0;
    public int spriteNum = 1;
}
