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

    public void getReady() {
        System.out.println("Flight " + flightNumber + " from " + airline + " requesting landing authorization...");
        atcMediator.requestLanding(this);
    }

    public String getFlight() {
        return this.flightNumber;
    }

    public String getAirline() {
        return this.airline;
    }
}
