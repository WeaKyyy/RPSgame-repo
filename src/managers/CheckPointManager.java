package src.managers;

import src.main.GameScreen;
import src.objects.*;


public class CheckPointManager {

    GameScreen gs;
    boolean collision = false;

    public CheckPointManager(GameScreen gs) {

        this.gs = gs;
        collision = true;
    }

    public void setCheckPoint() {

        gs.scp[0] = new PenguinCheckpoint();
        gs.scp[0].x = gs.tileSize;
        gs.scp[0].y = gs.tileSize;

        gs.scp[1] = new DogCheckPoint();
        gs.scp[1].x = 4 * gs.tileSize;
        gs.scp[1].y = 5 * gs.tileSize;

        gs.scp[2] = new GhostCheckPoint();
        gs.scp[2].x = 5 * gs.tileSize;
        gs.scp[2].y = 10 * gs.tileSize;

        gs.scp[3] = new PikachuCheckPoint();
        gs.scp[3].x = 11 * gs.tileSize;
        gs.scp[3].y = 10 * gs.tileSize;

        gs.scp[4] = new SharkCheckPoint();
        gs.scp[4].x = 12 * gs.tileSize;
        gs.scp[4].y = 7 * gs.tileSize;

        gs.scp[5] = new DragonCheckPoint();
        gs.scp[5].x = 7 * gs.tileSize;
        gs.scp[5].y = 4 * gs.tileSize;

        gs.scp[6] = new ThisGuyCheckPoint();
        gs.scp[6].x = 12 * gs.tileSize;
        gs.scp[6].y = gs.tileSize;

//        checkPoint[1] = new CheckPoint();
//        checkPoint[1].image = ImageIO.read(getClass().getResourceAsStream("/res/checkpointflag.png"));
//        checkPoint[1].checkPoint_X = 12 * gs.tileSize;
//        checkPoint[1].checkPoint_Y = gs.tileSize;
//
//            checkPoint[2] = new CheckPoint();
//            checkPoint[2].image = ImageIO.read(getClass().getResourceAsStream("/res/checkpointflag.png"));
//            checkPoint[2].checkPoint_X = 4 * gs.tileSize;
//            checkPoint[2].checkPoint_Y = 5 * gs.tileSize;
//
//            checkPoint[3] = new CheckPoint();
//            checkPoint[3].image = ImageIO.read(getClass().getResourceAsStream("/res/checkpointflag.png"));
//            checkPoint[3].checkPoint_X = 5 * gs.tileSize;
//            checkPoint[3].checkPoint_Y = 10 * gs.tileSize;
//
//            checkPoint[4] = new CheckPoint();
//            checkPoint[4].image = ImageIO.read(getClass().getResourceAsStream("/res/checkpointflag.png"));
//            checkPoint[4].checkPoint_X = 11 * gs.tileSize;
//            checkPoint[4].checkPoint_Y = 10 * gs.tileSize;
//
//            checkPoint[5] = new CheckPoint();
//            checkPoint[5].image = ImageIO.read(getClass().getResourceAsStream("/res/checkpointflag.png"));
//            checkPoint[5].checkPoint_X = 12 * gs.tileSize;
//            checkPoint[5].checkPoint_Y = 7 * gs.tileSize;
//
//            checkPoint[6] = new CheckPoint();
//            checkPoint[6].image = ImageIO.read(getClass().getResourceAsStream("/res/checkpointflag.png"));
//            checkPoint[6].checkPoint_X = 7 * gs.tileSize;
//            checkPoint[6].checkPoint_Y = 4 * gs.tileSize;
//    }
//
//    public void paint(Graphics2D g2) {
//
//        for (int num = 0; num < 7; num++) {
//            g2.drawImage(checkPoint[num].image, checkPoint[num].checkPoint_X, checkPoint[num].checkPoint_Y, gs.tileSize, gs.tileSize, null);
//        }
    }
}
