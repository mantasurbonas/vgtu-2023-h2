package pacman;

public class Pacman {
    int x = 5;
    int y = 5;
    
    public void moveWest() {
        this.x ++;
    }

    public void moveEast() {
        this.x --;
    }

    public void moveSouth() {
        this.y ++;
    }

    public void moveNorth() {
        this.y --;
    }
}