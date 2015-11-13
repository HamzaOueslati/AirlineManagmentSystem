import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by hamza on 02/11/2015.
 */
public class Airline {
    String name;
    private ArrayList<Flight> flights = new ArrayList();

    public Airline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean testNameLenght(String name){
        if(name.length() <= 5)
            return true;
        else
            return false;
    }

    public static boolean testUniqName( ArrayList<Airline> airlines, String name)
    {
        boolean isUniq = true;
        for (Airline airline : airlines){
            if(airline.getName().equals(name))
            {
                isUniq = false;
            }
        }
        return isUniq;
    }

    public Flight createFlight(Airport orig, Airport dest, Calendar calendar, String id)
    {
        boolean isValidFlight = Flight.testIdLenght(id);
        if(isValidFlight) {
            Flight flight = new Flight(orig, dest, calendar, id);
            this.flights.add(flight);
            return flight;
        }
        return null;
    }

    public static boolean testUniqCode( ArrayList <Airport> airports, String code)
    {
        boolean isUniq = true;
        for (Airport airport : airports){
            if(airport.getCode().equals(code))
            {
                isUniq = false;
            }
        }
        return isUniq;
    }

    public ArrayList<Flight> findFlight(String flightId)
    {
        for(Flight flight : this.flights)
        {
            if(flight.getFlightID().equals(flightId)) {
                return this.flights;
            }
        }
        return null;
    }
}
