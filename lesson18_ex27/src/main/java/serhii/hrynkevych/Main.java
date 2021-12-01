package serhii.hrynkevych;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class Main {
    public static void main( String[] args ) {
        String filePath = "C:\\java\\homeworks\\lesson18_ex27\\src\\main\\resources\\journal_ru.json";
        List<DayJournal> journal = gsonMethod(filePath);
        outputData(journal);
        System.out.println();

        Set<String> uniqueEvents = selectionUniqueEvents(journal);

        System.out.println("Для корреляции > 0.1 или < -0.1");
        for (String event : uniqueEvents) {
            correlation(event, journal);
        }
        System.out.println();

        System.out.println("Для нового события");
        addNewEvent(journal);
        correlation("арахис-зубы", journal);
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

    public static Set<String> selectionUniqueEvents (List<DayJournal> journal) {
        Set<String> events = new HashSet<>();
        for (DayJournal day : journal) {
            events.addAll(day.getEvents());
        }
        return events;
    }

    public static void correlation (String event, List<DayJournal> journal) {
        int [] countUniqueEvents = countNewUniqueEvent(event, journal);
        double kor = kor(countUniqueEvents);
        outputKor(event, kor);
    }

    public static int[] countNewUniqueEvent(String event, List<DayJournal> journal) {
        int[] table = new int[4];
        for (DayJournal day : journal) {
            boolean includesEvent = includesEvent(event, day.getEvents());
            if (!includesEvent && !day.isSquirrel()) {
                table[0]++;
            }
            if (includesEvent && !day.isSquirrel()) {
                table[1]++;
            }
            if (!includesEvent && day.isSquirrel()) {
                table[2]++;
            }
            if (includesEvent && day.isSquirrel()) {
                table[3]++;
            }
        }
        return table;
    }

    private static boolean includesEvent(String event, List<String> day) {
        return day.contains(event);
    }

    public static double kor(int[] countUniqueEvents) {
        int tabl0 = countUniqueEvents[0];
        int tabl1 = countUniqueEvents[1];
        int tabl2 = countUniqueEvents[2];
        int tabl3 = countUniqueEvents[3];
        return (tabl3 * tabl0 - tabl2 * tabl1) / Math.sqrt((tabl2 + tabl3) * (tabl0 + tabl1) * (tabl1 + tabl3) * (tabl0 + tabl2));
    }

    public static void outputKor(String event, double kor) {
        if (-0.1 > kor || kor > 0.1) {
            System.out.println(event + " = " + kor);
        }
    }

    public static void addNewEvent(List<DayJournal> journal) {
        for (DayJournal day : journal) {
            if (includesEvent("ел арахис", day.getEvents()) && !includesEvent("чистил зубы", day.getEvents())) {
                day.setEvents("арахис-зубы");
            }
        }
    }
}
