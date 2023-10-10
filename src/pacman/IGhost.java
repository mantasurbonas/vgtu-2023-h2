package pacman;

public interface IGhost {
    void changeDirection();
    void move();
    boolean overlaps(IPacman pacman);
    int getX();
    void setX(int x);
    int getY();
    void setY(int y);
    int getDeltaX();
    int getDeltaY();
}
