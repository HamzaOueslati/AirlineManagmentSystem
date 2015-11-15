import java.util.*;

/**
 * Created by hamza on 02/11/2015.
 */
public class FlightSection {
    private SeatClass section;
    private Seat seat;
    private String id;
    private int row;
    private int col;

    HashMap<SeatID, Seat> seats = new HashMap<>();


    public HashMap<SeatID, Seat> getSeats() {
        return seats;
    }

    public String getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public FlightSection(String id, SeatClass section, int row, int col) {
        this.id = id;
        this.section = section;
        this.row = row;
        this.col = col;

        for(int i=0; i<row; i++)
        {
            char columnSeat = 'A';
            for(int j=0; j<col; j++)
            {
                SeatID seatID = new SeatID(i, columnSeat);
                columnSeat++;
                Seat seat = new Seat(seatID);
                seats.put(seat.getSeatNum(), seat);
            }
        }
    }

    public SeatClass getSection() {
        return section;
    }

    public boolean hasAvailableSeats() {
        Iterator it = seats.entrySet().iterator();
        while (it.hasNext()) {
            if (seats.get(it.next()).getStatus() == false)
                return true;

        }
        return false;
    }

    public boolean bookSeat() {
        if(hasAvailableSeats()) {
            this.seat.setIsBooked(true);
        }
        return false;
    }

    public void display() {
        seat.display();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightSection)) return false;

        FlightSection that = (FlightSection) o;

        return getId().equals(that.getId());

    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
