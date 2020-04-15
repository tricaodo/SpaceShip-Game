import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class SpaceShip extends Sprite {
    private int moveX;
    private int moveY;
    private List<Missile> missiles;

    public SpaceShip(int x, int y) {
        super(x, y);
        loadImage("/images/craft.png");
        missiles = new ArrayList<>();
    }

    public void move() {
        x += moveX;
        y += moveY;
    }

    private void fire(){
        missiles.add(new Missile(x, y));
    }

    public List<Missile> getMissiles(){
        return missiles;
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            moveX = -2;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            moveX = 2;
        }
        if (keyCode == KeyEvent.VK_UP) {
            moveY = -2;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            moveY = 2;
        }
        if (keyCode == KeyEvent.VK_SPACE) {
            fire();
        }
    }

    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            moveX = 0;
        }
        if (keyCode == KeyEvent.VK_RIGHT) {
            moveX = 0;
        }
        if (keyCode == KeyEvent.VK_UP) {
            moveY = 0;
        }
        if (keyCode == KeyEvent.VK_DOWN) {
            moveY = 0;
        }
    }
}
