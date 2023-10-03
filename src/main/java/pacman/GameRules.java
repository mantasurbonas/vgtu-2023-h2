package pacman;


/***
 * 
 */
public class GameRules {

    Map map;
    Pacman pacman;
    Ghost ghost;
    
    
    public GameRules(Map map, Pacman pacman, Ghost ghost) {
        this.map = map;
        this.pacman = pacman;
        this.ghost = ghost;
    }
    
    public void processUserInput(int userInput) {
        if (userInput == 'w') {
            if (map.isAvailable(pacman.y -1, pacman.x))
                pacman.moveNorth();
        }else 
        if (userInput == 's') {
            if (map.isAvailable(pacman.y +1, pacman.x))
                pacman.moveSouth();
        }else
        if (userInput == 'a') {
            if (map.isAvailable(pacman.y, pacman.x -1))
                pacman.moveEast();
        }else 
        if (userInput == 'd') {
            if (map.isAvailable(pacman.y, pacman.x +1))
                pacman.moveWest();
        }else
        if (userInput == 'q') {
            System.exit(0);
        }
    }

    public void progressFrame() {
        if (ghost.overlaps(pacman)) {
            System.exit(1);
        }
        
        if (map.isAvailable(ghost.y + ghost.dy, ghost.x + ghost.dx)) {
            ghost.advance();
        } else {
            ghost.changeDirection();
        }
    }

    
}
