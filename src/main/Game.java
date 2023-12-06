package src.main;

import javax.swing.JFrame;

public class Game extends JFrame{

    public Game() {

        initGame();
    }

    public void initGame() {

        setTitle("Hand Master");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        GameScreen gameScreen = new GameScreen();
        add(gameScreen);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        gameScreen.setupCheckPoint();
        //gameScreen.startGameThread();
    }
    public static void main(String[] args) {

        Game game = new Game();

    }
}
