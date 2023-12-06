package src.sprites;

import src.inputs.KeyboardListener;
import src.main.GameScreen;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends SuperPlayer {

    GameScreen gs;
    KeyboardListener key;

    public Player(GameScreen gs, KeyboardListener key) {

        this.gs = gs;
        this.key = key;
        solidArea = new Rectangle(0, 0, 48, 48);
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        setDefaultValues();
        getPlayerImages();
    }

    public void setDefaultValues() {

        x = 0;
        y = 5 * gs.tileSize;
        speed = 8;
        direction = "right";

    }

    public void getPlayerImages() {

        try {

            up1 = ImageIO.read(getClass().getResourceAsStream("/res/Chara_Back2.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/Chara_Back3.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/res/Chara_Front2.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/Chara_Front3.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/res/Chara_Left2.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/Chara_Left3.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/res/Chara_Right2.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/Chara_Right3.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
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

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                }
                else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
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
                    gs.gameState = gs.RPS;
                    break;

                case "Casual Dog":
                    gs.gameState = gs.RPS;
                    break;

                case "Tryhard Ghost":
                    gs.gameState = gs.RPS;
                    break;

                case "Self-proclaimed Pikachu":
                    gs.gameState = gs.RPS;
                    break;

                case "Master Mr. Jaws":
                    gs.gameState = gs.RPS;
                    break;

                case "Grandmaster Non-breathing fire Dragon":
                    gs.gameState = gs.RPS;
                    break;

                case "The GUY":
                    gs.gameState = gs.RPS;
                    break;
            }
        }
    }

    public void paint(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {

            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;

            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;

            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;

            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }

        g2.drawImage(image, x, y, 4 * gs.tileSize, 4 * gs.tileSize, null);
    }
}
