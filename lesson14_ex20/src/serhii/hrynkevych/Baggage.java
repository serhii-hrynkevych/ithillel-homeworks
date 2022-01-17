package serhii.hrynkevych;

public class Baggage {
    private final int amount;
    private final int customFee;

    public Baggage(int amount, int customFee) {
        this.amount = amount;
        this.customFee = customFee;
    }

    public int getFee() {
        return amount * customFee;
    }

    @Override
    public String toString() {
        return "Baggage{" +
                "amount=" + amount +
                ", fee=" + getFee() +
                '}';
    }
}
