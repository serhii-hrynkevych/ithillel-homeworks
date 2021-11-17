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
        Flower[] bouquet = new Flower[numberOfFlowers];
        List<Flower> flowersList = new ArrayList<>();
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

        for (Flower flower : flowersList) {
            int price = flower.getPrice();
            totalCost += price;
        }

        System.out.println("Стоимость букета - " + totalCost);
    }

    public static Flower getRandomFlower() {
        int randomNumber = (int) (Math.random() * 3);
        switch (randomNumber) {
            case 0:
                return new Rose(Flowers.ROSE.getDescription(), Flowers.ROSE.getPrice());
            case 1:
                return new Carnation(Flowers.CARNATION.getDescription(), Flowers.CARNATION.getPrice());
            case 2:
                return new Tulip(Flowers.TULIP.getDescription(), Flowers.TULIP.getPrice());
            case 3:
                return new Aster(Flowers.ASTER.getDescription(), Flowers.ASTER.getPrice());
        }
        return null;
    }
}
