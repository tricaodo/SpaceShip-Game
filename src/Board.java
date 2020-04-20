import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Board extends JPanel implements ActionListener {

    private SpaceShip spaceShip;
    private List<Missile> missiles;
    private List<Alien> aliens;

    private final int B_WIDTH;
    private final int B_HEIGHT;
    private Timer timer;
    private boolean gameOver;
    private final int DELAY;

    private final int[][] positions = {
            {2380, 29}, {2500, 59}, {1380, 89},
            {780, 109}, {580, 139}, {680, 239},
            {790, 259}, {760, 50}, {790, 150},
            {980, 209}, {560, 45}, {510, 70},
            {930, 159}, {590, 80}, {530, 60},
            {940, 59}, {990, 30}, {920, 200},
            {900, 259}, {660, 50}, {540, 90},
            {810, 220}, {860, 20}, {740, 180},
            {820, 128}, {490, 170}, {700, 30}
    };

    public Board(int width, int height) {
        this.B_WIDTH = width;
        this.B_HEIGHT = height;
        this.DELAY = 10;
        initBoard();
    }

    private void initBoard() {
        this.spaceShip = new SpaceShip(40, 60);
        this.missiles = this.spaceShip.getMissiles();
        this.aliens = new ArrayList<>();
        gameOver = false;
        initAliens();
        addKeyListener(new KeyInput(spaceShip));
        setFocusable(true);
        setPreferredSize(new Dimension(this.B_WIDTH, this.B_HEIGHT));
        setBackground(Color.BLACK);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void initAliens() {
        for (int i = 0; i < positions.length; i++) {
            int[] position = positions[i];
            aliens.add(new Alien(position[0], position[1]));
        }
    }

    private void updateAliens(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < aliens.size(); i++) {
            Alien alien = aliens.get(i);
            g2d.drawImage(alien.getImage(), alien.x, alien.y, this);
            if (alien.isVisible()) {
                alien.move();
            } else {
                aliens.remove(i);
            }
        }
    }

    private void updateSpaceShip(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(spaceShip.getImage(), spaceShip.x, spaceShip.y, this);
        spaceShip.move();
    }

    private void updateMissiles(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < missiles.size(); i++) {
            Missile missile = missiles.get(i);
            g2d.drawImage(missile.getImage(), missile.x, missile.y, this);
            if (missile.isVisible()) {
                missile.move();
            } else {
                missiles.remove(i);
            }
        }
    }

    private void collision() {
        for (Missile missile : missiles) {
            Rectangle missileBound = missile.getBounds();
            for (Alien alien : aliens) {
                Rectangle alienBound = alien.getBounds();
                if (missileBound.intersects(alienBound)) {
                    missile.setVisible(false);
                    alien.setVisible(false);
                }
            }
        }

        Rectangle shipBound = spaceShip.getBounds();
        for (Alien alien : aliens) {
            Rectangle alienBound = alien.getBounds();
            if (shipBound.intersects(alienBound)) {
                gameOver = true;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!gameOver) {
            updateSpaceShip(g);
            updateMissiles(g);
            updateAliens(g);
            collision();
        } else {
            timer.stop();
            JOptionPane.showConfirmDialog(this,
                    "Do you want to play again?", "Game Over", JOptionPane.YES_NO_OPTION);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // draw
        repaint();
    }
}
