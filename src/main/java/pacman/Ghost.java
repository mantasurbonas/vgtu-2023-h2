package pacman;

public class Ghost {
    int x = 2;
    int y = 3;
    int dx = 1;
    int dy = 0;

    public void changeDirection() {
        int tmp = this.dx;
        this.dx = -this.dy;
        this.dy = tmp;
    }

    public void advance() {
        this.x += this.dx;
        this.y += this.dy;
    }

    public boolean overlaps(Pacman pacman) {
        return this.x == pacman.x && this.y == pacman.y;
    }
}