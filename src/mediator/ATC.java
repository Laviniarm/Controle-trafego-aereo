package mediator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ATC implements ATCMediator {
	private List<Flight> flightQueue = new ArrayList<>();
	private Runway runway;
	SupportTeam supportTeam;

	@Override
	public void registerRunway(Runway runway) {
		this.runway = runway;
	}

	@Override
	public void registerFlight(Flight flight) {
		flightQueue.add(flight);
	}
	@Override
	public void registerSupportTeam(SupportTeam supportTeam) {
		this.supportTeam = supportTeam;
	}

	@Override
	public boolean isLandingOk() {
		return !flightQueue.isEmpty() && runway.isAvailable();
	}

	@Override
	public void landed() {
		runway.makeRunwayUnsafe();
		supportTeam.prepareRunway();
		this.setLandingStatus(true);
	}

	@Override
	public void setLandingStatus(boolean status) {
		if (!status) {
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

	public void requestLanding(Flight flight) {
		flightQueue.add(flight);
	}

	public boolean isCurrentFlight(Flight flight) {
		return !flightQueue.isEmpty() && flightQueue.get(0).equals(flight);
	}
}
