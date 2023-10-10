package windowsPacman;

import pacman.IGhost;
import pacman.Map;
import pacman.IPacman;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WindowsRenderer {
    private static final String IMAGE_PATH = "src/windowsPacman/resources/";

    private Map map;
    private IGhost ghost;
    private IPacman pacman;


    private BufferedImage pacmanImage;
    private BufferedImage ghostImage;
    private BufferedImage wallImage;

    public WindowsRenderer(Map map, IGhost ghost, IPacman pacman) {
        this.map = map;
        this.ghost = ghost;
        this.pacman = pacman;

        try {
            pacmanImage = ImageIO.read(new FileInputStream(IMAGE_PATH + "pacman-open.png"));
            ghostImage = ImageIO.read(new FileInputStream(IMAGE_PATH + "ghost.png"));
            wallImage = ImageIO.read(new FileInputStream(IMAGE_PATH + "wall.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics g) {
        for (int row = 0; row < map.getMapHeight(); row ++) {
            for (int col = 0; col < map.getMapWidth(); col ++) {
                if (map.isWall(row, col)) {
                    g.drawImage(wallImage, 50 + col*20, 50 + row*20, 20, 20, null);
                }
                else if (col == pacman.getX() && row == pacman.getY()) {
                    g.drawImage(pacmanImage, 50 + col*20, 50 + row*20, 20, 20, null);
                }
                else if (col == ghost.getX() && row == ghost.getY()) {
                    g.drawImage(ghostImage, 50+col*20, 50+row*20, 20, 20, null);
                }
            }
        }
    }
}
