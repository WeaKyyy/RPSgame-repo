package main;

import javax.swing.JFrame;

public class Game extends JFrame{


    public static void main(String[] args) {

        JFrame game = new JFrame(); // creates a frame
        game.setTitle("Hand Master");
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setResizable(false);
        GameScreen gameScreen = new GameScreen();
        game.add(gameScreen);
        game.pack();
        game.setLocationRelativeTo(null);
        game.setVisible(true);
        //gameScreen.startGameThread();

    }
}
