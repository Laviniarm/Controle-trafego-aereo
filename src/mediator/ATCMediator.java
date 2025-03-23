package mediator;

public interface ATCMediator {
    void registerRunway(Runway runway);
    void registerFlight(Flight flight);
    void registerSupportTeam(SupportTeam supportTeam);
    boolean isLandingOk();

    void landed();

    void setLandingStatus(boolean status);

    void requestLanding(Flight flight);

    boolean isCurrentFlight(Flight flight);

    void occupyRunway();
}