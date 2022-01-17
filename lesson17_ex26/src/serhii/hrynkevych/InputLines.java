package serhii.hrynkevych;

public class InputLines {
    private final String clientName;
    private final String goodDescription;
    private final int price;

    public InputLines(String[] inputData) {
        this.clientName = inputData[0];
        this.goodDescription = inputData[1];
        this.price = Integer.parseInt(inputData[2]);
    }

    public String getClientName() {
        return clientName;
    }

    public String getGoodDescription() {
        return goodDescription;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return clientName +
                " " + goodDescription +
                " " + price;
    }
}
