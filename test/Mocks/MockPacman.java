package Mocks;

import pacman.IPacman;

public class MockPacman implements IPacman {
    private int x;
    private int y;

    public MockPacman(int initialX, int initialY) {
        this.x = initialX;
        this.y = initialY;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }
}