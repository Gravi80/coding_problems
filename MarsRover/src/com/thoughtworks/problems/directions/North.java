package com.thoughtworks.problems.directions;

import java.awt.*;

public class North implements Direction {

    @Override
    public Direction moveLeft() {
        return new West();
    }

    @Override
    public Direction moveRight() {
        return new East();
    }

    public String getName(){
        return "NORTH";
    }

    @Override
    public Point moveForward(Point position) {
        return new Point(position.x,position.y+1);
    }
}
