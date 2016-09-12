package com.thoughtworks.problems;

import com.thoughtworks.problems.directions.East;
import com.thoughtworks.problems.directions.North;

public class Demo {
    public static void main(String[] args) {
        Plateau plateau = new Plateau(6,6);
        Rover rover1 = new Rover(1,2,new North());
        Rover rover2 = new Rover(3,3,new East());

        plateau.placeRover(rover1);
        plateau.getRover().moveLeft();
        plateau.getRover().moveForward();
        plateau.getRover().moveLeft();
        plateau.getRover().moveForward();
        plateau.getRover().moveLeft();
        plateau.getRover().moveForward();
        plateau.getRover().moveLeft();
        plateau.getRover().moveForward();
        plateau.getRover().moveForward();

        int x=plateau.getRover().getPosition().x;
        int y=plateau.getRover().getPosition().y;
        String direction=plateau.getRover().getDirection().getName();

        System.out.println(x+" "+y+" "+direction);

        plateau.placeRover(rover2);
        plateau.getRover().moveForward();
        plateau.getRover().moveForward();
        plateau.getRover().moveRight();
        plateau.getRover().moveForward();
        plateau.getRover().moveForward();
        plateau.getRover().moveRight();
        plateau.getRover().moveForward();
        plateau.getRover().moveRight();
        plateau.getRover().moveRight();
        plateau.getRover().moveForward();

        x=plateau.getRover().getPosition().x;
        y=plateau.getRover().getPosition().y;
        direction=plateau.getRover().getDirection().getName();

        System.out.println(x+" "+y+" "+direction);

    }
}
