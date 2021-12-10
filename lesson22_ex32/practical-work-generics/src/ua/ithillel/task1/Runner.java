package ua.ithillel.task1;

import java.util.Arrays;

public class Runner {

    public void run(){
        Integer[] arrayInteger = new Integer[40];
        for (int i = 0; i < arrayInteger.length; i++) {
            arrayInteger[i] = i;
        }
        Double[] arrayDouble = new Double[40];
        for (int i = 0; i < arrayDouble.length; i++) {
            arrayDouble[i] = (double) i;
        }
        System.out.println("Integer array: " + Arrays.toString(arrayInteger));
        System.out.println("Double array: " + Arrays.toString(arrayDouble));

        System.out.println();

        System.out.println(MyTestMethod.calcNum(arrayInteger, 5));
        System.out.println(MyTestMethod.calcNum(arrayDouble, 6));

        System.out.println();

        System.out.println(MyTestMethod.calcSum(arrayInteger, 5));
        System.out.println(MyTestMethod.calcSum(arrayDouble, 6.0f));
    }
}
