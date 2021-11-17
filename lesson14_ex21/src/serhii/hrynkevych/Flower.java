package serhii.hrynkevych;

public abstract class Flower {
    private final String description;
    private final int price;

    public Flower(String description, int price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return description + " (" + price + ")";
    }
}
