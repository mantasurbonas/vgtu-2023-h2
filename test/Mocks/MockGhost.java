package Mocks;

import pacman.IGhost;
import pacman.IPacman;

public class MockGhost implements IGhost {

    private int x;
    private int y;
    private int dx;
    private int dy;

    public MockGhost(int initialX, int initialY, int initialDx, int initialDy) {
        this.x = initialX;
        this.y = initialY;
        this.dx = initialDx;
        this.dy = initialDy;
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

    @Override
    public void move() {
        x += dx;
        y += dy;
    }

    @Override
    public void changeDirection() {
        int tmp = dx;
        dx = -dy;
        dy = tmp;
    }

    @Override
    public boolean overlaps(IPacman pacman) {
        return x == pacman.getX() && y == pacman.getY();
    }
}
