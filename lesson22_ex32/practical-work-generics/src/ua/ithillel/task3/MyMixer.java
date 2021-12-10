package ua.ithillel.task3;

import java.util.Random;

public class MyMixer<T> {
    private final T[] array;

    public MyMixer(T[] array) {
        this.array = array;
    }

    public T[] shuffle() {
        Random rnd = new Random();
        for (int i = 1; i < array.length; i++) {
            int j = rnd.nextInt(i);
            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}
