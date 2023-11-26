package src.managers;

import src.main.GameScreen;
import src.objects.CheckPoint;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class CheckPointManager {

    CheckPoint[] checkPoint;
    BufferedImage image;
    GameScreen gs;

    public CheckPointManager(GameScreen gs) {

        this.gs = gs;
        checkPoint = new CheckPoint[7];

        setCheckPoint();
    }

    public void setCheckPoint() {

        try {
            checkPoint[0] = new CheckPoint();
            checkPoint[0].image = ImageIO.read(getClass().getResourceAsStream("/res/checkpointflag.png"));
            checkPoint[0].checkPoint_X = gs.tileSize;
            checkPoint[0].checkPoint_Y = gs.tileSize;

            checkPoint[1] = new CheckPoint();
            checkPoint[1].image = ImageIO.read(getClass().getResourceAsStream("/res/checkpointflag.png"));
            checkPoint[1].checkPoint_X = 12 * gs.tileSize;
            checkPoint[1].checkPoint_Y = gs.tileSize;

            checkPoint[2] = new CheckPoint();
            checkPoint[2].image = ImageIO.read(getClass().getResourceAsStream("/res/checkpointflag.png"));
            checkPoint[2].checkPoint_X = 4 * gs.tileSize;
            checkPoint[2].checkPoint_Y = 5 * gs.tileSize;

            checkPoint[3] = new CheckPoint();
            checkPoint[3].image = ImageIO.read(getClass().getResourceAsStream("/res/checkpointflag.png"));
            checkPoint[3].checkPoint_X = 5 * gs.tileSize;
            checkPoint[3].checkPoint_Y = 10 * gs.tileSize;

            checkPoint[4] = new CheckPoint();
            checkPoint[4].image = ImageIO.read(getClass().getResourceAsStream("/res/checkpointflag.png"));
            checkPoint[4].checkPoint_X = 11 * gs.tileSize;
            checkPoint[4].checkPoint_Y = 10 * gs.tileSize;

            checkPoint[5] = new CheckPoint();
            checkPoint[5].image = ImageIO.read(getClass().getResourceAsStream("/res/checkpointflag.png"));
            checkPoint[5].checkPoint_X = 12 * gs.tileSize;
            checkPoint[5].checkPoint_Y = 7 * gs.tileSize;

            checkPoint[6] = new CheckPoint();
            checkPoint[6].image = ImageIO.read(getClass().getResourceAsStream("/res/checkpointflag.png"));
            checkPoint[6].checkPoint_X = 7 * gs.tileSize;
            checkPoint[6].checkPoint_Y = 4 * gs.tileSize;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics2D g2) {

        for (int num = 0; num < 7; num++) {
            g2.drawImage(checkPoint[num].image, checkPoint[num].checkPoint_X, checkPoint[num].checkPoint_Y, gs.tileSize, gs.tileSize, null);
        }
    }
}
