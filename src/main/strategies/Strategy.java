package main.strategies;

import java.util.List;

import main.map.GameMap;
import main.map.Point;

public interface Strategy {
    public Point evaluatePossbileNextStep(List<Point> possibleNextStep, GameMap map);
}