package serhii.hrynkevych;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        List<String> listArray = addedElementListArray(10);
        List<String> listLink = addedElementLinkedList(10);
        System.out.println("Задания №№1, 2:");
        System.out.println(listArray);
        System.out.println(listLink);
        System.out.println();
        System.out.println("Задание №№3:");
        System.out.println(listArray);
        System.out.println(listLink);
        ex3(listArray, listLink);
        System.out.println();
        System.out.println("Задание №№4:");
        System.out.println(listArray);
        System.out.println(listLink);
        ex4(listArray, listLink);
    }

    public static List<String> addedElementListArray(int elements) {
        List<String> listArray = new ArrayList<>();
        for (int i = 0; i < elements; i++) {
            listArray.add("ar_" + i);
        }
        return listArray;
    }

    public static List<String> addedElementLinkedList(int elements) {
        List<String> listLink = new LinkedList<>();
        for (int i = 0; i < elements; i++) {
            listLink.add("li_" + i);
        }
        return listLink;
    }

    public static void ex3 (List<String> listArray, List<String> listLink) {
        List<String> listLinkEx3 = new LinkedList<>(listLink);
        ListIterator<String> listIteratorEx3 = listArray.listIterator(listArray.size());
        while (listIteratorEx3.hasPrevious()) {
            int indexAdd = Math.abs(((listIteratorEx3.previousIndex() + 1) - listLinkEx3.size()));
            listLinkEx3.add(indexAdd, listIteratorEx3.previous());
        }
        System.out.println(listLinkEx3);
    }

    public static void ex4 (List<String> listArray, List<String> listLink) {
        List<String> listLinkEx4 = new LinkedList<>(listLink);
        ListIterator<String> listIteratorEx4 = listArray.listIterator(listArray.size());
        int nextIndexAdd = 0;
        while (listIteratorEx4.hasPrevious()) {
            if (nextIndexAdd <= listLinkEx4.size()) {
                listLinkEx4.add(nextIndexAdd, listIteratorEx4.previous());
                nextIndexAdd +=3;
            } else {
                listLinkEx4.add(listIteratorEx4.previous());
            }
        }
        System.out.println(listLinkEx4);
    }
}
