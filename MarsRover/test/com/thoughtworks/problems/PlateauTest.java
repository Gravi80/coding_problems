package com.thoughtworks.problems;

import com.thoughtworks.problems.directions.East;
import com.thoughtworks.problems.directions.North;
import com.thoughtworks.problems.directions.South;
import com.thoughtworks.problems.directions.West;
import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertThat;

public class PlateauTest {

    Plateau plateau;
    @Before
    public void before(){
       plateau=new Plateau(4,4);
    }

    @Test
    public void shouldMoveTheRoverForwardOnPlateauFacingNorthDirection(){
        Rover rover = new Rover(2, 3,new North());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(2, 4)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("NORTH"));
    }

    @Test
    public void shouldNotAllowTheRoverToMoveForwardIfRoverIsOnTheTopRightEdgeFacingNorth(){
        Rover rover = new Rover(4, 4,new North());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(4, 4)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("NORTH"));
    }

    @Test
    public void shouldNotAllowTheRoverToMoveForwardIfRoverIsOnTheTopRightEdgeFacingEast(){
        Rover rover = new Rover(4, 4,new East());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(4, 4)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("EAST"));
    }

    @Test
    public void shouldAllowTheRoverToMoveForwardIfRoverIsOnTheTopRightEdgeFacingWest(){
        Rover rover = new Rover(4, 4,new West());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(3, 4)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("WEST"));
    }

    @Test
    public void shouldAllowTheRoverToMoveForwardIfRoverIsOnTheTopRightEdgeFacingSouth(){
        Rover rover = new Rover(4, 4,new South());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(4, 3)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("SOUTH"));
    }

    @Test
    public void shouldNotAllowTheRoverToMoveForwardIfRoverIsOnTheTopLeftEdgeFacingNorth(){
        Rover rover = new Rover(0, 4,new North());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(0, 4)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("NORTH"));
    }

    @Test
    public void shouldAllowTheRoverToMoveForwardIfRoverIsOnTheTopLeftEdgeFacingEast(){
        Rover rover = new Rover(0, 4,new East());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(1, 4)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("EAST"));
    }

    @Test
    public void shouldNotAllowTheRoverToMoveForwardIfRoverIsOnTheTopLeftEdgeFacingWest(){
        Rover rover = new Rover(0, 4,new West());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(0, 4)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("WEST"));
    }

    @Test
    public void shouldAllowTheRoverToMoveForwardIfRoverIsOnTheTopLeftEdgeFacingSouth(){
        Rover rover = new Rover(0, 4,new South());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(0, 3)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("SOUTH"));
    }

    @Test
    public void shouldAllowTheRoverToMoveForwardIfRoverIsOnTheBottomLeftEdgeFacingNorth(){
        Rover rover = new Rover(0, 0,new North());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(0, 1)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("NORTH"));
    }

    @Test
    public void shouldAllowTheRoverToMoveForwardIfRoverIsOnTheBottomLeftEdgeFacingEast(){
        Rover rover = new Rover(0, 0,new East());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(1, 0)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("EAST"));
    }

    @Test
    public void shouldNotAllowTheRoverToMoveForwardIfRoverIsOnTheBottomLeftEdgeFacingWest(){
        Rover rover = new Rover(0, 0,new West());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(0, 0)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("WEST"));
    }

    @Test
    public void shouldAllowTheRoverToMoveForwardIfRoverIsOnTheBottomLeftEdgeFacingSouth(){
        Rover rover = new Rover(0, 0,new South());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(0, 0)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("SOUTH"));
    }

    @Test
    public void shouldAllowTheRoverToMoveForwardIfRoverIsOnTheBottomRightEdgeFacingNorth(){
        Rover rover = new Rover(4, 0,new North());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(4, 1)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("NORTH"));
    }

    @Test
    public void shouldNotAllowTheRoverToMoveForwardIfRoverIsOnTheBottomRightEdgeFacingEast(){
        Rover rover = new Rover(4, 0,new East());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(4,0)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("EAST"));
    }

    @Test
    public void shouldAllowTheRoverToMoveForwardIfRoverIsOnTheBottomRightEdgeFacingWest(){
        Rover rover = new Rover(4, 0,new West());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(3, 0)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("WEST"));
    }

    @Test
    public void shouldNotAllowTheRoverToMoveForwardIfRoverIsOnTheBottomRightEdgeFacingSouth(){
        Rover rover = new Rover(4, 0,new South());
        plateau.placeRover(rover);
        rover.moveForward();
        assertThat(plateau.getRover().getPosition(), IsEqual.equalTo(new Point(4,0)));
        assertThat(plateau.getRover().getDirection().getName(), IsEqual.equalTo("SOUTH"));
    }

}
