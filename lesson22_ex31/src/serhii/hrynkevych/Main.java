package serhii.hrynkevych;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Type Integer:");
        Integer[] array = {1, 2, 3, 4, 5, 6};
        DataStructure<Integer> dataStructure = new DataStructure<>(array);
        dataStructure.printEven();
        System.out.println("---");

        Iterator<Integer> iterator = dataStructure.evenIterator(2);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nTest 2"); //просто, что б посмотреть что и как
        System.out.println("Type String:");

        String[] array1 = {"1", "2", "3", "4", "5", "6"};
        DataStructure<String> dataStructure1 = new DataStructure<>(array1);
        dataStructure1.printEven();
        System.out.println("---");

        Iterator<String> iterator1 = dataStructure1.evenIterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
    }
}
