package serhii.hrynkevych;

public enum Drinks {
    YES(0, "С напитками", 50),
    NO(1, "Без напитков", 0);

    private final int var;
    private final String description;
    private final int price;

    Drinks(int var, String description, int price) {
        this.var = var;
        this.description = description;
        this.price = price;
    }

    public int getVar() {
        return var;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }


    public static Drinks[] drinksValues() {
        return values();
    }

    public static Drinks drinksValueOf(String name) {
        return valueOf(name);
    }

    @Override
    public String toString() {
        return "Drink{" +
                "var=" + var +
                ", description='" + description + '\'' +
                ", price=" + price + "$" +
                '}';
    }
}
