import org.junit.jupiter.api.Test;
import pacman.Ghost;
import pacman.Pacman;

import static org.junit.jupiter.api.Assertions.*;

public class GhostTests {

    @Test
    public void testInitialPosition() {
        Ghost ghost = new Ghost(2, 3);

        assertEquals(2, ghost.getX());
        assertEquals(3, ghost.getY());
    }

    @Test
    public void testMove() {
        Ghost ghost = new Ghost(2, 3);

        ghost.move();
        assertEquals(3, ghost.getX());
        assertEquals(3, ghost.getY());

        ghost.changeDirection();
        ghost.move();
        assertEquals(3, ghost.getX());
        assertEquals(4, ghost.getY());
    }

    @Test
    public void testOverlaps() {
        Ghost ghost = new Ghost(2, 3);
        Pacman pacman = new Pacman(2, 3);

        assertTrue(ghost.overlaps(pacman));

        pacman.move(3, 3);
        assertFalse(ghost.overlaps(pacman));
    }
}
