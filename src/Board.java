import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Board extends JPanel implements ActionListener {

    private SpaceShip spaceShip;
    private List<Missile> missiles;

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
        this.missiles = this.spaceShip.getMissiles();
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

    private void updateMissile(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        for(Missile missile: missiles){
            g2d.drawImage(missile.getImage(), missile.x, missile.y, this);
            if(missile.isVisible()){
                missile.move();
            }else{
                missiles.remove(missile);
            }
        }
        System.out.println("Size: " + missiles.size());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateSpaceShip(g);
        updateMissile(g);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // draw
        repaint();
    }
}
