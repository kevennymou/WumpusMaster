package main.game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import main.strategies.Strategy;
import main.map.GameMap;
import main.map.Point;

public class Player {
    public static final String CHARACTER = "W";
    private Strategy strategy;
    public Player(Strategy strategy) {
        this.strategy = strategy;
    }

    public Point evaluatePossibleNextStep(GameMap gameMap) {
        Point robotLocation = gameMap.getRobotLocation();
        List<Point> possibleNextSteps = new ArrayList<>();
        possibleNextSteps.add(new Point(robotLocation.getPositionX(), robotLocation.getPositionY() + 1));
        possibleNextSteps.add(new Point(robotLocation.getPositionX() + 1, robotLocation.getPositionY()));
        possibleNextSteps.add(new Point(robotLocation.getPositionX() - 1, robotLocation.getPositionY()));
        possibleNextSteps.add(new Point(robotLocation.getPositionX(), robotLocation.getPositionY() - 1));

        List<Point> result = new LinkedList<Point>();
        // Filter impossible next steps
        for (int i = 0; i < possibleNextSteps.size(); i++) {
            Point p = possibleNextSteps.get(i);
            int[] scenarioSize = gameMap.getScenarioSize();
            if (p.getPositionX() >= 0 && p.getPositionY() >= 0 &&
                    p.getPositionX() < scenarioSize[0] && p.getPositionY() < scenarioSize[1]) {
                result.add(p);
            }
        }
        return this.strategy.evaluatePossbileNextStep(result, gameMap);
    }

}