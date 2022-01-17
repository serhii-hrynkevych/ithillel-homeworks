package serhii.hrynkevych;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Character king = new King();
        Character queen = new Queen();
        Character knight = new Knight();
        Character troll = new Troll();
        startMenu();
        while (true) {
            int[] numberWeaponBehavior = enteredWeaponBehavior();
            king.setWeapon(weaponBehavior(numberWeaponBehavior[0]));
            queen.setWeapon(weaponBehavior(numberWeaponBehavior[1]));
            knight.setWeapon(weaponBehavior(numberWeaponBehavior[2]));
            troll.setWeapon(weaponBehavior(numberWeaponBehavior[3]));
            king.fight();
            queen.fight();
            knight.fight();
            troll.fight();

            System.out.println("Продолжаем игру? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            if (command.equals("n")) {
                System.out.println("Игра окончена");
                break;
            }
            System.out.println("Выбери оружие");
        }
    }

    public static void startMenu() {
        System.out.println("Для игры выбери кто какое оружие выбирает: ");
        System.out.println("1 - Удар мечом; 2 - Удар ножом; 3 - Выстрел из лука; 4 - Удар топором");
        System.out.println("");
    }

    public static WeaponBehavior weaponBehavior(int num) {
        if (num == 1) {
            return new SwordBehavior();
        }
        if (num == 2) {
            return new KnifeBehavior();
        }
        if (num == 3) {
            return new BowAndArrowBehavior();
        }
        if (num == 4) {
            return new AxeBehavior();
        }
        return null;
    }

    public static int[] enteredWeaponBehavior() {
        int[] numberWeaponBehavior = new int[4];
        System.out.print("Ход короля - ");
        numberWeaponBehavior[0] = enteredNumberWeapon();
        System.out.print("Ход королевы - ");
        numberWeaponBehavior[1] = enteredNumberWeapon();
        System.out.print("Ход рыцаря - ");
        numberWeaponBehavior[2] = enteredNumberWeapon();
        System.out.print("Ход тролля - ");
        numberWeaponBehavior[3] = enteredNumberWeapon();
        return numberWeaponBehavior;
    }

    public static int enteredNumberWeapon() {
        Scanner scanner = new Scanner(System.in);
        int inputNumber;
        try {
            inputNumber = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.print("Некорректный ввод, повтори - ");
            return enteredNumberWeapon();
        }
        if (inputNumber == 1 || inputNumber == 2 || inputNumber == 3 || inputNumber == 4) {
            return inputNumber;
        }
        System.out.print("Неизвестное оружие, повтори ввод - ");
        return enteredNumberWeapon();
    }
}
