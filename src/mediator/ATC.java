package mediator;

import java.util.ArrayList;
import java.util.List;

public class ATC implements ATCMediator {
	private static ATC instance;
	private List<Flight> flightQueue = new ArrayList<>();
	private Runway runway;
	SupportTeam supportTeam;

	private ATC() {
		this.supportTeam = new SupportTeam();
	}

	public static ATC getInstance() {
		if (instance == null) {
			instance = new ATC();
		}
		return instance;
	}

	@Override
	public void registerRunway(Runway runway) {
		this.runway = runway;
	}

	@Override
	public void registerFlight(Flight flight) {
		flightQueue.add(flight);
	}

	@Override
	public boolean isLandingOk() {
		return !flightQueue.isEmpty() && runway.isAvailable();
	}

	@Override
	public void setLandingStatus(boolean status) {
		if (!status) {
			runway.makeRunwayUnsafe();
			System.out.println("Runway is unsafe. Please wait for the safety check.");
			supportTeam.prepareRunway();
			System.out.println("Runway is safe!");
			runway.makeRunwayAvailable();
		}
		if (!flightQueue.isEmpty()) {
			flightQueue.removeFirst();
		}
	}

	public void occupyRunway() {
		if (!flightQueue.isEmpty()) {
			runway.occupyRunway();
		}
	}

	public void requestLandingOrTakeoff(Flight flight) {
		flightQueue.add(flight);
	}

	public boolean isCurrentFlight(Flight flight) {
		return !flightQueue.isEmpty() && flightQueue.get(0).equals(flight);
	}
}
