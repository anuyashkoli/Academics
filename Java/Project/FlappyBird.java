import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    private int width = 800;
    private int height = 600;
    private int birdY = height / 2;
    private int birdVelocity = 0;
    private int gravity = 1;
    private int jumpStrength = -15;
    private ArrayList<Rectangle> pipes = new ArrayList<>();
    private Random random = new Random();
    private Timer timer;
    private boolean gameOver = false;
    private int score = 0;

    public FlappyBird() {
        timer = new Timer(20, this);
        addKeyListener(this);
        setFocusable(true);
        setPreferredSize(new Dimension(width, height));
        startGame();
    }

    private void startGame() {
        birdY = height / 2;
        pipes.clear();
        score = 0;
        gameOver = false;
        addPipe();
        timer.start();
    }

    private void addPipe() {
        int gap = 200;
        int pipeWidth = 50;
        int pipeHeight = random.nextInt(height - gap - 100) + 50;
        pipes.add(new Rectangle(width, height - pipeHeight, pipeWidth, pipeHeight));
        pipes.add(new Rectangle(width, 0, pipeWidth, height - pipeHeight - gap));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, width, height);

        g.setColor(Color.ORANGE);
        g.fillRect(100, birdY, 30, 30);

        g.setColor(Color.GREEN);
        for (Rectangle pipe : pipes) {
            g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);
        }

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 30);

        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("Game Over!", width / 2 - 100, height / 2);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Press SPACE to restart", width / 2 - 100, height / 2 + 40);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            birdVelocity += gravity;
            birdY += birdVelocity;

            // Check if we need to add a new pipe
            if (pipes.isEmpty() || pipes.get(pipes.size() - 1).x < width - 300) {
                addPipe();
            }

            for (int i = 0; i < pipes.size(); i++) {
                Rectangle pipe = pipes.get(i);
                pipe.x -= 5;

                // Remove pipes that are off-screen
                if (pipe.x + pipe.width < 0) {
                    pipes.remove(i);
                    i--;
                    continue;
                }

                // Check for collision
                if (pipe.intersects(new Rectangle(100, birdY, 30, 30))) {
                    gameOver = true;
                }

                // Update score when passing a pipe
                if (pipe.x + pipe.width == 95 && i % 2 == 0) {  // 95 is just before the bird's x-position
                    score++;
                }
            }

            if (birdY > height || birdY < 0) {
                gameOver = true;
            }

            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (gameOver) {
                startGame();
            } else {
                birdVelocity = jumpStrength;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Flappy Bird");
        FlappyBird game = new FlappyBird();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}