package com.thoughtworks.problems;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Plateau implements Observer{
    private Dimension dimension;
    private Rover rover;

    public Rover getRover() {
        return rover;
    }

    public Plateau(int length,int width){
       dimension = new Dimension(width,length);
    }

    public void placeRover(Rover rover) {
        this.rover = rover;
        this.rover.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        Rover rover =(Rover)o;
        if(!(0 <= rover.getPosition().x &&  rover.getPosition().x<= dimension.width)){
            if (rover.getPosition().x==-1) rover.getPosition().x=1;
            rover.getPosition().x=rover.getPosition().x-1;
            System.out.println("Reached At Edge Of Plateau");
        }
        if(!(0 <= rover.getPosition().y &&  rover.getPosition().y<= dimension.height)){
            if (rover.getPosition().y==-1) rover.getPosition().y=1;
            rover.getPosition().y=rover.getPosition().y-1;
            System.out.println("Reached At Edge Of Plateau");
        }
    }
}
