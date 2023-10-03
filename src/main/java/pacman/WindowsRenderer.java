package pacman;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

public class WindowsRenderer {

    private Map map;
    private Ghost ghost;
    private Pacman pacman;
    
    
    private BufferedImage pacmanImage;
    private BufferedImage ghostImage;
    private BufferedImage wallImage;
    
    public WindowsRenderer(Map map, Ghost ghost, Pacman pacman) throws Exception {
        this.map = map;
        this.ghost =ghost;
        this.pacman = pacman;
        
        
        pacmanImage = ImageIO.read(new FileInputStream("src/main/resources/pacman-open.png"));
        ghostImage = ImageIO.read(new FileInputStream("src/main/resources/ghost.png"));
        wallImage = ImageIO.read(new FileInputStream("src/main/resources/wall.png"));
    }
    
    public void render(Graphics g) {
        for (int row = 0; row< map.getMapHeight(); row ++) {
            for (int col = 0; col < map.getMapWidgth(); col ++) {
                if (map.isWall(row, col)) {
                    g.drawImage(wallImage, 50 + col*20, 50 + row*20, 20, 20, null);
                }
                else
                if (col == pacman.x && row == pacman.y) {
                    g.drawImage(pacmanImage, 50 + col*20, 50 + row*20, 20, 20, null);
                }
                else
                if (col == ghost.x && row == ghost.y) {
                    g.drawImage(ghostImage, 50+col*20, 50+row*20, 20, 20, null);
                }
            }
        }
    }
}
