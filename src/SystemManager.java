import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by hamza on 02/11/2015.
 */

public class SystemManager {

    private ArrayList <Airport>airports = new ArrayList();
    private ArrayList <Airline>airlines = new ArrayList();


    //Singleton
    private static SystemManager systemeManagerInstance = new SystemManager();

    public static SystemManager getInstance(){
        return systemeManagerInstance;
    }

    SystemManager(){}

    public ArrayList<Airport> getAirports() {
        return airports;
    }

    public ArrayList<Airline> getAirlines() {
        return airlines;
    }

    public boolean createAirport(String code)
    {
        boolean isValidAirport = Airport.testCode(code);
        boolean isUniqAirport = Airport.testUniqCode(airports, code);
        if(isValidAirport && isUniqAirport ) {
            Airport airport = new Airport(code);
            airports.add(airport);
        }
        return isValidAirport;
    }

    public boolean createAirline(String name)
    {
        boolean isValidAirline = Airline.testNameLenght(name);
        boolean isUniqAirline = Airline.testUniqName(airlines, name);
        if(isValidAirline && isUniqAirline ) {
            Airline airline = new Airline(name);
            airlines.add(airline);
        }
        return isValidAirline;
    }

    public boolean createFlight(String nameAirline, String orig, String dest, int year, int month, int day, String id)
    {
        Airport airportOrg = null;
        Airport airportDest = null;
        for (Airport anAirport : airports){
            if (anAirport.getCode().equals(orig)){
                airportOrg = anAirport;
            }
            if (anAirport.getCode().equals(dest)){
                airportDest = anAirport;
            }
        }
        if (airportDest != null && airportOrg != null) {
            for (Airline anAirline : airlines) {
                if (anAirline.getName().equals(nameAirline)) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.set(year, month, day);
                    Flight flight = anAirline.createFlight(airportOrg, airportDest, calendar, id);
                    if(flight != null) {
                        return true;
                        // test github 
                    }
                }
            }
        }
        return false;
    }

}
