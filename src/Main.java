/**
 * Created by hamza on 02/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        SystemManager res = SystemManager.getInstance();
        // Airports
        res.createAirport("DEN");
        res.createAirport("DFW");
        res.createAirport("LON");
        res.createAirport("DEN");
        res.createAirport("CDG");
        res.createAirport("JPN");
        res.createAirport("DEN"); // Pb d ’ u n i c i t
        res.createAirport("DE"); // I n v a l i d e
        res.createAirport("DEH");
        res.createAirport("DRIrdn3 "); // I n v a l i d e

        // Airlines
        res.createAirline("DELTA");
        res.createAirline("AIRFR");
        res.createAirline("AMER");
        res.createAirline("JET");
        res.createAirline("DELTA");
        res.createAirline("SWEST");
        res.createAirline("FRONTIER"); // I n v a l i d e

        // Flights
        res.createFlight("DELTA", "DEN", "LON", 2008, 11, 12, "123");
        res.createFlight("DELTA", "DEN", "DEH", 2009, 8, 9, "567");
        res.createFlight("DELTA", "DEN", "NCE", 2010, 9, 8, "567"); //I n v a l i d e

        // Sections
        res.createSection("JET", "123", 2, 2, SeatClass.economy);
        res.createSection("JET", "123", 1, 3, SeatClass.economy);
        res.createSection("JET", "123", 2, 3, SeatClass.first);
        res.createSection("DELTA", "123", 1, 1, SeatClass.business);
        res.createSection("DELTA", "123", 1, 2, SeatClass.economy);
        res.createSection("SWSERTT", "123", 5, 5, SeatClass.economy); //I n v a l i d e

        res.displaySystemDetails();

        res.findAvailableFlights("DEN", "LON");

        res.bookSeat("DELTA", "123", SeatClass.business, 1, 'A' );
        res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'A' );
        res.bookSeat("DELTA", "123", SeatClass.economy, 1, 'B' );
        res.bookSeat("DELTA", "123", SeatClass.business, 1,'A' ); //Deja r e s e r v e

        res.displaySystemDetails();

        res.findAvailableFlights("DEN", "LON");
    }
}

