public class Alien extends Sprite {
    private int velocity;
    private final int INITIAL_X;
    private boolean isVisible;
    public Alien(int x, int y) {
        super(x, y);
        velocity = -2;
        isVisible = true;
        INITIAL_X = 500;
        loadImage("/images/alien.png");
    }

    public void move(){
        x += velocity;
        if(x < 0){
//            isVisible = false;
            x = INITIAL_X;
        }
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public boolean isVisible(){
        return isVisible;
    }
}
