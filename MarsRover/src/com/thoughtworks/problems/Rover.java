package com.thoughtworks.problems;


import com.thoughtworks.problems.directions.Direction;

import java.awt.*;
import java.util.Observable;

public class Rover extends Observable {
    private Point position;
    private Direction direction;

    public Rover(int xCoordinate,int yCoordinate,Direction direction){
        position = new Point(xCoordinate,yCoordinate);
        this.direction=direction;
    }

    public Point getPosition() {
        return position;
    }

    public Direction getDirection() {
        return direction;
    }

    Rover moveForward(){
        position=direction.moveForward(position);
        setChanged();
        notifyObservers(this);
        return this;
    }

    Rover moveRight(){
        direction=direction.moveRight();
        return this;
    }

    Rover moveLeft(){
        direction=direction.moveLeft();
        return this;
    }


}
