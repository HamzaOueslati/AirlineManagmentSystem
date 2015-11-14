import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by hamza on 02/11/2015.
 */
public class Airline {
    private String name;
    private HashMap<String, Flight> flights = new HashMap<>();
    private HashMap<String, Airport> airports = new HashMap<>();


    public Airline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, Flight> getFlights() {
        return flights;
    }

    public void setFlights(HashMap<String, Flight> flights) {
        this.flights = flights;
    }

    public HashMap<String, Airport> getAirports() {
        return airports;
    }

    public void setAirports(HashMap<String, Airport> airports) {
        this.airports = airports;
    }

    public void createSection() {
        //TODO: Faire
    }

    public void bookFlight(String flightID, SeatClass seatClass, int row, char col)
    {
        Flight flight = flights.get(flightID);
        SeatID seatID = new SeatID(row, col);
        flight.bookSeat(seatClass, seatID);
    }
    public static boolean testUniqCode( HashMap airports, String code)
    {
        boolean isUniq = true;
            if(airports.containsKey(code))
            {
                isUniq = false;
                System.out.println("l'identifiant n'est pas unique");
            }
        return isUniq;
    }

    public Flight createFlight(Airport orig, Airport dest, Calendar calendar, String id)
    {
        boolean isValidFlight = Flight.testIdLenght(id);
        if(isValidFlight) {
            Flight flight = new Flight(orig, dest, calendar, id);
            flights.put(id, flight);
            return flight;
        }
        return null;
    }

    public static boolean testNameLenght(String name){
        if(name.length() <= 5)
            return true;
        else
            return false;
    }

    public static boolean testUniqName( HashMap<String, Airline> airlines, String name)
    {
        boolean isUniq = true;
        if(airlines.containsKey(name))
        {
            isUniq = false;
        }
        return isUniq;
    }

    public Flight findFlight(String flightId)
    {
        if(flights.containsKey(flightId)) {
            return flights.get(flightId);
        }
        return null;
    }

    public HashMap<String, Flight> getAvailableFlights(Airport org, Airport dest)
    {
        HashMap<String, Flight> flightsAvailable = new HashMap<String, Flight>();
        for(Flight flight : flights.values()){
            if(flight.getOrig() == org && flight.getDest() == dest) {
                 for (FlightSection flightSection : flight.getFlightSection()) {
                     if (flightSection.hasAvailableSeats()) {
                         flightsAvailable.put("", flight);
                     }
                 }
            }
        }
        return flightsAvailable;
    }

    public boolean createSection(String flightID, Integer row, char col, SeatClass seatClass)
    {
        Flight flight = findFlight(flightID);
        return flight.createSection(flightID, row, col, seatClass);
    }

}