package src.objects;

import src.main.GameScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OptionalDataException;

public class CheckPoint {

    public BufferedImage image;
    public int checkPoint_X, checkPoint_Y;
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public int solidAreaDefaultX, solidAreaDefaultY;

    public CheckPoint() {

        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }
}
