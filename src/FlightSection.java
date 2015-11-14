import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by hamza on 02/11/2015.
 */
public class FlightSection {
    private SeatClass section;
    private Seat seat;

    private ArrayList<Seat> seats = new ArrayList<>();

    public FlightSection(SeatClass section, Seat seat) {
        this.section = section;
        this.seat = seat;
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

    public boolean bookSeat(SeatID seatID) {
        if(hasAvailableSeats()) {
            this.seat.setIsBooked(true);
        }
        return false;
    }

    public void display() {
        seat.display();
    }
}
