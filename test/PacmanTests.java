import Mocks.MockPacman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pacman.IPacman;

import static org.junit.jupiter.api.Assertions.*;

public class PacmanTests {
    private IPacman pacman;

    @BeforeEach
    public void setUp() {
        pacman = new MockPacman(5,5);
    }

    @Test
    public void testInitialPosition() {
        assertEquals(5, pacman.getX());
        assertEquals(5, pacman.getY());
    }

    @Test
    public void testMoveRight() {
        // Arrange
        int initialX = pacman.getX();
        int initialY = pacman.getY();

        // Act
        pacman.move(1, 0);

        // Assert
        assertEquals(initialX + 1, pacman.getX());
        assertEquals(initialY, pacman.getY());
    }

    @Test
    public void testMoveUp() {
        // Arrange
        int initialX = pacman.getX();
        int initialY = pacman.getY();

        // Act
        pacman.move(0, -1);

        // Assert
        assertEquals(initialX, pacman.getX());
        assertEquals(initialY - 1, pacman.getY());
    }

    @Test
    public void testMoveLeft() {
        // Arrange
        int initialX = pacman.getX();
        int initialY = pacman.getY();

        // Act
        pacman.move(-1, 0);

        // Assert
        assertEquals(initialX - 1, pacman.getX());
        assertEquals(initialY, pacman.getY());
    }

    @Test
    public void testMoveDown() {
        // Arrange
        int initialX = pacman.getX();
        int initialY = pacman.getY();

        // Act
        pacman.move(0, 1);

        // Assert
        assertEquals(initialX, pacman.getX());
        assertEquals(initialY + 1, pacman.getY());
    }
}
