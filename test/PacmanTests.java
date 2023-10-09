import org.junit.jupiter.api.Test;
import pacman.Pacman;

import static org.junit.jupiter.api.Assertions.*;

public class PacmanTests {

    @Test
    public void testInitialPosition() {
        Pacman pacman = new Pacman(5, 5);
        assertEquals(5, pacman.getX());
        assertEquals(5, pacman.getY());
    }

    @Test
    public void testMoveRight() {
        Pacman pacman = new Pacman(5, 5);

        pacman.move(1, 0);
        assertEquals(6, pacman.getX());
        assertEquals(5, pacman.getY());
    }

    @Test
    public void testMoveUp() {
        Pacman pacman = new Pacman(5, 5);

        pacman.move(0, -1);
        assertEquals(5, pacman.getX());
        assertEquals(4, pacman.getY());
    }

    @Test
    public void testMoveLeft() {
        Pacman pacman = new Pacman(5, 5);

        pacman.move(-1, 0);
        assertEquals(4, pacman.getX());
        assertEquals(5, pacman.getY());
    }

    @Test
    public void testMoveDown() {
        Pacman pacman = new Pacman(5, 5);

        pacman.move(0, 1);
        assertEquals(5, pacman.getX());
        assertEquals(6, pacman.getY());
    }
}
