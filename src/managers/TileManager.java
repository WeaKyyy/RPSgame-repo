package src.managers;

import src.main.GameScreen;
import src.objects.Tile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;

public class TileManager {

    GameScreen gs;
    public Tile[] tile;
    public int mapTile[][];

    public TileManager(GameScreen gs) {

        this.gs = gs;
        tile = new Tile[15];
        mapTile = new int[gs.maxScreenCol][gs.maxScreenRow];
        getTileImage();
        loadMap();
    }

    public void getTileImage() {

        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/grass01.png"));
            tile[0].collision = true;

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/road00.png"));

            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/road01.png"));
            tile[2].collision = true;

            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/road02.png"));
            tile[3].collision = true;

            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getResourceAsStream("/res/road03.png"));
            tile[4].collision = true;

            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getResourceAsStream("/res/road04.png"));
            tile[5].collision = true;

            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getResourceAsStream("/res/road05.png"));
            tile[6].collision = true;

            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getResourceAsStream("/res/road06.png"));
            tile[7].collision = true;

            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getResourceAsStream("/res/road07.png"));
            tile[8].collision = true;

            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getResourceAsStream("/res/road08.png"));
            tile[9].collision = true;

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getResourceAsStream("/res/road09.png"));
            tile[10].collision = true;

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getResourceAsStream("/res/road10.png"));
            tile[11].collision = true;

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getResourceAsStream("/res/road11.png"));
            tile[12].collision = true;

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getResourceAsStream("/res/road12.png"));
            tile[13].collision = true;

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(getClass().getResourceAsStream("/res/tree.png"));
            tile[14].collision = true;
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
    }
}
