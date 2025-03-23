package mediator;

import mediator.state.Available;
import mediator.state.RunwayState;
import mediator.state.Unsafe;
import mediator.state.Occupied;

public class Runway implements Command {
    private ATCMediator atcMediator;
    private RunwayState currentState;

    public Runway(ATCMediator atcMediator) {
        this.atcMediator = atcMediator;
        this.currentState = new Available();
    }

    @Override
    public void land() {
        currentState.land(this);
    }

    public void takeoff() {
        currentState.takeoff(this);
    }

    public void setState(RunwayState state) {
        this.currentState = state;
    }

    public boolean isAvailable() {
        return currentState instanceof Available;
    }

    public void makeRunwayUnsafe() {
        this.setState(new Unsafe());
    }

    public void makeRunwayAvailable() {
        this.setState(new Available());
    }

    public void occupyRunway() {
        this.setState(new Occupied());
    }
}
