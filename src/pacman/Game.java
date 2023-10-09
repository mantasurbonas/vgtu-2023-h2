package pacman;

import java.io.IOException;

public class Game {
    private Map map;
    private Ghost ghost;
    private Pacman pacman;
    private Renderer renderer;
    private GameRules gameRules;

    public Game() {
        map = new Map();
        ghost = new Ghost(2,3);
        pacman = new Pacman(5,5);
        renderer = new Renderer();
        gameRules = new GameRules(map, pacman, ghost);
    }

    public void play() throws IOException {
        while (true) {
            renderer.render(map, ghost, pacman);

            int userInput = System.in.read();

            gameRules.processUserInput(userInput);

            gameRules.progressFrame();
        }
    }
}