package src.assets;

import src.main.GameScreen;
import src.sprites.Entity;

public class CollisionChecker {

    GameScreen gs;

    public CollisionChecker(GameScreen gs) {

        this.gs = gs;
    }

    public void checkTileCollision(Entity entity) {

        int entityLeft_X = entity.x + entity.solidArea.x;
        int entityRight_X = entity.x + entity.solidArea.x + entity.solidArea.width;
        int entityTop_Y = entity.y + entity.solidArea.y;
        int entityBottom_Y = entity.y + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = entityLeft_X / gs.tileSize;
        int entityRightCol = entityRight_X / gs.tileSize;
        int entityTopRow = entityTop_Y / gs.tileSize;
        int entityBottomRow = entityBottom_Y / gs.tileSize;

        int tile1, tile2;

        switch (entity.direction) {

            case "up":
                entityTopRow = (entityTop_Y - entity.speed) / gs.tileSize;
                tile1 = gs.tileM.mapTile[entityLeftCol][entityTopRow];
                tile2 = gs.tileM.mapTile[entityRightCol][entityTopRow];

                if (gs.tileM.tile[tile1].collision || gs.tileM.tile[tile2].collision) {
                    entity.collisionOn = true;
                }
                break;

            case "down":
                entityBottomRow = (entityBottom_Y + entity.speed) / gs.tileSize;
                tile1 = gs.tileM.mapTile[entityLeftCol][entityBottomRow];
                tile2 = gs.tileM.mapTile[entityRightCol][entityBottomRow];

                if (gs.tileM.tile[tile1].collision || gs.tileM.tile[tile2].collision) {
                    entity.collisionOn = true;
                }
                break;

            case "left":
                entityLeftCol = (entityLeft_X - entity.speed) / gs.tileSize;
                tile1 = gs.tileM.mapTile[entityLeftCol][entityTopRow];
                tile2 = gs.tileM.mapTile[entityLeftCol][entityBottomRow];

                if (gs.tileM.tile[tile1].collision || gs.tileM.tile[tile2].collision) {
                    entity.collisionOn = true;
                }
                break;

            case "right":
                entityRightCol = (entityRight_X + entity.speed) / gs.tileSize;
                tile1 = gs.tileM.mapTile[entityRightCol][entityTopRow];
                tile2 = gs.tileM.mapTile[entityRightCol][entityBottomRow];

                if (gs.tileM.tile[tile1].collision || gs.tileM.tile[tile2].collision) {
                    entity.collisionOn = true;
                }
                break;
        }
    }

    public int checkObjectCollision(Entity entity, boolean player) {

        int index = 100;

        for (int i = 0; i < gs.scp.length; i++) {

            if (gs.scp[i] != null) {
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;

                gs.scp[i].solidArea.x = gs.scp[i].x + gs.scp[i].solidArea.x;
                gs.scp[i].solidArea.y = gs.scp[i].y + gs.scp[i].solidArea.y;

                switch (entity.direction) {

                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gs.scp[i].solidArea)) {
                            System.out.println("up collision!");
                            if (gs.scp[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;

                    case "down":
                        entity.solidArea.y += entity.speed;
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gs.scp[i].solidArea)) {
                            System.out.println("down collision!");
                            if (gs.scp[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;

                    case "left":
                        entity.solidArea.x -= entity.speed;
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gs.scp[i].solidArea)) {
                            System.out.println("left collision!");
                            if (gs.scp[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;

                    case "right":
                        entity.solidArea.x += entity.speed;
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gs.scp[i].solidArea)) {
                            System.out.println("right collision!");
                            if (gs.scp[i].collision) {
                                entity.collisionOn = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                }

                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;

                gs.scp[i].solidArea.x = gs.scp[i].solidAreaDefaultX;
                gs.scp[i].solidArea.y = gs.scp[i].solidAreaDefaultY;
            }
        }
        return index;
    }
}
