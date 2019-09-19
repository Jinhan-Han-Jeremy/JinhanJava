package airlines;

import java.util.HashSet;

public class FlightNet extends HashSet<Airport> {

	// check the name is exist or not
	public boolean nameIsAvailable(String name) {

		for (Airport air : this) {
			if (air.getName().equals(name))
				return false;
		}
		return true;
	}

	// connect a1 and a2 using method from airport
	public void connect(Airport a1, Airport a2) {
		if (!this.contains(a1)) {
			this.add(a1);
		}
		if (!this.contains(a2)) {
			this.add(a2);
		}
		a1.connectTo(a2);
		a2.connectTo(a1);
	}

	// disconnect a1 and a2 using method from airport
	public void disconnect(Airport a1, Airport a2) {
		a1.disconnectFrom(a2);
		a2.disconnectFrom(a1);

	}

	// remove and disconnect
	public void removeAndDisconnect(Airport removeMe) {
		if (this.contains(removeMe))
			this.remove(removeMe);

		for (Airport airline : this)
			disconnect(removeMe, airline);
	}

	public Airport getAirportNearXY(int x, int y, int maximumDistance) {

		for (Airport airline : this) {

			double length = Math.abs(Math.hypot(x - airline.getX(), y - airline.getY()));

			if (length <= maximumDistance) {
				return airline;
			}
		}
		return null;

	}

}
