package mediator.state;

import mediator.Runway;

public class Available implements RunwayState {

    @Override
    public void land(Runway runway) {
        if (runway.getSupportTeam().isAvailable()) {
            System.out.println("Landing permission granted.");
            runway.setState(new Occupied());
            runway.getSupportTeam().prepareRunway();
        } else {
            System.out.println("Support team is busy. Wait for clearance.");
        }
    }
}
