import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {

    private SpaceShip spaceShip;

    private final int B_WIDTH;
    private final int B_HEIGHT;
    private Timer timer;
    private final int DELAY;
    public Board(int width, int height){
        this.B_WIDTH = width;
        this.B_HEIGHT = height;
        this.DELAY = 10;
        initBoard();
    }

    private void initBoard(){
        this.spaceShip = new SpaceShip(40, 60);
        addKeyListener(new KeyInput(spaceShip));
        setFocusable(true);
        setPreferredSize(new Dimension(this.B_WIDTH, this.B_HEIGHT));
        setBackground(Color.BLACK);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    private void updateSpaceShip(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(spaceShip.getImage(), spaceShip.x, spaceShip.y, this);
        spaceShip.move();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateSpaceShip(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // draw

        repaint();
    }
}
