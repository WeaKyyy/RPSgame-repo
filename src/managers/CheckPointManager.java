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
    }
}
