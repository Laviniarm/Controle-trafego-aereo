package mediator;

public interface ATCMediator {
    void registerRunway(Runway runway);
    void registerFlight(Flight flight);
    boolean isLandingOk();
    void setLandingStatus(boolean status);
}