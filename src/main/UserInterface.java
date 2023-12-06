package src.main;

import src.objects.PenguinCheckpoint;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserInterface {

    Game game;
    GameScreen gs;
    JPanel mainScreenPanel;
    Font consolas_50;
    BufferedImage penguinImage, dogImage, ghostImage, pikachuImage, sharkImage, dragonImage, thisGuyImage;
    public boolean messageOn = false;
    public String message = "";
    Graphics2D g2;
    JButton btn_rock, btn_paper, btn_scissors;
    JButton playButton, exitButton;
    JLabel usernameLabel, passwordLabel;
    BufferedImage imagePaper, imageScissors, imageRock;
    BufferedImage imageTitleScreen;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private Map<String, String> userDatabase;
    JButton loginButton, createAccountButton;
    public static int playerScore = 0;
    public static int winScore = 0;
    public static int totalScore = 0;
    public static int tieScore = 0;




    public UserInterface(GameScreen gs) {

        this.gs = gs;
        consolas_50 = new Font("consolas", Font.PLAIN, 50);

        PenguinCheckpoint penguin = new PenguinCheckpoint();
        penguinImage = penguin.image;

        try {
            imageTitleScreen = ImageIO.read(getClass().getResourceAsStream("/res/titleScreen.png"));

            imagePaper = ImageIO.read(getClass().getResourceAsStream("/res/0rps.png"));

            imageScissors = ImageIO.read(getClass().getResourceAsStream("/res/1rps.png"));

            imageRock = ImageIO.read(getClass().getResourceAsStream("/res/2rps.png"));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

    }

    public void displayMessage(String text) {

        message = text;
        messageOn = true;
    }


    public void paint(Graphics2D g2) {

        //g2.setFont(font);
        //g2.setColor(Color.white);
        //g2.drawString("Score: " + gs.player.score, 50, 50);
        this.g2 = g2;

        if (gs.gameState == gs.LOGIN) {
            // Login state
            g2.setColor(new Color(77, 225, 255));
            g2.fillRect(0, 0, gs.screenWidth, gs.screenHeight);
            paintLoginScreen();
        }
        if (gs.gameState == gs.TITLE) {
            // TITLE state
            paintTitleScreen();
        }
        if (gs.gameState == gs.MENU) {
            //Menu state
            g2.setColor(Color.black);
            g2.fillRect(0, 0, gs.screenWidth, gs.screenHeight);
            g2.drawImage(imageTitleScreen, 0, 0, gs.screenWidth, gs.screenHeight, null);
            paintMenuScreen();
        }
        if (gs.gameState == gs.PLAY) {
            // Playing state
        }
        if (gs.gameState == gs.RPS) {
            g2.drawImage(penguinImage, 13 * gs.tileSize, 2 / gs.tileSize, 200, 200, null);
            paintRPSScreen();
        }
    }

    public void paintTitleScreen() {
        // From Zeba
    }

    public void paintLoginScreen() {
        // From Frankie
        userDatabase = new HashMap<>();

        usernameLabel = new JLabel("Username:");
        usernameLabel.setSize(100, 50);
        usernameLabel.setLocation(5 * gs.tileSize, 3 * gs.tileSize);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setSize(100, 50);
        passwordLabel.setLocation(5 * gs.tileSize, 4 * gs.tileSize);

        usernameField = new JTextField();
        usernameField.setSize(300, 50);
        usernameField.setLocation(6 * gs.tileSize, 3 * gs.tileSize);

        passwordField = new JPasswordField();
        passwordField.setSize(300, 50);
        passwordField.setLocation(6 * gs.tileSize, 4 * gs.tileSize);

        loginButton = new JButton("Login");
        loginButton.setSize(100, 50);
        loginButton.setLocation(5 * gs.tileSize, 5 * gs.tileSize);

        createAccountButton = new JButton("Create Account");
        createAccountButton.setSize(200, 50);
        createAccountButton.setLocation(7 * gs.tileSize, 5 * gs.tileSize);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                if (authenticate(username, password)) {
                    JOptionPane.showMessageDialog(null, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed. Please check your credentials.");
                }
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both username and password.");
                } else {
                    createUser(username, password);
                    JOptionPane.showMessageDialog(null, "Account created successfully!");
                }

                usernameField.setText("");
                passwordField.setText("");
            }
        });

        gs.add(usernameLabel);
        gs.add(usernameField);
        gs.add(passwordLabel);
        gs.add(passwordField);
        gs.add(loginButton);
        gs.add(createAccountButton);
    }

    public boolean authenticate(String username, String password) {

        String storedPassword = userDatabase.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public void createUser(String username, String password) {
        userDatabase.put(username, password);
    }

    public void paintMenuScreen() {

        playButton = new JButton("Play Game");
        playButton.setSize(200, 100);
        playButton.setLocation(6 * gs.tileSize + 50, 7 * gs.tileSize);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gs.gameState = gs.PLAY;
            }
        });

        // Create "Exit" button
        exitButton = new JButton("Exit");
        exitButton.setSize(200, 100);
        exitButton.setLocation(6 * gs.tileSize + 50, 8 * gs.tileSize);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        gs.add(playButton);
        gs.add(exitButton);

    }

    public void paintRPSScreen() {

        Image paper = imagePaper.getScaledInstance(280, 300, Image.SCALE_SMOOTH);
        btn_paper = new JButton(new ImageIcon(paper));
        btn_paper.setBackground(Color.red);
        btn_paper.setBounds(gs.tileSize, 4 * gs.tileSize, 300, 325);

        Image scissors = imageScissors.getScaledInstance(280, 300, Image.SCALE_SMOOTH);
        btn_scissors = new JButton(new ImageIcon(scissors));
        btn_scissors.setBackground(Color.yellow);
        btn_scissors.setBounds(6 * gs.tileSize, 4 * gs.tileSize, 300, 325);

        Image rock = imageRock.getScaledInstance(280, 300, Image.SCALE_SMOOTH);
        btn_rock = new JButton(new ImageIcon(rock));
        btn_rock.setBackground(Color.blue);
        btn_rock.setBounds(11 * gs.tileSize, 4 * gs.tileSize, 300, 325);


        gs.add(btn_paper);
        gs.add(btn_scissors);
        gs.add(btn_rock);

        btn_rock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                compute_winner(1);
            }
        });

        btn_paper.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                compute_winner(2);
            }
        });

        btn_scissors.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                compute_winner(3);
            }
        });
    }

    public void compute_winner(int playerChoice) {
        int choice_computer = (int) (Math.random() * 3) + 1;
        String label_choice, label_winner = "";
        String combo_winner = "" + Math.min(choice_computer, playerChoice) + Math.max(choice_computer, playerChoice);
        switch (Integer.parseInt(combo_winner)) {

            case 12:
                label_choice = "Scissors wins!";
                if (playerChoice == 2)
                    playerScore = 1;
                break;
            case 13:
                label_choice = "Paper wins!";
                if (playerChoice == 1)
                    playerScore = 1;
                break;
            case 23:
                label_choice = "Rock wins!";
                if (playerChoice == 3)
                    playerScore = 1;
                break;
            default:
                label_choice = "It is a tie!";
                playerChoice = 2;
                tieScore += 1;
        }
        if (playerChoice == 1) {
            label_winner = "   Human wins!";
            playerScore = 0;
            winScore += 1;
            totalScore += 1;
        } else if (playerChoice == 2) {
            label_winner = "   Draw!";
            playerScore = 0;
        } else {
            label_winner = "   Computer wins!";
            totalScore += 1;
        }

        JLabel label_result = new JLabel(label_choice + label_winner);
        label_result.setForeground(Color.white);
        label_result.setBounds(7 * gs.tileSize, gs.tileSize, 300, 100);
        gs.add(label_result);

//        g2.setFont(consolas_50);
//        g2.setColor(Color.white);
//        g2.drawString(label_choice + " " + label_winner, 25, 50);
//        g2.drawString("Human's Choice", 4 * gs.tileSize, 10 * gs.tileSize);

        JLabel label_title_human = new JLabel("Human's Choice");
        label_title_human.setForeground(Color.white);
        label_title_human.setBounds(50, 35, 150, 100);
        gs.add(label_title_human);

        JLabel label_title_computer = new JLabel("Computer's Choice");
        label_title_computer.setBounds(350, 35, 150, 35);
        gs.add(label_title_computer);

        JLabel label_score1 = new JLabel("Win / Total : " + winScore + "/" + totalScore);
        label_score1.setBounds(175, 200, 150, 350);
        gs.add(label_score1);

        JLabel label_score2 = new JLabel("Tie: " + tieScore);
        label_score2.setBounds(175, 210, 125, 370);
        gs.add(label_score2);
    }
}
