package serhii.hrynkevych;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class Main {
    public static void main( String[] args ) {
        String filePath = "C:\\java\\homeworks\\lesson19_ex28\\app\\src\\main\\resources\\journal_ru.json";
        List<DayJournal> journal = gsonMethod(filePath);
        //outputData(journal);
        Journal journalClass = new Journal(journal);
        Set<String> uniqueEvents = journalClass.selectionUniqueEvents();

        System.out.println("Для корреляции > 0.1 или < -0.1");
        for (String event : uniqueEvents) {
            String outputLine = journalClass.correlation(event);
            if (!(outputLine == null)) {
                System.out.println(outputLine);
            }
        }
        System.out.println();

        System.out.println("Для нового события \"арахис-зубы\"");
        journalClass.addNewEvent();
        System.out.println(journalClass.correlation("арахис-зубы"));
    }

    public static List<DayJournal> gsonMethod(String filePath) {
        List<DayJournal> journal = new ArrayList<>();
        Gson gson = new Gson();
        try (Reader reader = new FileReader(filePath)) {
            journal = Arrays.asList(gson.fromJson(reader, DayJournal[].class));
        } catch (IOException e) {
            System.out.println("Error while opening the file");
        }
        return journal;
    }

    public static void outputData(List<DayJournal> journal) {
        for (DayJournal dayJournal : journal) {
            System.out.println(dayJournal);
        }
    }
}
