public class Missile extends Sprite {
    private int velocity;
    private final int B_WIDTH;
    private boolean isVisible;
    public Missile(int x, int y) {
        super(x, y);
        isVisible = true;
        B_WIDTH = 500;
        loadImage("/images/missile.png");
        this.velocity = 1;
    }

    public void move(){
        x += velocity;
        if(x > 500) isVisible = false;
    }

    public boolean isVisible(){
        return isVisible;
    }
}
