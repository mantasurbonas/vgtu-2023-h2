package pacman;

public class Main {


    public static void main(String []s) throws Exception {
        Map map = new Map();
        Ghost ghost = new Ghost();
        Pacman pacman = new Pacman();
        
        Renderer renderer = new Renderer();
        
        GameRules gameRules = new GameRules(map, pacman, ghost);
        
        while (true) {
            
            renderer.render(map, ghost, pacman);
            
            int userInput = System.in.read();
            
            gameRules.processUserInput(userInput);
            
            gameRules.progressFrame();
        }
    }

}
