package mediator.state;

import mediator.Runway;

public class Occupied implements RunwayState{
    @Override
    public void land(Runway runway) {
        System.out.println("Runway is busy. Please wait for clearance.");
    }
}
