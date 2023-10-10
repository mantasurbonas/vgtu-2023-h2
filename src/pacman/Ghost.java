package pacman;

public class Ghost implements IGhost{
    private int x;
    private int y;
    private int dx;
    private int dy;

    public Ghost(int initialX, int initialY, int initialDx, int initialDy) {
        this.x = initialX;
        this.y = initialY;
        this.dx = initialDx;
        this.dy = initialDy;
    }

    @Override
    public void changeDirection() {
        int temp = dx;
        dx = -dy;
        dy = temp;
    }

    @Override
    public void move() {
        x += dx;
        y += dy;
    }

    @Override
    public boolean overlaps(IPacman pacman) {
        return x == pacman.getX() && y == pacman.getY();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getDeltaX() {
        return dx;
    }

    @Override
    public int getDeltaY() {
        return dy;
    }
}
