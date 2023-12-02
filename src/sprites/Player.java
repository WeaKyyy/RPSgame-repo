package src.sprites;

import src.inputs.KeyboardListener;
import src.main.GameScreen;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

//    public int x, y;
//    public int speed;
//    public String direction;
//    public Rectangle solidArea;
//    public boolean collisionOn = false;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
    GameScreen gs;
    KeyboardListener key;

    public Player(GameScreen gs, KeyboardListener key) {

        this.gs = gs;
        this.key = key;
        solidArea = new Rectangle(10, 20, 30, 30);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        setDefaultValues();
    }

    public void setDefaultValues() {

        x = 0;
        y = 5 * gs.tileSize;
        speed = 8;

    }

    public void update() {

        if (key.upPressed || key.downPressed || key.leftPressed || key.rightPressed) {

            if (key.upPressed) {
                direction = "up";
            } else if (key.downPressed) {
                direction = "down";
            } else if (key.leftPressed) {
                direction = "left";
            } else if (key.rightPressed) {
                direction = "right";
            }

            collisionOn = false;
            gs.collisionChecker.checkTileCollision(this); // CHECK TILE COLLISION
            int objectIndex = gs.collisionChecker.checkObjectCollision(this, true); // CHECK OBJECT COLLISION
            objectInteraction(objectIndex);

            if (!collisionOn) {

                switch (direction) {

                    case "up":
                        y -= speed;
                        break;

                    case "down":
                        y += speed;
                        break;

                    case "left":
                        x -= speed;
                        break;

                    case "right":
                        x += speed;
                        break;
                }
            }
        }
    }

    public void objectInteraction(int index) {

        if (index != 100) {
            String object = gs.scp[index].title;

            switch (object) {

                case "Novice Penguin":
                    gs.RPSInitiator();
                    break;

                case "Casual Dog":
                    break;

                case "Tryhard Ghost":
                    break;

                case "Self-proclaimed Pikachu":
                    break;

                case "Master Mr. Jaws":
                    break;

                case "Grandmaster Non-breathing fire Dragon":
                    break;

                case "The GUY":
                    break;
            }
        }
    }

    public void paint(Graphics2D g2) {

        g2.setColor(Color.white);
        g2.fillRect(x, y, gs.tileSize, gs.tileSize);
    }
}
