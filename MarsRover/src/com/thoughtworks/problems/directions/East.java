package com.thoughtworks.problems.directions;


import java.awt.*;

public class East implements Direction {

    @Override
    public Direction moveLeft() {
        return new North();
    }

    @Override
    public Direction moveRight() {
        return new South();
    }

    public String getName(){
        return "EAST";
    }

    @Override
    public Point moveForward(Point position) {
        return new Point(position.x+1,position.y);
    }
}
