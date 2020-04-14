import javax.swing.*;

public class Application extends JFrame {
    public Application(int width, int height){
        add(new Board(width, height));
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        Application application = new Application(500,450);
    }
}
