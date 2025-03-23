package mediator.state;

import mediator.Runway;

public class Unsafe implements RunwayState  {
    @Override
    public void land(Runway runway) {
        System.out.println("Runway is unsafe. Please wait for the safety check.");
    }

    @Override
    public void takeoff(Runway runway) {
        System.out.println("Runway is unsafe. Please wait for the safety check.");
    }
}
