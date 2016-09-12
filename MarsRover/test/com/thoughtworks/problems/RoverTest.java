package com.thoughtworks.problems;


import com.thoughtworks.problems.directions.East;
import com.thoughtworks.problems.directions.North;
import com.thoughtworks.problems.directions.South;
import com.thoughtworks.problems.directions.West;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertThat;

public class RoverTest {

    @Test
    public void shouldCreateARoverFacingNorthDirection(){
        Rover rover = new Rover(2, 3,new North());
        assertThat(rover.getDirection().getName(), IsEqual.equalTo("NORTH"));
    }

    @Test
    public void shouldMoveTheRoverForwardWhenRoverFacesNorth(){
        Rover rover = new Rover(2, 3,new North());
        assertThat(rover.moveForward().getPosition(), IsEqual.equalTo(new Point(2,4)));
        assertThat(rover.getDirection().getName(), IsEqual.equalTo("NORTH"));
    }

    @Test
    public void shouldMoveTheRoverForwardWhenRoverFacesSouth(){
        Rover rover = new Rover(2, 3,new South());
        assertThat(rover.moveForward().getPosition(), IsEqual.equalTo(new Point(2,2)));
        assertThat(rover.getDirection().getName(), IsEqual.equalTo("SOUTH"));
    }

    @Test
    public void shouldMoveTheRoverForwardWhenRoverFacesEast(){
        Rover rover = new Rover(2, 3,new East());
        assertThat(rover.moveForward().getPosition(), IsEqual.equalTo(new Point(3,3)));
        assertThat(rover.getDirection().getName(), IsEqual.equalTo("EAST"));
    }

    @Test
    public void shouldMoveTheRoverForwardWhenRoverFacesWest(){
        Rover rover = new Rover(4, 2,new West());
        assertThat(rover.moveForward().getPosition(), IsEqual.equalTo(new Point(3,2)));
        assertThat(rover.getDirection().getName(), IsEqual.equalTo("WEST"));
    }


    @Test
    public void shouldMoveTheRoverLeftWhenRoverFacesNorth(){
        Rover rover = new Rover(2, 3,new North());
        assertThat(rover.moveLeft().getPosition(), IsEqual.equalTo(new Point(2,3)));
        assertThat(rover.getDirection().getName(), IsEqual.equalTo("WEST"));
    }

    @Test
    public void shouldMoveTheRoverRightWhenRoverFacesNorth(){
        Rover rover = new Rover(2, 3,new North());
        assertThat(rover.moveRight().getPosition(), IsEqual.equalTo(new Point(2,3)));
        assertThat(rover.getDirection().getName(), IsEqual.equalTo("EAST"));
    }

    @Test
    public void shouldMoveTheRoverLeftWhenRoverFacesSouth(){
        Rover rover = new Rover(2, 3,new South());
        assertThat(rover.moveLeft().getPosition(), IsEqual.equalTo(new Point(2,3)));
        assertThat(rover.getDirection().getName(), IsEqual.equalTo("EAST"));
    }

    @Test
    public void shouldMoveTheRoverRightWhenRoverFacesSouth(){
        Rover rover = new Rover(2, 3,new South());
        assertThat(rover.moveRight().getPosition(), IsEqual.equalTo(new Point(2,3)));
        assertThat(rover.getDirection().getName(), IsEqual.equalTo("WEST"));
    }

    @Test
    public void shouldMoveTheRoverLeftWhenRoverFacesEast(){
        Rover rover = new Rover(2, 3,new East());
        assertThat(rover.moveLeft().getPosition(), IsEqual.equalTo(new Point(2,3)));
        assertThat(rover.getDirection().getName(), IsEqual.equalTo("NORTH"));
    }

    @Test
    public void shouldMoveTheRoverRightWhenRoverFacesEast(){
        Rover rover = new Rover(2, 3,new East());
        assertThat(rover.moveRight().getPosition(), IsEqual.equalTo(new Point(2,3)));
        assertThat(rover.getDirection().getName(), IsEqual.equalTo("SOUTH"));
    }

    @Test
    public void shouldMoveTheRoverLeftWhenRoverFacesWest(){
        Rover rover = new Rover(2, 3,new West());
        assertThat(rover.moveLeft().getPosition(), IsEqual.equalTo(new Point(2,3)));
        assertThat(rover.getDirection().getName(), IsEqual.equalTo("SOUTH"));
    }

    @Test
    public void shouldMoveTheRoverRightWhenRoverFacesWest(){
        Rover rover = new Rover(2, 3,new West());
        assertThat(rover.moveRight().getPosition(), IsEqual.equalTo(new Point(2,3)));
        assertThat(rover.getDirection().getName(), IsEqual.equalTo("NORTH"));
    }

}
