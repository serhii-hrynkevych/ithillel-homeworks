package serhii.hrynkevych;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Drinks.values()));
        System.out.println(Arrays.toString(Menu.values()));
        try {
            System.out.println(Drinks.drinksValueOf("YES1"));
            System.out.println(Menu.menuValueOf("SOUP"));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при работе с методами 'values' и 'valueOf'");
        }

        Passenger pasPetrov = new Passenger("Василий", "Петров", 123456);
        Passenger pasSidorov = new Passenger("Саша", "Сидоров", 654321);

        FlightInfo flightFromKyivToParis = new FlightInfo(23675, "Киев", "Париж", 12.30, 1000);

        Ticket t1 = new Ticket(7, flightFromKyivToParis, pasPetrov);
                Ticket t2 = new VipTicket(
             2,
             flightFromKyivToParis,
             pasSidorov,
             new Meal(Menu.DESSERT, Drinks.YES),
             new Baggage(2, 20)
        );

        System.out.println(t1 + "\n" + t1.getCost());
        System.out.println(t2 + "\n" + t2.getCost());
    }
}
