package main.game;

import main.map.GameMap;
import main.map.Point;
import main.map.TreasureChest;
import main.strategies.*;

public class Game {

    private final GameMap map;
    private final Player player;
    private static double errorMap = 0;
    private static double success = 0;
    private static double empty = 0;
    private static double trap = 0;
    private static int totalSteps = 0; // Total steps across all games
    private static int gameCount = 0;  // Total number of games played
    private static final int MAX_MOVES = 100; // Limit to prevent infinite loops

    public Game() {
        this.map = new GameMap(8, 8);
        //this.player = new Player(new FewerObstacles());
        this.player = new Player(new Sort());
        //this.player = new Player(new ShortestDistance());
        //this.player = new Player(new BinaryTree(map));
        //this.player = new Player(new Voting());
    }

    public void run() {
        this.map.print();
        System.out.println();
        int moveCount = 0;

        while (moveCount < MAX_MOVES) {
            Point nextPoint = this.player.evaluatePossibleNextStep(map);
            if (nextPoint == null) {
                System.out.println("No valid moves available.\n");
                errorMap++;
                break;
            } else {
                String space = this.map.get(nextPoint);
                if (space != null && space.equals(TreasureChest.CHARACTER)) {
                    this.map.openTreasureChest(nextPoint);
                    this.map.print();
                    switch (this.map.get(nextPoint)) {
                        case TreasureChest.CHEST_TRESURE_CHARACTER -> success++;
                        case TreasureChest.CHEST_TRAP_CHARACTER -> trap++;
                        case TreasureChest.CHEST_EMPTY_CHARACTER -> empty++;
                    }
                    break;
                } else {
                    this.map.moveRobot(nextPoint);
                    moveCount++;
                }
            }
            this.map.print();
            System.out.println();
        }

        if (moveCount >= MAX_MOVES) {
            System.out.println("Maximum moves reached. Ending game.\n");
            System.out.println(" ");
            errorMap++;
        }

        // Add to total steps and increment game count
        totalSteps += moveCount;
        gameCount++;
        System.out.println(moveCount + " moves taken in this game.\n");
        System.out.println(" ");
    }

    public static void testGame(int totalRuns) {
        System.out.println("---------------------------------------");
        System.out.println("Results over " + totalRuns + " runs:");
        System.out.printf("Success: %.2f%% \n", (success / totalRuns) * 100);
        System.out.printf("Empty Treasure: %.2f%% \n", (empty / totalRuns) * 100);
        System.out.printf("Trap: %.2f%% \n", (trap / totalRuns) * 100);
        System.out.printf("No valid moves: %.2f%% \n", (errorMap / totalRuns) * 100);
        System.out.printf("Average steps taken per game: %.2f \n", (double) totalSteps / gameCount);
        System.out.println("---------------------------------------");
    }
}