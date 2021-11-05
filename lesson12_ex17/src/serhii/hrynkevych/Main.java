package serhii.hrynkevych;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введи ключ: ");
            String key = scanner.nextLine();
            Animal animal = AnimalFactory.getAnimalByKey(key);
            if (animal == null) {
                System.out.println("Не могу создать Animal. Повтори ввод ключа.");
            } else {
                System.out.println(animal.getName());
                break;
            }
        }
    }
}
