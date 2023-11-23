package src.main;
import java.awt.*;
import javax.swing.*;

public class GameScreen extends JPanel {

    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    public GameScreen() {

//        setBounds(100, 100, 600, 150);
//        setBackground(Color.blue);

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.black);
        g2.fillRect(100, 100, tileSize, tileSize);
        g2.dispose();
    }

}
