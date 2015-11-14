import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by hamza on 02/11/2015.
 */

public class SystemManager {

    //private ArrayList <Airport>airports = new ArrayList();
    //private ArrayList <Airline>airlines = new ArrayList();
    private HashMap<String, Airline> airlines = new HashMap<>();

    public HashMap<String, Airline> getAirlines() {
        return airlines;
    }


    private HashMap<String, Airport> airports = new HashMap<>();
    // getter de la map
    public HashMap<String, Airport> getAirports() {
        return airports;
    }

    //Singleton
    private static SystemManager systemeManagerInstance = new SystemManager();
    public static SystemManager getInstance(){
        return systemeManagerInstance;
    }

    // Constructeur du System Manager
    private SystemManager(){}


    public boolean createAirport(String code)
    {
        boolean isValidAirport = Airport.testCode(code);
        boolean isUniqAirport = Airport.testUniqCode(airports, code);
        if(isValidAirport && isUniqAirport ) {
            Airport airport = new Airport(code);
            airports.put(code, airport);
        }
        return isValidAirport;
    }

    public boolean createAirline(String name)
    {
        boolean isValidAirline = Airline.testNameLenght(name);
        boolean isUniqAirline = Airline.testUniqName(airlines, name);
        if(isValidAirline && isUniqAirline ) {
            Airline airline = new Airline(name);
            airlines.put(name, airline);
        }
        return isValidAirline;
    }

    public boolean createFlight(String nameAirline, String orig, String dest, int year, int month, int day, String id)
    {
        Airport airportOrg = null;
        Airport airportDest = null;

        if (airports.containsKey(orig)){
            airportOrg = airports.get(orig);
        }
        if (airports.containsKey(dest)){
        airportDest = airports.get(dest);
        }
        if (airportDest != null && airportOrg != null) {
                if (airlines.containsKey(nameAirline)) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(year, month, day);
                    Flight flight = airlines.get(nameAirline).createFlight(airportOrg, airportDest, calendar, id);
                    if(flight != null) {
                        return true;
                        // test git
                    }
                }
        }
        return false;
    }

    public boolean createSection(String flightID, Integer row, char col, SeatClass seatClass)
    {
        // On récupére toutes les valeures contenues dans le HashMap "airlines"
        for(Airline airline : airlines.values()){
            if(airline.findFlight(flightID) != null)
            {
                airline.createSection(flightID, row, col, seatClass);
                return true;
            }
        }
        return false;
    }

    public HashMap<String, Flight> findAvailableFlights(String org, String  dest)
    {
        Airport origin = airports.get(org);
        Airport destination = airports.get(dest);

        for(Airline airline : airlines.values()){
            return airline.getAvailableFlights(origin, destination);
        }

        return null;
    }

    public void bookSeat(String air, String flightID, SeatClass seatClass, int row, char col) {
    }

}
