package src.assets;

import src.main.GameScreen;
import src.sprites.SuperPlayer;

public class CollisionChecker {

    GameScreen gs;

    public CollisionChecker(GameScreen gs) {

        this.gs = gs;
    }

    public void checkTileCollision(SuperPlayer superPlayer) {

        int entityLeft_X = superPlayer.x + superPlayer.solidArea.x;
        int entityRight_X = superPlayer.x + superPlayer.solidArea.x + superPlayer.solidArea.width;
        int entityTop_Y = superPlayer.y + superPlayer.solidArea.y;
        int entityBottom_Y = superPlayer.y + superPlayer.solidArea.y + superPlayer.solidArea.height;

        int entityLeftCol = entityLeft_X / gs.tileSize;
        int entityRightCol = entityRight_X / gs.tileSize;
        int entityTopRow = entityTop_Y / gs.tileSize;
        int entityBottomRow = entityBottom_Y / gs.tileSize;

        int tile1, tile2;

        switch (superPlayer.direction) {

            case "up":
                entityTopRow = (entityTop_Y - superPlayer.speed) / gs.tileSize;
                tile1 = gs.tileM.mapTile[entityLeftCol][entityTopRow];
                tile2 = gs.tileM.mapTile[entityRightCol][entityTopRow];

                if (gs.tileM.tile[tile1].collision || gs.tileM.tile[tile2].collision) {
                    superPlayer.collisionOn = true;
                }
                break;

            case "down":
                entityBottomRow = (entityBottom_Y + superPlayer.speed) / gs.tileSize;
                tile1 = gs.tileM.mapTile[entityLeftCol][entityBottomRow];
                tile2 = gs.tileM.mapTile[entityRightCol][entityBottomRow];

                if (gs.tileM.tile[tile1].collision || gs.tileM.tile[tile2].collision) {
                    superPlayer.collisionOn = true;
                }
                break;

            case "left":
                entityLeftCol = (entityLeft_X - superPlayer.speed) / gs.tileSize;
                tile1 = gs.tileM.mapTile[entityLeftCol][entityTopRow];
                tile2 = gs.tileM.mapTile[entityLeftCol][entityBottomRow];

                if (gs.tileM.tile[tile1].collision || gs.tileM.tile[tile2].collision) {
                    superPlayer.collisionOn = true;
                }
                break;

            case "right":
                entityRightCol = (entityRight_X + superPlayer.speed) / gs.tileSize;
                tile1 = gs.tileM.mapTile[entityRightCol][entityTopRow];
                tile2 = gs.tileM.mapTile[entityRightCol][entityBottomRow];

                if (gs.tileM.tile[tile1].collision || gs.tileM.tile[tile2].collision) {
                    superPlayer.collisionOn = true;
                }
                break;
        }
    }

    public int checkObjectCollision(SuperPlayer superPlayer, boolean player) {

        int index = 100;

        for (int i = 0; i < gs.scp.length; i++) {

            if (gs.scp[i] != null) {
                superPlayer.solidArea.x = superPlayer.x + superPlayer.solidArea.x;
                superPlayer.solidArea.y = superPlayer.y + superPlayer.solidArea.y;

                gs.scp[i].solidArea.x = gs.scp[i].x + gs.scp[i].solidArea.x;
                gs.scp[i].solidArea.y = gs.scp[i].y + gs.scp[i].solidArea.y;

                switch (superPlayer.direction) {

                    case "up":
                        superPlayer.solidArea.y -= superPlayer.speed;
                        if (superPlayer.solidArea.intersects(gs.scp[i].solidArea)) {
                            System.out.println("up collision!");
                            if (gs.scp[i].collision) {
                                superPlayer.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;

                    case "down":
                        superPlayer.solidArea.y += superPlayer.speed;
                        superPlayer.solidArea.y -= superPlayer.speed;
                        if (superPlayer.solidArea.intersects(gs.scp[i].solidArea)) {
                            System.out.println("down collision!");
                            if (gs.scp[i].collision) {
                                superPlayer.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;

                    case "left":
                        superPlayer.solidArea.x -= superPlayer.speed;
                        superPlayer.solidArea.y -= superPlayer.speed;
                        if (superPlayer.solidArea.intersects(gs.scp[i].solidArea)) {
                            System.out.println("left collision!");
                            if (gs.scp[i].collision) {
                                superPlayer.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;

                    case "right":
                        superPlayer.solidArea.x += superPlayer.speed;
                        superPlayer.solidArea.y -= superPlayer.speed;
                        if (superPlayer.solidArea.intersects(gs.scp[i].solidArea)) {
                            System.out.println("right collision!");
                            if (gs.scp[i].collision) {
                                superPlayer.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                }

                superPlayer.solidArea.x = superPlayer.solidAreaDefaultX;
                superPlayer.solidArea.y = superPlayer.solidAreaDefaultY;

                gs.scp[i].solidArea.x = gs.scp[i].solidAreaDefaultX;
                gs.scp[i].solidArea.y = gs.scp[i].solidAreaDefaultY;
            }
        }
        return index;
    }
}
