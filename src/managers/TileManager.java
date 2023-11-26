package src.managers;

import src.main.GameScreen;
import src.sprite.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {

    GameScreen gs;
    Tile[] tile;
    int mapTile[][];

    public TileManager(GameScreen gs) {

        this.gs = gs;
        tile = new Tile[2];
        mapTile = new int[gs.maxScreenCol][gs.maxScreenRow];
        getTileImage();
        loadMap();
    }

    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/grass01.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/road00.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {

        try {
            InputStream is = getClass().getResourceAsStream("/res/map(1).txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gs.maxScreenCol && row < gs.maxScreenRow) {
                String line = br.readLine();

                while (col < gs.maxScreenCol) {
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTile[col][row] = num;
                    col++;
                }
                if (col == gs.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
        catch(Exception e) {

        }
    }

    public void paint(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gs.maxScreenCol && row < gs.maxScreenRow) {

            int tileNum = mapTile[col][row];

            g2.drawImage(tile[tileNum].image, x, y, gs.tileSize, gs.tileSize, null);
            col++;
            x += gs.tileSize;

            if (col == gs.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gs.tileSize;
            }
        }

//        g2.drawImage(tile[0].image, 0, 0, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 96, 0, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[1].image, 192, 0, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 288, 0, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 384, 0, gs.tileSize, gs.tileSize, null);
//
//        g2.drawImage(tile[0].image, 0, 96, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 96, 96, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[1].image, 192, 96, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 288, 96, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 384, 96, gs.tileSize, gs.tileSize, null);
//
//        g2.drawImage(tile[0].image, 0, 192, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 96, 192, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[1].image, 192, 192, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 288, 192, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 384, 192, gs.tileSize, gs.tileSize, null);
//
//        g2.drawImage(tile[0].image, 0, 288, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 96, 288, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[1].image, 192, 288, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 288, 288, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 384, 288, gs.tileSize, gs.tileSize, null);
//
//        g2.drawImage(tile[0].image, 0, 384, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 96, 384, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[1].image, 192, 384, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 288, 384, gs.tileSize, gs.tileSize, null);
//        g2.drawImage(tile[0].image, 384, 384, gs.tileSize, gs.tileSize, null);


    }
}
