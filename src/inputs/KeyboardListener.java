package src.inputs;
import src.main.GameScreen;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyboardListener implements KeyListener {

    GameScreen gs;
    public boolean upPressed, downPressed, leftPressed, rightPressed;//, upArrow, downArrow, leftArrow, rightArrow;

    public KeyboardListener(GameScreen gs) {

        this.gs = gs;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
            upPressed = true;
        }
        if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
            downPressed = true;
        }
        if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
            rightPressed = true;
        }
        if (keyCode == KeyEvent.VK_F10) {
            if (gs.gameState == gs.PLAY) {
                gs.gameState =gs.PAUSE;
            }
            else if (gs.gameState == gs.PAUSE) {
                gs.gameState = gs.PLAY;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
            upPressed = false;
        }
        if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
            downPressed = false;
        }
        if (keyCode == KeyEvent.VK_A|| keyCode == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
            rightPressed = false;
        }
    }
}
