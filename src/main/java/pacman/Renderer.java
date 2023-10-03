package pacman;

public class Renderer {

    public void render(Map map, Ghost ghost, Pacman pacman) {
        for (int row = 0; row< map.getMapHeight(); row ++) {
            for (int col = 0; col < map.getMapWidgth(); col ++) {
                if (map.isWall(row, col)) {
                    System.out.print("#");
                }
                else
                if (col == pacman.x && row == pacman.y) {
                    System.out.print("C");
                }
                else
                if (col == ghost.x && row == ghost.y) {
                    System.out.print("!");
                }
                else
                if (map.isAvailable(row, col)) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
