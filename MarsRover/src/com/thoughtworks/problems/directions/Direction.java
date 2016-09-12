package com.thoughtworks.problems.directions;


import java.awt.*;

public interface Direction {
    Direction moveLeft();
    Direction moveRight();
    String getName();
    Point moveForward(Point position);
}
