package pacman;

public class Pacman implements IPacman {
    private int x;
    private int y;

    public Pacman(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
