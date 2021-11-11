package serhii.hrynkevych;

public class Passenger {
    private final String name;
    private final String lastName;
    private final long passport;

    public Passenger(String name, String lastName, long passport) {
        this.name = name;
        this.lastName = lastName;
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "PassengerInfo{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passport=" + passport +
                '}';
    }
}
