package serhii.hrynkevych;

public class Ticket {
    private final int sitNumber;
    private final FlightInfo flightInfo;
    private final Passenger passenger;

    public Ticket(int sitNumber, FlightInfo flightInfo, Passenger passenger) {
        this.sitNumber = sitNumber;
        this.flightInfo = flightInfo;
        this.passenger = passenger;
    }

    public int getCost() {
        return flightInfo.getCost();
    }

    public int getSitNumber() {
        return sitNumber;
    }

    public FlightInfo getFlightInfo() {
        return flightInfo;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "sitNumber=" + sitNumber +
                ", flightInfo=" + flightInfo +
                ", passengerInfo=" + passenger +
                ", ticket price=" + getCost() + "$" +
                '}';
    }
}
