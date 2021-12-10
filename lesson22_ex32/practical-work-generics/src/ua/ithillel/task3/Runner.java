package ua.ithillel.task3;

import java.util.Arrays;

public class Runner {

    public void run() {
        Integer[] arrayInteger = new Integer[40];
        for (int i = 0; i < arrayInteger.length; i++) {
            arrayInteger[i] = i;
        }
        String[] arrayString = new String[40];
        for (int i = 0; i < arrayString.length; i++) {
            arrayString[i] = "V_" + i;
        }
        System.out.println("Practical number 3");
        System.out.println("Integer array: " + Arrays.toString(arrayInteger));
        System.out.println("String array: " + Arrays.toString(arrayString));

        System.out.println();

        MyMixer<Integer> integerMyMixer = new MyMixer<>(arrayInteger);
        System.out.println("Mix Integer Array:");
        System.out.println(Arrays.toString(integerMyMixer.shuffle()));

        System.out.println("Mix String Array:");
        MyMixer<String> stringMyMixer = new MyMixer<>(arrayString);
        System.out.println(Arrays.toString(stringMyMixer.shuffle()));
    }
}
