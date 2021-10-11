package serhii.hrynkevych;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        long elapsedTime;

        int[] array1000 = addedDataArrays(1000);
        int searchValue1000 = addedSearchValue(1000, array1000);
        int[] array1000000 = addedDataArrays(1000000);
        int searchValue1000000 = addedSearchValue(1000000, array1000000);

        elapsedTime = simpleSearch(array1000, searchValue1000); //в условии ДЗ указано вывести время работы каждого метода))
        System.out.println("Затраченое время для простого поиска в массиве на 1000 элементов: " + elapsedTime);

        elapsedTime = simpleSearch(array1000000, searchValue1000000); //в условии ДЗ указано вывести время работы каждого метода))
        System.out.println("Затраченое время для простого поиска в массиве на 1000000 элементов: " + elapsedTime);
        System.out.println();

        elapsedTime = binarySearch(array1000, searchValue1000); //в условии ДЗ указано вывести время работы каждого метода))
        System.out.println("Затраченое время для бинарного поиска в массиве на 1000 элементов: " + elapsedTime);

        elapsedTime = binarySearch(array1000000, searchValue1000000); //в условии ДЗ указано вывести время работы каждого метода))
        System.out.println("Затраченое время для бинарного поиска в массиве на 1000000 элементов: " + elapsedTime);
        System.out.println();

        elapsedTime = quickSort(array1000);
        System.out.println("Затраченое время для быстрой сортировки в массиве на 1000 элементов: " + elapsedTime);

        elapsedTime = quickSort(array1000000);
        System.out.println("Затраченое время для быстрой сортировки в массиве на 1000000 элементов: " + elapsedTime);
        System.out.println();

        elapsedTime = insertionSort(array1000);
        System.out.println("Затраченое время для сортировки вставками в массиве на 1000 элементов: " + elapsedTime);

        elapsedTime = insertionSort(array1000000);
        System.out.println("Затраченое время для сортировки вставками в массиве на 1000000 элементов: " + elapsedTime);
    }

    private static int[] addedDataArrays(int amountElements) {
        int[] array = new int[amountElements];
        for (int i = 0; i < amountElements; i++) {
            array[i] = (int) Math.round((Math.random() * amountElements)); //рандомно заполняю элементы массива
        }
        return array;
    }

    private static int addedSearchValue(int amountElements, int[] array) {
        int numberSearchArray = (int) Math.round((Math.random() * amountElements)); //рандомно назначаю элемент для поиска
        return array[numberSearchArray];
    }

    private static long simpleSearch(int[] array, int searchValue) {
        long start, end, elapsedTime;
        start = System.nanoTime();
        for (int j : array) {
            if (j == searchValue) {
                break;
            }
        }
        end = System.nanoTime();
        elapsedTime = end - start;
        return elapsedTime;
    }

    private static long binarySearch(int[] array, int searchValue) {
        long start, end, elapsedTime;
        Arrays.sort(array);
        start = System.nanoTime();
        int firstElement = 0;
        int lastElement = array.length - 1;
        while (firstElement < lastElement) {
            int middleElement = (firstElement + lastElement) / 2;
            if (array[middleElement] == searchValue) {
                break;
            } else if (array[middleElement] < searchValue) {
                firstElement = middleElement + 1;
            } else if (array[middleElement] > searchValue) {
                lastElement = middleElement - 1;
            }
        }
        end = System.nanoTime();
        elapsedTime = end - start;
        return elapsedTime;
    }

    public static long quickSort(int[] array) {
        long start, end, elapsedTime;
        int[] arrayNew = new int[array.length];
        System.arraycopy(array, 0, arrayNew, 0, array.length);
        start = System.nanoTime();
        workQuickSort(arrayNew, 0, arrayNew.length - 1);
        end = System.nanoTime();
        elapsedTime = end - start;
        return elapsedTime;
    }

    public static void workQuickSort(int[] array, int firstElement, int lastElement) {
        int leftMarker = firstElement;
        int rightMarker = lastElement;
        int middle = array[(leftMarker + rightMarker) / 2];
        do {
            while (array[leftMarker] < middle) {
                leftMarker++;
            }
            while (array[rightMarker] > middle) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int tmp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = tmp;
                }
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);
        if (leftMarker < lastElement) {
            workQuickSort(array, leftMarker, lastElement);
        }
        if (firstElement < rightMarker) {
            workQuickSort(array, firstElement, rightMarker);
        }
    }

    private static long insertionSort(int[] array) {
        long start, end, elapsedTime;
        start = System.nanoTime();
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
        end = System.nanoTime();
        elapsedTime = end - start;
        return elapsedTime;
    }
}
