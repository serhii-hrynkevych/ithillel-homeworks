package serhii.hrynkevych;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введи строку с условием:");
        String str = scanner.nextLine();
        String[] splittingStr = str.split(" ");
        if (splittingStr.length != 3) {
            errorEntered();
        }

        Fraction num1 = new Fraction(splittingStr[0]);
        num1 = new Fraction(num1.getIntPart(), num1.getDecimalPart());
        Fraction num2 = new Fraction(splittingStr[2]);
        num2 = new Fraction(num2.getIntPart(), num2.getDecimalPart());

        if (splittingStr[1].equals("plus")) {
            System.out.println(Arrays.toString(Fraction.addition(num1, num2)));
        }
        else if (splittingStr[1].equals("minus")) {
            System.out.println(Arrays.toString(Fraction.subtraction(num1, num2)));
        }
        else {
            errorEntered();
        }
    }

    public static void errorEntered() {
        System.out.println("Условие не корректно");
        System.exit(1);
    }
}
