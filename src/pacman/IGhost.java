package pacman;

public interface IGhost {
    void changeDirection();
    void move();
    boolean overlaps(Pacman pacman);
    int getX();
    int getY();
    int getDeltaX();
    int getDeltaY();
}
