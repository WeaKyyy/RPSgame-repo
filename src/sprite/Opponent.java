package src.sprite;

import src.main.GameScreen;

import java.awt.*;

public class Opponent extends Entity {

    private int x, y;
    private int speed;
    private final int INITIAL_X;
    private final int INITIAL_Y;
    private int lastDir;

    GameScreen gs;

    public Opponent(GameScreen gs) {

        this.gs = gs;
        INITIAL_X = 16 * gs.tileSize;
        INITIAL_Y = 4 * gs.tileSize;
        solidArea = new Rectangle(0, 0, 48, 48);
        setDefaultValues();
        //lastDir = RIGHT;
    }

    public void setDefaultValues() {

        x = INITIAL_X;
        y = INITIAL_Y;
        speed = 8;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

//    public int getSpeed_X() {
//        return speed_X;
//    }
//
//    public int getSpeed_Y() {
//        return speed_Y;
//    }

    public void move() {

        x -= speed;

        if (x < 0) {

            setDefaultValues();
        }
        //if (isNextTileRoad) {
            // move opponent

        //}
    }

//    public boolean isNextileRoad() {
//
//        int newX = getX() + getSpeed_X();
//        return true;
//    }

    public void paint(Graphics2D g2) {

        g2.setColor(Color.red);
        g2.fillRect(x, y, gs.tileSize, gs.tileSize);
    }
}
