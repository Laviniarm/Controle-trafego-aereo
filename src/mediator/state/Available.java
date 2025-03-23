package mediator.state;

import mediator.Runway;

public class Available implements RunwayState {

    @Override
    public void land(Runway runway) {
        System.out.println("Landing permission granted.");
        runway.setState(new Occupied());
    }
}
