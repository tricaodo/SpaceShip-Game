import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    private SpaceShip spaceShip;
    public KeyInput(SpaceShip spaceShip){
        this.spaceShip = spaceShip;
    }

    public void keyPressed(KeyEvent e){
        System.out.println("Press");
        spaceShip.keyPressed(e);
    }

    public void keyReleased(KeyEvent e){
        spaceShip.keyReleased(e);
    }
}
