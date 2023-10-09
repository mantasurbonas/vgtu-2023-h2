package windowsPacman;

import pacman.GameRules;
import pacman.Ghost;
import pacman.Map;
import pacman.Pacman;

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

    private Map map = new Map();
    private Ghost ghost = new Ghost(2,3);
    private Pacman pacman = new Pacman(5,5);

    private GameRules gameRules = new GameRules(map, pacman, ghost);

    private WindowsRenderer windowsRenderer;

    public WindowsMain() throws Exception {
        super.setPreferredSize(new Dimension(1500, 900));
        super.pack();
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        windowsRenderer =  new WindowsRenderer(map, ghost, pacman);

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

    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                try {
                    new WindowsMain();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
