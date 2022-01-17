package serhii.hrynkevych;

public class VipTicket extends Ticket{
    private final Meal meal;
    private final Baggage baggage;

    public VipTicket(int sitNumber, FlightInfo flightInfo, Passenger passenger, Meal meal, Baggage baggage) {
        super(sitNumber, flightInfo, passenger);
        this.meal = meal;
        this.baggage = baggage;
    }

    @Override
    public int getCost() {
        return super.getCost() + meal.getPrice() + baggage.getFee();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "sitNumber=" + super.getSitNumber() +
                ", flightInfo=" + getFlightInfo() +
                ", passengerInfo=" + getPassenger() +
                ", meal=" + meal +
                ", baggage=" + baggage +
                ", ticket price=" + getCost() + "$" +
                '}';
    }
}
