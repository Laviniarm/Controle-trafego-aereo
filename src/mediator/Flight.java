package mediator;

/**
 * Componente 1: Flight (representa um vôo de uma empresa aérea)
 *
 * @author alexs
 */
public class Flight implements Command {
    private ATCMediator atcMediator;
    private String flightNumber;
    private String airline;

    public Flight(ATCMediator atcMediator, String airline, String flight) {
        this.atcMediator = atcMediator;
        this.flightNumber = flight;
        this.airline = airline;
    }

    @Override
    public void land() {
        if (atcMediator.isCurrentFlight(this)) {
            atcMediator.occupyRunway();
            System.out.println("Flight " + flightNumber + " Successfully Landed.");
            atcMediator.setLandingStatus(false);
        } else {
            System.out.println("Flight " + flightNumber + " cannot land. Not in order.");
        }
    }

    public void takeoff() {
        if (atcMediator.isCurrentFlight(this)) {
            atcMediator.occupyRunway();
            System.out.println("Flight " + flightNumber + " Successfully Took off.");
            atcMediator.setLandingStatus(false);
        } else {
            System.out.println("Flight " + flightNumber + " cannot take off. Not in order.");
        }
    }


    public void getReadyForLanding() {
        System.out.println("Flight " + flightNumber + " from " + airline + " requesting landing authorization...");
        atcMediator.requestLandingOrTakeoff(this);
    }

    public void getReadyForTakeoff() {
        System.out.println("Flight " + flightNumber + " from " + airline + " requesting takeoff authorization...");
        atcMediator.requestLandingOrTakeoff(this);
    }

    public String getFlight() {
        return this.flightNumber;
    }

    public String getAirline() {
        return this.airline;
    }
}
