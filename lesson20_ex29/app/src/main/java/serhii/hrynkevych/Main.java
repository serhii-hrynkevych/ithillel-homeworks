package serhii.hrynkevych;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MyPhoneBook myPhoneBook = new MyPhoneBook();

        label:
        while (true) {
            questions();
            String inputCommand = inputLine();
            int command = workProgram(inputCommand);
            switch (command) {
                case 1:
                    String inputLine = enterNewPhone();
                    System.out.println(addNewPhone(myPhoneBook, inputLine));
                    break;
                case 2:
                    myPhoneBook.printPhoneBook();
                    break;
                case 0:
                    break label;
                case 9:
                    System.out.println("Некоректный выбор действия\n");
                    break;
            }
        }

        System.out.println();
        System.out.println("Sorting:");
        myPhoneBook.sortByName();
        myPhoneBook.printPhoneBook();
        myPhoneBook.sortByPhoneNumber();
        myPhoneBook.printPhoneBook();
    }

    public static String inputLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void questions() {
        System.out.println("Что будем делать?):");
        System.out.println("1. Добавление новой записи в телефонную книгу");
        System.out.println("2. Отображение содержимого телефонной книги");
        System.out.println("0. Выход");
    }

    public static int workProgram(String inputCommand) {
        switch (inputCommand) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "0":
                return 0;
            default:
                return 9;
        }
    }

    public static String enterNewPhone() {
        System.out.println("Введите новую запись в формате <<name, phone>>");
        return inputLine();
    }

    public static String addNewPhone(MyPhoneBook myPhoneBook, String inputLine) {
        boolean addedNewPhone = myPhoneBook.addPhoneNumber(inputLine);
        if (addedNewPhone) {
            return "Новая запись успешно добавлена\n";
        } else {
            return "Видимо был некооректный ввод - не удалось добавить новую запись\n";
        }
    }
}
