package com.thoughtworks.problems.directions;

import java.awt.*;

public class South implements Direction {

    @Override
    public Direction moveLeft() {
        return new East();
    }

    @Override
    public Direction moveRight() {
        return new West();
    }

    public String getName(){
        return "SOUTH";
    }

    @Override
    public Point moveForward(Point position) {
        return new Point(position.x,position.y-1);
    }
}
