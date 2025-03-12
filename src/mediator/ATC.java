package mediator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ATC implements ATCMediator {
	private Queue<Flight> flightQueue = new LinkedList<>();
	private boolean land = true;
	private Runway runway;

    
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
		return land;
	}

	@Override
	public void setLandingStatus(boolean status) {
		land = status;
	}

	public void processLandings() {
		while (!flightQueue.isEmpty()) {
			Flight flight = flightQueue.poll();
			flight.getReady();
			runway.land();
			flight.land();
		}
	}
}
