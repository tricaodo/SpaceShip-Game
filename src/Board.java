import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private final int B_WIDTH;
    private final int B_HEIGHT;
    public Board(int width, int height){
        this.B_WIDTH = width;
        this.B_HEIGHT = HEIGHT;
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
    }
}
