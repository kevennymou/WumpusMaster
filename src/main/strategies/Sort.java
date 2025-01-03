package main.strategies;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.map.GameMap;
import main.map.Monster;
import main.map.Point;
import main.map.Rock;

public class Sort implements Strategy{
    /**
     * N is the next location
     * p1 p2 p3
     * p4 N p5
     * p6 p7 p8
     */
    @Override
    public Point evaluatePossbileNextStep(List<Point> possibleNextSteps, GameMap map) {
        List<Point> validNextSteps = new ArrayList<>();

        // Verifica passos válidos (ignora rochas e monstros)
        for (Point nextStep : possibleNextSteps) {
            String space = map.get(nextStep);
            if (space != null && (space.equals(Rock.CHARACTER) || space.equals(Monster.CHARACTER))) {
                continue;
            }
            validNextSteps.add(nextStep);
        }

        // Escolhe aleatoriamente um ponto da lista de passos válidos
        Random random = new Random();
        return validNextSteps.get(random.nextInt(validNextSteps.size()));


    }


}