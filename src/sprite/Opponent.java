package src.sprite;

import src.main.GameScreen;

import java.awt.*;

public class Opponent {

    private int x, y;
    private int speed;
    private final int INITIAL_X = 1576;
    private final int INITIAL_Y = 500;

    GameScreen gs;

    public Opponent(GameScreen gs) {

        this.gs = gs;
        setDefaultValues();
    }

    public void setDefaultValues() {

        x = INITIAL_X;
        y = INITIAL_Y;
        speed = 8;
    }

    public void cycle() {

        x -= speed;

        if (x < 0) {

            setDefaultValues();
        }
    }

    public void paint(Graphics2D g2) {

        g2.setColor(Color.red);
        g2.fillRect(x, y, gs.tileSize, gs.tileSize);
    }
}
