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
        res.createAirport("DEN"); // Pb d'unicite
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
        res.createAirline("DELTA"); // pb d'unicite
        res.createAirline("SWEST");
        res.createAirline("FRONTIER"); // I n v a l i d e

        // Flights
        res.createFlight("DELTA", "DEN", "LON", 2008, 11, 12, "123");
        res.createFlight("DELTA", "DEN", "LON", 2008, 11, 12, "894");
        res.createFlight("DELTA", "DEN", "DEH", 2009, 8, 9, "567");
        res.createFlight("DELTA", "DEN", "NCE", 2010, 9, 8, "567"); //I n v a l i d e

        // Sections
        res.createSection("DELTA", "123", 1, 2, SeatClass.ECO, "SECTION_ECO");
        res.createSection("DELTA", "123", 4, 2, SeatClass.FIRST, "SECTION_FIRST");
        res.createSection("DELTA", "123", 5, 2, SeatClass.BUSI, "SECTION_BUSI");
        res.createSection("DELTA", "123", 8, 2, SeatClass.BUSI, "SECTION_BUSI");
        //res.createSection("DELTA", "123", 150, 2, SeatClass.BUSI, "SECTION_BUSI"); // Invalide, nb Rangs trop grand

        //res.displaySystemDetails();

        res.findAvailableFlights("DEN", "LON");
/*
        res.bookSeat("DELTA", "123", SeatClass.ECO, 1, 'A' );
        res.bookSeat("DELTA", "123", SeatClass.ECO, 1, 'A' );
        res.bookSeat("DELTA", "123", SeatClass.ECO, 1, 'B' );
        res.bookSeat("DELTA", "123", SeatClass.BUSI, 1,'A' ); //Deja r e s e r v e*/

        //res.displaySystemDetails();*/

        //res.findAvailableFlights("DEN", "LON");
    }
}

