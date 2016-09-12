package com.thoughtworks.problems.directions;

import java.awt.*;

public class West implements Direction {


    @Override
    public Direction moveLeft() {
        return new South();
    }

    @Override
    public Direction moveRight() {
        return new North();
    }

    public String getName(){
        return "WEST";
    }

    @Override
    public Point moveForward(Point position) {
        return new Point(position.x-1,position.y);
    }
}
