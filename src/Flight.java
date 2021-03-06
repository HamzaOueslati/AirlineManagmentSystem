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
        if (flightSection.isEmpty())
            return false;
        else
            return true;
    }

    public boolean hasSeats()
    {
        return true;
    }

    /*public static boolean checkValidColumn (char column)
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
    }*/

    public boolean createSection(int row, int col, SeatClass seatClass, String flightID)
    {
        if (row > 100 || row <0) {
            System.out.println("Creation impossible, Rangs incorrect");
            return false;
        }
        if(col > 10 || col<0) {
            System.out.println("Creation impossible, colonnes incorrect");
            return false;
        }

        flightSection.add(new FlightSection(flightID, seatClass, row, col));

        return true;
    }

    public SeatClass findSection(SeatClass seatClass)
    {
        return seatClass;
    }


    /*public void bookSeat(SeatClass seatClass, SeatID seatID)
    {
        Seat seat = new Seat(seatID);
        FlightSection flightSection = new FlightSection(seatClass, seat);
    }*/

    public static boolean testIdLenght(String id){
        if(id.length() <= 5)
            return true;
        else
            return false;
    }


}
