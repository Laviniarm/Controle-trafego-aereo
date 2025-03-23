package mediator.state;

import mediator.Runway;

public interface RunwayState {
    void land(Runway runway);

    void takeoff(Runway runway);
}
