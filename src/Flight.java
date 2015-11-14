import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by hamza on 02/11/2015.
 */
public class Flight {
    private Calendar flightDate;
    private String flightID;
    private Airport orig;
    private Airport dest;

    private ArrayList<FlightSection> flightSection = new ArrayList<>();

    public ArrayList<FlightSection> getFlightSection() {
        return flightSection;
    }

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

    public static boolean checkValidColumn (char column)
    {
        String columnUpper = Character.toString(column).toUpperCase();
        if(columnUpper.equals("A"))
            return true;
        if(columnUpper.equals("B"))
            return true;
        if(columnUpper.equals("C"))
            return true;
        if(columnUpper.equals("D"))
            return true;
        if(columnUpper.equals("E"))
            return true;
        if(columnUpper.equals("F"))
            return true;
        if(columnUpper.equals("G"))
            return true;
        if(columnUpper.equals("H"))
            return true;
        if(columnUpper.equals("I"))
            return true;
        if(columnUpper.equals("J"))
            return true;
        return false;
    }

    public boolean createSection(String flightID, Integer row, char col, SeatClass seatClass)
    {
        if (row > 100 || !checkValidColumn(col)) {
            return false;
        }

        SeatID seatID = new SeatID(row, col);
        Seat seat = new Seat(seatID);
        flightSection.add(new FlightSection(seatClass, seat));

        return true;
    }

    public FlightSection findSection()
    {
        return null;
    }

    public void bookSeat(SeatClass seatClass, SeatID seatID)
    {
        Seat seat = new Seat(seatID);
        FlightSection flightSection = new FlightSection(seatClass, seat);
    }

    public static boolean testIdLenght(String id){
        if(id.length() <= 5)
            return true;
        else
            return false;
    }
}
