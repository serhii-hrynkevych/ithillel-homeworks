package serhii.hrynkevych;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MyTranslator {
    private final HashMap<String, String> dictionary;

    public MyTranslator() {
        this.dictionary = new HashMap<>();
    }

    public void addWords(String engWord, String rusWord) {
        this.dictionary.put(engWord, rusWord);
    }

    public void translate(String input) {
        String[] inputArray = input.split(" ");
        List<String> notFoundWord = new ArrayList<>();
        for (int i = 0; i < inputArray.length; i++) {
            if (i != 0 && dictionary.containsKey(inputArray[i])) {
                System.out.print(" ");
            }
            if (dictionary.containsKey(inputArray[i])) {
                System.out.print(dictionary.get(inputArray[i]));
            } else {
                notFoundWord.add(inputArray[i]);
            }
        }
        System.out.println(".");
        if (!notFoundWord.isEmpty()) {
            System.out.println("Слова, которые не удалось перевести:");
            System.out.println(notFoundWord);
        }

//        List<String> outArray = new ArrayList<>();
//        for (String s : inputArray) {
//            if (dictionary.containsKey(s)) {
//                outArray.add(dictionary.get(s));
//            } else {
//                notFoundWord.add(s);
//            }
//        }
//        for (int i = 0; i < outArray.size(); i++) {
//            System.out.print(outArray.get(i));
//            if (i != outArray.size() - 1) {
//                System.out.print(" ");
//            } else {
//                System.out.println(".");
//            }
//        }
    }
}
