package serhii.hrynkevych;

public enum Flowers {
    ROSE("Роза", 25),
    CARNATION("Гвоздика", 10),
    TULIP("Тюльпан", 15),
    ASTER("Астра", 20);

    private final String description;
    private final int price;

    Flowers(String description, int price) {
        this.description = description;
        this.price = price;
    }


    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return description + " (" + price + ")";
    }
}
