package mediator;


import mediator.state.Available;
import mediator.state.RunwayState;
import mediator.state.Unsafe;

/**
 * Componente 2: Runway (representa a pista de pouso)
 *
 * @author alexs
 */
public class Runway implements Command {
    private ATCMediator atcMediator = null;
    private RunwayState currentState;
    private SupportTeam supportTeam;

    public Runway(ATCMediator atcMediator) {
        this.atcMediator = atcMediator;
        this.currentState = new Available();
        this.supportTeam = new SupportTeam();
    }

    @Override
    public void land() {
        currentState.land(this);
    }

    public void setState(RunwayState state) {
        this.currentState = state;
    }

    public SupportTeam getSupportTeam() {
        return this.supportTeam;
    }

    public void makeRunwayUnsafe() {
        this.setState(new Unsafe());
    }

    public void makeRunwayAvailable() {
        this.setState(new Available());
    }
}
