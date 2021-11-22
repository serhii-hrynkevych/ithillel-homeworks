package serhii.hrynkevych;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        System.out.println("Задания 1, 2");
        List<String> listArray = addedElementListArray(10);
        System.out.println(listArray);
        //List<String> listLink = addedElementLinkedList(10);
        List<String> listLink = addedElementLinkedListToo(10);
        System.out.println(listLink);
        System.out.println();
        System.out.println("***");
        System.out.println("Задание 3");
        System.out.println(listArray);
        System.out.println(listLink);
        ex3(listArray, listLink);
        System.out.println();
        System.out.println("***");
        System.out.println("Задание 4");
        System.out.println(listArray);
        System.out.println(listLink);
        ex4(listArray, listLink);
        System.out.println();
        System.out.println("***");
        System.out.println("Задание 5");
        System.out.println(listLink);
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
            int indexRandom = (int) (Math.random() * listLink.size());
            listLink.add(indexRandom, "li_" + i);
        }
        return listLink;
    }

    public static List<String> addedElementLinkedListToo(int elements) {
        List<String> listLink = new LinkedList<>();
        for (int i = 0; i < elements; i++) {
            int indexRandom = (int) (Math.random() * listLink.size());
            if (indexRandom == listLink.size()) {
                listLink.add(indexRandom, "li_" + indexRandom);
            } else {
                listLink.add(indexRandom, "li_" + indexRandom);
                for (int j = indexRandom + 1; j < listLink.size(); j++) {
                    listLink.remove(j);
                    listLink.add(j, "li_" + j);
                }
            }
        }
        return listLink;
    }

    public static void ex3 (List<String> listArray, List<String> listLink) {
        ListIterator<String> listIteratorEx3 = listArray.listIterator(listArray.size());
        while (listIteratorEx3.hasPrevious()) {
            int indexAdd = Math.abs(((listIteratorEx3.previousIndex() + 1) - listLink.size()));
            listLink.add(indexAdd, listIteratorEx3.previous());
        }
        System.out.println(listLink);

        listIteratorEx3 = listArray.listIterator(listArray.size());
        while (listIteratorEx3.hasPrevious()) {
            int indexRemove = Math.abs(((listIteratorEx3.previousIndex() + 1) - listArray.size()));
            listLink.remove(indexRemove);
            listIteratorEx3.previous();
        }
    }

    public static void ex4 (List<String> listArray, List<String> listLink) {
        ListIterator<String> listIteratorEx4 = listArray.listIterator(listArray.size());
        int nextIndexAdd = 0;
        while (listIteratorEx4.hasPrevious()) {
            if (nextIndexAdd <= listLink.size()) {
                listLink.add(nextIndexAdd, listIteratorEx4.previous());
                nextIndexAdd +=3;
            } else {
                listLink.add(listIteratorEx4.previous());
            }
        }
        System.out.println(listLink);
    }
}
