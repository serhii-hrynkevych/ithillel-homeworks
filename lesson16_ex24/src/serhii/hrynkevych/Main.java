package serhii.hrynkevych;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator(10, -5, 7);
        List<Integer> myList = numberGenerator.generateList();
        System.out.println(myList);
        Set<Integer> mySet = numberGenerator.generateSet();
        System.out.println(mySet);
    }
}
