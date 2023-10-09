package pacman;

public class Renderer {

    public void render(Map map, Ghost ghost, Pacman pacman) {
        int mapWidth = map.getMapWidth();
        int mapHeight = map.getMapHeight();

        for (int row = 0; row < mapHeight; row++) {
            for (int col = 0; col < mapWidth; col++) {
                char cell = getCellContents(map, ghost, pacman, row, col);
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private char getCellContents(Map map, Ghost ghost, Pacman pacman, int row, int col) {
        if (map.isWall(row, col)) {
            return '#';
        } else if (col == pacman.getX() && row == pacman.getY()) {
            return 'C';
        } else if (col == ghost.getX() && row == ghost.getY()) {
            return '!';
        } else if (map.isAvailable(row, col)) {
            return ' ';
        } else {
            return ' ';
        }
    }
}