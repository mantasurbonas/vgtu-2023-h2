package pacman;

public class GameRules {
    Map map;
    IPacman pacman;
    IGhost ghost;

    public GameRules(Map map, IPacman pacman, IGhost ghost) {
        this.map = map;
        this.pacman = pacman;
        this.ghost = ghost;
    }

    public void processUserInput(int userInput) {
        switch (userInput) {
            case 'w':
                movePacmanIfAvailable(0, -1);
                break;
            case 's':
                movePacmanIfAvailable(0, 1);
                break;
            case 'a':
                movePacmanIfAvailable(-1, 0);
                break;
            case 'd':
                movePacmanIfAvailable(1, 0);
                break;
            case 'q':
                System.exit(0);
        }
    }

    private void movePacmanIfAvailable(int deltaX, int deltaY) {
        int newX = pacman.getX() + deltaX;
        int newY = pacman.getY() + deltaY;

        if (map.isAvailable(newY, newX)) {
            pacman.move(deltaX, deltaY);
        }
    }

    public void progressFrame() {
        if (ghost.overlaps(pacman)) {
            System.exit(1);
        }

        int newGhostX = ghost.getX() + ghost.getDeltaX();
        int newGhostY = ghost.getY() + ghost.getDeltaY();

        if (map.isAvailable(newGhostY, newGhostX)) {
            ghost.move();
        } else {
            ghost.changeDirection();
        }
    }
}
