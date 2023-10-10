import Mocks.MockGhost;
import Mocks.MockPacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pacman.IGhost;
import pacman.IPacman;

import static org.junit.jupiter.api.Assertions.*;

public class GhostTests {
    private IGhost ghost;

    @BeforeEach
    public void setUp() {
        ghost = new MockGhost(2, 3, 1, 0);
    }


    @Test
    public void testInitialPosition() {
        assertEquals(2, ghost.getX());
        assertEquals(3, ghost.getY());
    }

    @Test
    public void testMove() {
        // Arrange
        int initialX = ghost.getX();
        int initialY = ghost.getY();
        int initialDx = ghost.getDeltaX();
        int initialDy = ghost.getDeltaY();

        // Act
        ghost.move();

        // Assert
        assertEquals(initialX + initialDx, ghost.getX());
        assertEquals(initialY + initialDy, ghost.getY());
    }

    @Test
    public void testOverlaps() {
        // Arrange
        IPacman pacman = new MockPacman(2,3);
        ghost.setX(2);
        ghost.setY(3);

        // Act & Assert
        assertTrue(ghost.overlaps(pacman));
    }
}
