import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by hamza on 02/11/2015.
 */
public class Flight {
    private Calendar flightDate;
    private String flightID;
    private Airport orig;
    private Airport dest;

    public Flight(Airport orig, Airport dest, Calendar calendar, String id) {
        this.flightID = id;
        this.flightDate = calendar;
        this.orig = orig;
        this.dest = dest;
    }

    public Calendar getFlightDate() {
        return flightDate;
    }

    public String getFlightID() {
        return flightID;
    }

    public Airport getOrig() {
        return orig;
    }

    public Airport getDest() {
        return dest;
    }

    public boolean hasSection()
    {
        return true;
    }

    public boolean hasSeats()
    {
        return true;
    }

    public boolean createSection()
    {
        return true;
    }

    public FlightSection findSection()
    {
        return null;
    }

    public void bookSeat()
    {

    }

    public static boolean testIdLenght(String id){
        if(id.length() <= 5)
            return true;
        else
            return false;
    }
}
