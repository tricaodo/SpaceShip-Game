import javax.swing.*;
import java.awt.*;

public class Sprite {
    protected int x;
    protected int y;
    private Image image;
    public Sprite(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void loadImage(String path){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(path));
        image = imageIcon.getImage();
    }

    public Image getImage(){
        return image;
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
    }
}
