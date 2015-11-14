import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hamza on 02/11/2015.
 */
public class FlightSection {
    private SeatClass section;
    private Seat seat;
    private String id;
    private int row;
    private int col;

    private ArrayList<Seat> seats = new ArrayList<>();

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
                seats.add(seat);
            }
        }
    }

    public SeatClass getSection() {
        return section;
    }

    public boolean hasAvailableSeats() {
        // boucle for In pour boucler dans la ArrayList
        for(Seat seat: seats)
        {
            // Pour toutes les rangées, regarder si un siège est réservé.
            if (!seat.getStatus()){
                return true;
            }
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
}
