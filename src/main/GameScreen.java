package src.main;
import src.assets.CollisionChecker;
import src.managers.CheckPointManager;
import src.managers.TileManager;
import src.objects.SuperCheckPoint;
import src.sprites.Opponent;
import src.sprites.Player;
import src.inputs.KeyboardListener;
import src.inputs.MyMouseListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameScreen extends JPanel implements Runnable {

    final int originalTileSize = 32;
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    KeyboardListener key = new KeyboardListener();
    MyMouseListener mouse = new MyMouseListener();
    private final double FPS = 60.0;
    Thread gameThread;
    public TileManager tileM = new TileManager(this);
    public Player player = new Player(this, key);
    Opponent opponent = new Opponent(this);
    public CheckPointManager checkPointM = new CheckPointManager(this);
    public SuperCheckPoint[] scp = new SuperCheckPoint[7];
    public CollisionChecker collisionChecker = new CollisionChecker(this);
    public UserInterface ui = new UserInterface(this);

    public int gameState;
    public final int PLAY = 1;
    public final int PAUSE = 2;

    public GameScreen() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.addMouseListener(mouse);
        this.setFocusable(true);

    }

    public void setupCheckPoint() {

        checkPointM.setCheckPoint();
    }

    @Override
    public void addNotify () {

        super.addNotify();
        gameThread = new Thread(this);
        gameThread.start();
    }

//    public void startGameThread () {
//
//        gameThread = new Thread(this);
//        gameThread.start();
//    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        double ns = 1_000_000_000 / FPS;
        double delta = 0;
        long frames = 0;
        long timer = 0;

        while (gameThread != null) {

            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / ns;
            timer += (currentTime - lastTime);
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                frames++;
            }
            if (timer >= 1_000_000_000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                timer = 0;
            }
        }
    }

    public void update() {

        player.update();
        opponent.move();

        Toolkit.getDefaultToolkit().sync();
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        tileM.paint(g2);
        for (int i = 0; i < scp.length; i++) {
            if (scp[i] != null) {
                scp[i].paint(g2, this);
            }
        }
        player.paint(g2);
        opponent.paint(g2);
        ui.paint(g2);
        g2.dispose();
    }

    public void RPSInitiator() {

        JPanel RPSScreen = new JPanel();
        RPSScreen.setPreferredSize(new Dimension(768, 576));
        RPSScreen.setBackground(Color.black);

        String[] iconPath = new String[3];
        int[] iconBound = new int[3];

        for (int i = 0; i <= 2; i++) {
            iconPath[i] = System.getProperty("/res/hands/" + i + "rps.png");
            iconBound[i] = 20 + 125 * i;
        }

        JButton paperButton = new JButton(" ", new ImageIcon(iconPath[0]));
        paperButton.setBackground(Color.yellow);
        paperButton.setBounds(iconBound[0], 50, 100, 125);

        JButton scissorsButton = new JButton(" ", new ImageIcon(iconPath[1]));
        scissorsButton.setBackground(Color.blue);
        scissorsButton.setBounds(iconBound[1], 50, 100, 125);

        JButton rockButton = new JButton(" ", new ImageIcon(iconPath[2]));
        rockButton.setBackground(Color.red);
        rockButton.setBounds(iconBound[2], 50, 100, 125);

        RPSScreen.add(paperButton);
        RPSScreen.add(scissorsButton);
        RPSScreen.add(rockButton);

        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computeWinner(1);
            }
        });

        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computeWinner(2);
            }
        });

        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                computeWinner(3);
            }
        });
        return;
    }

    public void computeWinner(int player) {

        int playerScore = 0;
        int total = 0;
        int win = 0;
        int tie = 0;
        int computer = (int) (Math.random() * 3) + 1;
        String labelChoice, labelWinner ="";
        String comboWinner = "" + Math.min(computer, player) + Math.max(computer, player);
        switch (Integer.parseInt(comboWinner)) {

            case 12:
                labelChoice = "Scissors wins!";
                if (player == 2) {
                    playerScore = 1;
                }
                break;

            case 13:
                labelChoice = "Paper wins!";
                if (player == 1) {
                    playerScore = 1;
                }
                break;

            case 23:
                labelChoice = "Rock wins!";
                if (player == 3) {
                    playerScore = 1;
                }
                break;

            default:
                labelChoice = "Draw!";
                playerScore = 2;
                tie += 1;
                //entity.tie += 1;
        }

        if (playerScore == 1) {
            labelWinner = "Player wins!";
            playerScore = 0;
            win += 1;
            total += 1;
            //entity.win += 1;
            //entity.total += 1;
        }
        else if (playerScore == 2) {
            labelWinner = "Tie round!";
            playerScore = 0;
        }
        else {
            labelWinner = "Computer wins!";
            total += 1;
            //entity.total += 1;
        }

        if (total == 3) {
            return;
        }
    }
}
