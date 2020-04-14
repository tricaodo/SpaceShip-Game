import java.awt.event.KeyEvent;

public class SpaceShip extends Sprite{
    private int moveX;
    private int moveY;
    public SpaceShip(int x, int y) {
        super(x, y);
        loadImage("/images/craft.png");
    }

    public void move(){
        x += moveX;
        y += moveY;
    }

    public void keyPressed(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT){
            moveX = -2;
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            moveX = 2;
        }
        if(keyCode == KeyEvent.VK_UP){
            moveY = -2;
        }
        if(keyCode == KeyEvent.VK_DOWN){
            moveY = 2;
        }
    }

    public void keyReleased(KeyEvent e){
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_LEFT){
            moveX = 0;
        }
        if(keyCode == KeyEvent.VK_RIGHT){
            moveX = 0;
        }
        if(keyCode == KeyEvent.VK_UP){
            moveY = 0;
        }
        if(keyCode == KeyEvent.VK_DOWN){
            moveY = 0;
        }
    }
}
