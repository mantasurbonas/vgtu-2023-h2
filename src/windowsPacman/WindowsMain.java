package windowsPacman;

import pacman.*;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class WindowsMain extends JFrame{
    private Map map;
    private IGhost ghost;
    private IPacman pacman;
    private GameRules gameRules;
    private WindowsRenderer windowsRenderer;

    public WindowsMain(Map map, IGhost ghost, IPacman pacman) {
        this.map = map;
        this.ghost = ghost;
        this.pacman = pacman;
        gameRules = new GameRules(map, pacman, ghost);
        windowsRenderer = new WindowsRenderer(map, ghost, pacman);

        super.setPreferredSize(new Dimension(1500, 900));
        super.pack();
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        super.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                char userInput = e.getKeyChar();
                gameRules.processUserInput(userInput);
                repaint();
            }
        });

        new Timer(300, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                gameRules.progressFrame();
                repaint();
            }
        }).start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        windowsRenderer.render(g);
    }

    public static void main(String[] args) throws InvocationTargetException, InterruptedException{
        SwingUtilities.invokeAndWait(() -> {
            Map map = new Map();
            IGhost ghost = new Ghost(2, 3, 1, 0);
            IPacman pacman = new Pacman(5, 5);
            new WindowsMain(map, ghost, pacman);
        });
    }
}
