package main;

import main.game.Game;

public class Execute {
    public static void main(String[] args) {
        int totalRuns = 100;

        for(int i = 0; i < totalRuns; i++) {
            Game g = new Game();
            g.run();
            if (i == totalRuns - 1) {
                Game.testGame(totalRuns);
            }
        }
    }
}