/**
 * Created by hamza on 02/11/2015.
 */
public class Seat {
    private SeatID seatNum;
    private boolean isBooked;

    public Seat(SeatID seatNum, boolean isBooked) {
        this.seatNum = seatNum;
        this.isBooked = false;
    }

    public void setSeatNum(SeatID seatNum) {
        this.seatNum = seatNum;
    }

    public void setIsBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public Seat(SeatID seatNum) {
        this.seatNum = seatNum;
    }

    public boolean getStatus() {
        return this.isBooked;
    }

    public SeatID getSeatNum() {
        return seatNum;
    }

    public void display() {
        System.out.println("Statut du siège: "+getStatus());
        seatNum.display();
    }
}
