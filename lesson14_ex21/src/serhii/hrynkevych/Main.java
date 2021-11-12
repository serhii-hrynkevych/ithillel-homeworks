package serhii.hrynkevych;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите желаемое кол-во цветов в букете: ");
        int numberOfFlowers = scanner.nextInt();
        int totalCost = 0;
        Flowers[] bouquet = new Flowers[numberOfFlowers];
        List<Flowers> flowersList = new ArrayList<>();
        for (int i = 0; i < numberOfFlowers; i++) {
            bouquet[i] = getRandomFlower();
            flowersList.add(getRandomFlower());
        }

//        for (int i = 0; i < bouquet.length; i++) {
//            System.out.print("#" + (i + 1) + " ");
//            System.out.println(bouquet[i]);
//        }
//
//        for (int i = 0; i < bouquet.length; i++) {
//            assert bouquet[i] != null;
//            int price = bouquet[i].getPrice();
//            totalCost += price;
//        }

        for (int i = 0; i < flowersList.size(); i++) {
            System.out.print("#" + (i + 1) + " ");
            System.out.println(flowersList.get(i));
        }

        for (Flowers flowers : flowersList) {
            int price = flowers.getPrice();
            totalCost += price;
        }

        System.out.println("Стоимость букета - " + totalCost);
    }

    public static Flowers getRandomFlower() {
        int randomNumber = (int) (Math.random() * 3);
        switch (randomNumber) {
            case 0:
                return Flowers.ROSE;
            case 1:
                return Flowers.CARNATION;
            case 2:
                return Flowers.TULIP;
            case 3:
                return Flowers.ASTER;
        }
        return null;
    }
}
