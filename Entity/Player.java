package Entity;

import input.KeyboardListener;
import main.GameScreen;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {

    private int x, y;
    private int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    GameScreen gs;
    KeyboardListener key;

    public Player(GameScreen gs, KeyboardListener key) {

        this.gs = gs;
        this.key = key;
        setDefaultValues();
    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
        speed = 4;

    }

    public void update() {

        if (key.upPressed) {
            y -= speed;
        }
        else if (key.downPressed) {
            y += speed;
        }
        else if (key.leftPressed) {
            x -= speed;
        }
        else if (key.rightPressed) {
            x += speed;
        }
    }

    public void paint(Graphics2D g2) {

        g2.setColor(Color.white);
        g2.fillRect(x, y, gs.tileSize, gs.tileSize);
    }
}
